/*
 * Copyright (C) 2009 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package page.foliage.guava.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.annotation.CheckForNull;

import page.foliage.guava.common.annotations.GwtCompatible;
import page.foliage.guava.common.annotations.GwtIncompatible;
import page.foliage.guava.common.annotations.J2ktIncompatible;

/**
 * List returned by {@link ImmutableCollection#asList} that delegates {@code contains} checks to the
 * backing collection.
 *
 * @author Jared Levy
 * @author Louis Wasserman
 */
@GwtCompatible(serializable = true, emulated = true)
@SuppressWarnings("serial")
@ElementTypesAreNonnullByDefault
abstract class ImmutableAsList<E> extends ImmutableList<E> {
  abstract ImmutableCollection<E> delegateCollection();

  @Override
  public boolean contains(@CheckForNull Object target) {
    // The collection's contains() is at least as fast as ImmutableList's
    // and is often faster.
    return delegateCollection().contains(target);
  }

  @Override
  public int size() {
    return delegateCollection().size();
  }

  @Override
  public boolean isEmpty() {
    return delegateCollection().isEmpty();
  }

  @Override
  boolean isPartialView() {
    return delegateCollection().isPartialView();
  }

  /** Serialized form that leads to the same performance as the original list. */
  @GwtIncompatible // serialization
  @J2ktIncompatible
  static class SerializedForm implements Serializable {
    final ImmutableCollection<?> collection;

    SerializedForm(ImmutableCollection<?> collection) {
      this.collection = collection;
    }

    Object readResolve() {
      return collection.asList();
    }

    private static final long serialVersionUID = 0;
  }

  @GwtIncompatible // serialization
  @J2ktIncompatible
  private void readObject(ObjectInputStream stream) throws InvalidObjectException {
    throw new InvalidObjectException("Use SerializedForm");
  }

  @GwtIncompatible // serialization
  @J2ktIncompatible
  @Override
  Object writeReplace() {
    return new SerializedForm(delegateCollection());
  }
}
