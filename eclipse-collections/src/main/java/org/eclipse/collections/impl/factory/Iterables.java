/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.factory;

import java.util.Comparator;

import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;

public final class Iterables
{
    private Iterables()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }

    public static <T> MutableList<T> mList()
    {
        return MutableList.empty();
    }

    public static <T> MutableList<T> mList(T... elements)
    {
        return MutableList.of(elements);
    }

    public static <T> MutableSet<T> mSet()
    {
        return MutableSet.empty();
    }

    public static <T> MutableSet<T> mSet(T... elements)
    {
        return MutableSet.of(elements);
    }

    public static <T> MutableBag<T> mBag()
    {
        return MutableBag.empty();
    }

    public static <T> MutableBag<T> mBag(T... elements)
    {
        return MutableBag.of(elements);
    }

    public static <K, V> MutableMap<K, V> mMap()
    {
        return MutableMap.empty();
    }

    public static <K, V> MutableMap<K, V> mMap(K key, V value)
    {
        return MutableMap.of(key, value);
    }

    public static <K, V> MutableMap<K, V> mMap(K key1, V value1, K key2, V value2)
    {
        return MutableMap.of(key1, value1, key2, value2);
    }

    public static <K, V> MutableMap<K, V> mMap(K key1, V value1, K key2, V value2, K key3, V value3)
    {
        return MutableMap.of(key1, value1, key2, value2, key3, value3);
    }

    public static <K, V> MutableMap<K, V> mMap(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4)
    {
        return MutableMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    public static <T> MutableSortedSet<T> mSortedSet()
    {
        return MutableSortedSet.empty();
    }

    public static <T> MutableSortedSet<T> mSortedSet(T... elements)
    {
        return MutableSortedSet.of(elements);
    }

    public static <T> MutableSortedSet<T> mSortedSet(Comparator<? super T> comparator)
    {
        return MutableSortedSet.of(comparator);
    }

    public static <T> MutableSortedSet<T> mSortedSet(Comparator<? super T> comparator, T... elements)
    {
        return MutableSortedSet.of(comparator, elements);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap()
    {
        return MutableSortedMap.empty();
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(K key, V value)
    {
        return MutableSortedMap.of(key, value);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(K key1, V value1, K key2, V value2)
    {
        return MutableSortedMap.of(key1, value1, key2, value2);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(K key1, V value1, K key2, V value2, K key3, V value3)
    {
        return MutableSortedMap.of(key1, value1, key2, value2, key3, value3);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4)
    {
        return MutableSortedMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(Comparator<? super K> comparator)
    {
        return MutableSortedMap.of(comparator);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(Comparator<? super K> comparator, K key, V value)
    {
        return MutableSortedMap.of(comparator, key, value);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(
            Comparator<? super K> comparator,
            K key1, V value1,
            K key2, V value2)
    {
        return MutableSortedMap.of(comparator, key1, value1, key2, value2);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(
            Comparator<? super K> comparator,
            K key1, V value1,
            K key2, V value2,
            K key3, V value3)
    {
        return MutableSortedMap.of(comparator, key1, value1, key2, value2, key3, value3);
    }

    public static <K, V> MutableSortedMap<K, V> mSortedMap(
            Comparator<? super K> comparator,
            K key1, V value1,
            K key2, V value2,
            K key3, V value3,
            K key4, V value4)
    {
        return MutableSortedMap.of(comparator, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    public static <T> ImmutableList<T> iList()
    {
        return ImmutableList.empty();
    }

    public static <T> ImmutableList<T> iList(T one)
    {
        return ImmutableList.of(one);
    }

    public static <T> ImmutableList<T> iList(T one, T two)
    {
        return ImmutableList.of(one, two);
    }

    public static <T> ImmutableList<T> iList(T one, T two, T three)
    {
        return ImmutableList.of(one, two, three);
    }

    public static <T> ImmutableList<T> iList(T one, T two, T three, T four)
    {
        return ImmutableList.of(one, two, three, four);
    }

    public static <T> ImmutableList<T> iList(T one, T two, T three, T four, T five)
    {
        return ImmutableList.of(one, two, three, four, five);
    }

    public static <T> ImmutableList<T> iList(T one, T two, T three, T four, T five, T six)
    {
        return ImmutableList.of(one, two, three, four, five, six);
    }

    public static <T> ImmutableList<T> iList(T one, T two, T three, T four, T five, T six, T seven)
    {
        return ImmutableList.of(one, two, three, four, five, six, seven);
    }

    public static <T> ImmutableList<T> iList(T one, T two, T three, T four, T five, T six, T seven, T eight)
    {
        return ImmutableList.of(one, two, three, four, five, six, seven, eight);
    }

    public static <T> ImmutableList<T> iList(T one, T two, T three, T four, T five, T six, T seven, T eight, T nine)
    {
        return ImmutableList.of(one, two, three, four, five, six, seven, eight, nine);
    }

    public static <T> ImmutableList<T> iList(T one, T two, T three, T four, T five, T six, T seven, T eight, T nine, T ten)
    {
        return ImmutableList.of(one, two, three, four, five, six, seven, eight, nine, ten);
    }

    public static <T> ImmutableList<T> iList(T... elements)
    {
        return ImmutableList.of(elements);
    }

    public static <T> ImmutableSet<T> iSet()
    {
        return ImmutableSet.empty();
    }

    public static <T> ImmutableSet<T> iSet(T one)
    {
        return ImmutableSet.of(one);
    }

    public static <T> ImmutableSet<T> iSet(T one, T two)
    {
        return ImmutableSet.of(one, two);
    }

    public static <T> ImmutableSet<T> iSet(T one, T two, T three)
    {
        return ImmutableSet.of(one, two, three);
    }

    public static <T> ImmutableSet<T> iSet(T one, T two, T three, T four)
    {
        return ImmutableSet.of(one, two, three, four);
    }

    public static <T> ImmutableSet<T> iSet(T... elements)
    {
        return ImmutableSet.of(elements);
    }

    public static <T> ImmutableBag<T> iBag()
    {
        return ImmutableBag.empty();
    }

    public static <T> ImmutableBag<T> iBag(T one)
    {
        return ImmutableBag.of(one);
    }

    public static <T> ImmutableBag<T> iBag(T... elements)
    {
        return ImmutableBag.of(elements);
    }

    public static <K, V> ImmutableMap<K, V> iMap()
    {
        return ImmutableMap.empty();
    }

    public static <K, V> ImmutableMap<K, V> iMap(K key, V value)
    {
        return ImmutableMap.of(key, value);
    }

    public static <K, V> ImmutableMap<K, V> iMap(K key1, V value1, K key2, V value2)
    {
        return ImmutableMap.of(key1, value1, key2, value2);
    }

    public static <K, V> ImmutableMap<K, V> iMap(K key1, V value1, K key2, V value2, K key3, V value3)
    {
        return ImmutableMap.of(key1, value1, key2, value2, key3, value3);
    }

    public static <K, V> ImmutableMap<K, V> iMap(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4)
    {
        return ImmutableMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    public static <T> ImmutableSortedSet<T> iSortedSet()
    {
        return ImmutableSortedSet.empty();
    }

    public static <T> ImmutableSortedSet<T> iSortedSet(T... elements)
    {
        return ImmutableSortedSet.of(elements);
    }

    public static <T> ImmutableSortedSet<T> iSortedSet(Comparator<? super T> comparator)
    {
        return ImmutableSortedSet.of(comparator);
    }

    public static <T> ImmutableSortedSet<T> iSortedSet(Comparator<? super T> comparator, T... elements)
    {
        return ImmutableSortedSet.of(comparator, elements);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap()
    {
        return ImmutableSortedMap.empty();
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(K key, V value)
    {
        return ImmutableSortedMap.of(key, value);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(K key1, V value1, K key2, V value2)
    {
        return ImmutableSortedMap.of(key1, value1, key2, value2);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(K key1, V value1, K key2, V value2, K key3, V value3)
    {
        return ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(K key1, V value1, K key2, V value2, K key3, V value3, K key4, V value4)
    {
        return ImmutableSortedMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(Comparator<? super K> comparator)
    {
        return ImmutableSortedMap.of(comparator);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(Comparator<? super K> comparator, K key, V value)
    {
        return ImmutableSortedMap.of(comparator, key, value);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(
            Comparator<? super K> comparator,
            K key1, V value1,
            K key2, V value2)
    {
        return ImmutableSortedMap.of(comparator, key1, value1, key2, value2);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(
            Comparator<? super K> comparator,
            K key1, V value1,
            K key2, V value2,
            K key3, V value3)
    {
        return ImmutableSortedMap.of(comparator, key1, value1, key2, value2, key3, value3);
    }

    public static <K, V> ImmutableSortedMap<K, V> iSortedMap(
            Comparator<? super K> comparator,
            K key1, V value1,
            K key2, V value2,
            K key3, V value3,
            K key4, V value4)
    {
        return ImmutableSortedMap.of(comparator, key1, value1, key2, value2, key3, value3, key4, value4);
    }
}
