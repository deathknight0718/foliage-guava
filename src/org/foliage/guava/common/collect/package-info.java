/*
 * Copyright (C) 2007 The Guava Authors
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

/**
 * This package contains generic collection interfaces and implementations, and other utilities for
 * working with collections. It is a part of the open-source <a
 * href="http://github.com/google/guava">Guava</a> library.
 *
 * <h2>Collection Types</h2>
 *
 * <dl>
 *   <dt>{@link org.foliage.guava.common.collect.BiMap}
 *   <dd>An extension of {@link java.util.Map} that guarantees the uniqueness of its values as well
 *       as that of its keys. This is sometimes called an "invertible map," since the restriction on
 *       values enables it to support an {@linkplain org.foliage.guava.common.collect.BiMap#inverse inverse
 *       view} -- which is another instance of {@code BiMap}.
 *   <dt>{@link org.foliage.guava.common.collect.Multiset}
 *   <dd>An extension of {@link java.util.Collection} that may contain duplicate values like a
 *       {@link java.util.List}, yet has order-independent equality like a {@link java.util.Set}.
 *       One typical use for a multiset is to represent a histogram.
 *   <dt>{@link org.foliage.guava.common.collect.Multimap}
 *   <dd>A new type, which is similar to {@link java.util.Map}, but may contain multiple entries
 *       with the same key. Some behaviors of {@link org.foliage.guava.common.collect.Multimap} are left
 *       unspecified and are provided only by the subtypes mentioned below.
 *   <dt>{@link org.foliage.guava.common.collect.ListMultimap}
 *   <dd>An extension of {@link org.foliage.guava.common.collect.Multimap} which permits duplicate entries,
 *       supports random access of values for a particular key, and has <i>partially order-dependent
 *       equality</i> as defined by {@link org.foliage.guava.common.collect.ListMultimap#equals(Object)}.
 *       {@code ListMultimap} takes its name from the fact that the {@linkplain
 *       org.foliage.guava.common.collect.ListMultimap#get collection of values} associated with a given
 *       key fulfills the {@link java.util.List} contract.
 *   <dt>{@link org.foliage.guava.common.collect.SetMultimap}
 *   <dd>An extension of {@link org.foliage.guava.common.collect.Multimap} which has order-independent
 *       equality and does not allow duplicate entries; that is, while a key may appear twice in a
 *       {@code SetMultimap}, each must map to a different value. {@code SetMultimap} takes its name
 *       from the fact that the {@linkplain org.foliage.guava.common.collect.SetMultimap#get collection of
 *       values} associated with a given key fulfills the {@link java.util.Set} contract.
 *   <dt>{@link org.foliage.guava.common.collect.SortedSetMultimap}
 *   <dd>An extension of {@link org.foliage.guava.common.collect.SetMultimap} for which the {@linkplain
 *       org.foliage.guava.common.collect.SortedSetMultimap#get collection values} associated with a given
 *       key is a {@link java.util.SortedSet}.
 *   <dt>{@link org.foliage.guava.common.collect.Table}
 *   <dd>A new type, which is similar to {@link java.util.Map}, but which indexes its values by an
 *       ordered pair of keys, a row key and column key.
 *   <dt>{@link org.foliage.guava.common.collect.ClassToInstanceMap}
 *   <dd>An extension of {@link java.util.Map} that associates a raw type with an instance of that
 *       type.
 * </dl>
 *
 * <h2>Collection Implementations</h2>
 *
 * <h3>of {@link java.util.List}</h3>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ImmutableList}
 * </ul>
 *
 * <h3>of {@link java.util.Set}</h3>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ImmutableSet}
 *   <li>{@link org.foliage.guava.common.collect.ImmutableSortedSet}
 *   <li>{@link org.foliage.guava.common.collect.ContiguousSet} (see {@code Range})
 * </ul>
 *
 * <h3>of {@link java.util.Map}</h3>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ImmutableMap}
 *   <li>{@link org.foliage.guava.common.collect.ImmutableSortedMap}
 *   <li>{@link org.foliage.guava.common.collect.MapMaker}
 * </ul>
 *
 * <h3>of {@link org.foliage.guava.common.collect.BiMap}</h3>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ImmutableBiMap}
 *   <li>{@link org.foliage.guava.common.collect.HashBiMap}
 *   <li>{@link org.foliage.guava.common.collect.EnumBiMap}
 *   <li>{@link org.foliage.guava.common.collect.EnumHashBiMap}
 * </ul>
 *
 * <h3>of {@link org.foliage.guava.common.collect.Multiset}</h3>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ImmutableMultiset}
 *   <li>{@link org.foliage.guava.common.collect.HashMultiset}
 *   <li>{@link org.foliage.guava.common.collect.LinkedHashMultiset}
 *   <li>{@link org.foliage.guava.common.collect.TreeMultiset}
 *   <li>{@link org.foliage.guava.common.collect.EnumMultiset}
 *   <li>{@link org.foliage.guava.common.collect.ConcurrentHashMultiset}
 * </ul>
 *
 * <h3>of {@link org.foliage.guava.common.collect.Multimap}</h3>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ImmutableMultimap}
 *   <li>{@link org.foliage.guava.common.collect.ImmutableListMultimap}
 *   <li>{@link org.foliage.guava.common.collect.ImmutableSetMultimap}
 *   <li>{@link org.foliage.guava.common.collect.ArrayListMultimap}
 *   <li>{@link org.foliage.guava.common.collect.HashMultimap}
 *   <li>{@link org.foliage.guava.common.collect.TreeMultimap}
 *   <li>{@link org.foliage.guava.common.collect.LinkedHashMultimap}
 *   <li>{@link org.foliage.guava.common.collect.LinkedListMultimap}
 * </ul>
 *
 * <h3>of {@link org.foliage.guava.common.collect.Table}</h3>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ImmutableTable}
 *   <li>{@link org.foliage.guava.common.collect.ArrayTable}
 *   <li>{@link org.foliage.guava.common.collect.HashBasedTable}
 *   <li>{@link org.foliage.guava.common.collect.TreeBasedTable}
 * </ul>
 *
 * <h3>of {@link org.foliage.guava.common.collect.ClassToInstanceMap}</h3>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ImmutableClassToInstanceMap}
 *   <li>{@link org.foliage.guava.common.collect.MutableClassToInstanceMap}
 * </ul>
 *
 * <h2>Classes of static utility methods</h2>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.Collections2}
 *   <li>{@link org.foliage.guava.common.collect.Iterators}
 *   <li>{@link org.foliage.guava.common.collect.Iterables}
 *   <li>{@link org.foliage.guava.common.collect.Lists}
 *   <li>{@link org.foliage.guava.common.collect.Maps}
 *   <li>{@link org.foliage.guava.common.collect.Queues}
 *   <li>{@link org.foliage.guava.common.collect.Sets}
 *   <li>{@link org.foliage.guava.common.collect.Multisets}
 *   <li>{@link org.foliage.guava.common.collect.Multimaps}
 *   <li>{@link org.foliage.guava.common.collect.Tables}
 *   <li>{@link org.foliage.guava.common.collect.ObjectArrays}
 * </ul>
 *
 * <h2>Comparison</h2>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.Ordering}
 *   <li>{@link org.foliage.guava.common.collect.ComparisonChain}
 * </ul>
 *
 * <h2>Abstract implementations</h2>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.AbstractIterator}
 *   <li>{@link org.foliage.guava.common.collect.AbstractSequentialIterator}
 *   <li>{@link org.foliage.guava.common.collect.ImmutableCollection}
 *   <li>{@link org.foliage.guava.common.collect.UnmodifiableIterator}
 *   <li>{@link org.foliage.guava.common.collect.UnmodifiableListIterator}
 * </ul>
 *
 * <h2>Ranges</h2>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.Range}
 *   <li>{@link org.foliage.guava.common.collect.RangeMap}
 *   <li>{@link org.foliage.guava.common.collect.DiscreteDomain}
 *   <li>{@link org.foliage.guava.common.collect.ContiguousSet}
 * </ul>
 *
 * <h2>Other</h2>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.Interner}, {@link org.foliage.guava.common.collect.Interners}
 *   <li>{@link org.foliage.guava.common.collect.MapDifference}, {@link
 *       org.foliage.guava.common.collect.SortedMapDifference}
 *   <li>{@link org.foliage.guava.common.collect.MinMaxPriorityQueue}
 *   <li>{@link org.foliage.guava.common.collect.PeekingIterator}
 * </ul>
 *
 * <h2>Forwarding collections</h2>
 *
 * <ul>
 *   <li>{@link org.foliage.guava.common.collect.ForwardingCollection}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingConcurrentMap}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingIterator}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingList}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingListIterator}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingListMultimap}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingMap}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingMapEntry}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingMultimap}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingMultiset}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingNavigableMap}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingNavigableSet}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingObject}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingQueue}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingSet}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingSetMultimap}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingSortedMap}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingSortedMultiset}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingSortedSet}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingSortedSetMultimap}
 *   <li>{@link org.foliage.guava.common.collect.ForwardingTable}
 * </ul>
 */
@CheckReturnValue
@ParametersAreNonnullByDefault
package org.foliage.guava.common.collect;

import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.ParametersAreNonnullByDefault;
