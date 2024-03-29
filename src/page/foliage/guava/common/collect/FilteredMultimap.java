/*
 * Copyright (C) 2012 The Guava Authors
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

import java.util.Map.Entry;

import org.checkerframework.checker.nullness.qual.Nullable;

import page.foliage.guava.common.annotations.GwtCompatible;
import page.foliage.guava.common.base.Predicate;

/**
 * An interface for all filtered multimap types.
 *
 * @author Louis Wasserman
 */
@GwtCompatible
@ElementTypesAreNonnullByDefault
interface FilteredMultimap<K extends @Nullable Object, V extends @Nullable Object>
    extends Multimap<K, V> {
  Multimap<K, V> unfiltered();

  Predicate<? super Entry<K, V>> entryPredicate();
}
