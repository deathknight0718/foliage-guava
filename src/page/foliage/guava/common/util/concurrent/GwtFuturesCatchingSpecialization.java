/*
 * Copyright (C) 2006 The Guava Authors
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

package page.foliage.guava.common.util.concurrent;

import page.foliage.guava.common.annotations.GwtCompatible;
import page.foliage.guava.common.annotations.J2ktIncompatible;

/**
 * Hidden superclass of {@link Futures} that provides us a place to declare special GWT versions of
 * the {@link Futures#catching(ListenableFuture, Class, page.foliage.guava.common.base.Function,
 * java.util.concurrent.Executor) Futures.catching} family of methods. Those versions have slightly
 * different signatures.
 */
@GwtCompatible(emulated = true)
@J2ktIncompatible // Super-sourced
@ElementTypesAreNonnullByDefault
abstract class GwtFuturesCatchingSpecialization {
  /*
   * This server copy of the class is empty. The corresponding GWT copy contains alternative
   * versions of catching() and catchingAsync() with slightly different signatures from the ones
   * found in Futures.java.
   */
}
