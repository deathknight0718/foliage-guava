/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package page.foliage.guava.common.base;

import static page.foliage.guava.common.base.NullnessCasts.uncheckedCastNullableTToT;
import static page.foliage.guava.common.base.Preconditions.checkState;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.annotation.CheckForNull;

import org.checkerframework.checker.nullness.qual.Nullable;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

import page.foliage.guava.common.annotations.GwtCompatible;

/**
 * Note this class is a copy of {@link page.foliage.guava.common.collect.AbstractIterator} (for dependency
 * reasons).
 */
@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractIterator<T extends @Nullable Object> implements Iterator<T> {
  private State state = State.NOT_READY;

  protected AbstractIterator() {}

  private enum State {
    READY,
    NOT_READY,
    DONE,
    FAILED,
  }

  @CheckForNull private T next;

  @CheckForNull
  protected abstract T computeNext();

  @CanIgnoreReturnValue
  @CheckForNull
  protected final T endOfData() {
    state = State.DONE;
    return null;
  }

  @Override
  public final boolean hasNext() {
    checkState(state != State.FAILED);
    switch (state) {
      case DONE:
        return false;
      case READY:
        return true;
      default:
    }
    return tryToComputeNext();
  }

  private boolean tryToComputeNext() {
    state = State.FAILED; // temporary pessimism
    next = computeNext();
    if (state != State.DONE) {
      state = State.READY;
      return true;
    }
    return false;
  }

  @Override
  @ParametricNullness
  public final T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    state = State.NOT_READY;
    // Safe because hasNext() ensures that tryToComputeNext() has put a T into `next`.
    T result = uncheckedCastNullableTToT(next);
    next = null;
    return result;
  }

  @Override
  public final void remove() {
    throw new UnsupportedOperationException();
  }
}
