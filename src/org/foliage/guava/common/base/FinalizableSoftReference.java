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

package org.foliage.guava.common.base;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import org.foliage.guava.common.annotations.GwtIncompatible;

/**
 * Soft reference with a {@code finalizeReferent()} method which a background thread invokes after
 * the garbage collector reclaims the referent. This is a simpler alternative to using a {@link
 * ReferenceQueue}.
 *
 * @author Bob Lee
 * @since 2.0
 */
@GwtIncompatible
public abstract class FinalizableSoftReference<T> extends SoftReference<T>
    implements FinalizableReference {
  /**
   * Constructs a new finalizable soft reference.
   *
   * @param referent to softly reference
   * @param queue that should finalize the referent
   */
  protected FinalizableSoftReference(T referent, FinalizableReferenceQueue queue) {
    super(referent, queue.queue);
    queue.cleanUp();
  }
}
