/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.factory;

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
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Test;

public class IterablesTest
{
    @Test
    public void immutableLists()
    {
        this.assertEqualsAndInstanceOf(FastList.newList().toImmutable(), ImmutableList.empty(), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1), ImmutableList.of(1), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2), ImmutableList.of(1, 2), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3), ImmutableList.of(1, 2, 3), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4), ImmutableList.of(1, 2, 3, 4), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5), ImmutableList.of(1, 2, 3, 4, 5), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6), ImmutableList.of(1, 2, 3, 4, 5, 6), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7), ImmutableList.of(1, 2, 3, 4, 5, 6, 7), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8), ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9), ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10), ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), ImmutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11), ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), ImmutableList.class);
    }

    @Test
    public void mutableLists()
    {
        this.assertEqualsAndInstanceOf(FastList.newList(), MutableList.empty(), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1), MutableList.of(1), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2), MutableList.of(1, 2), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3), MutableList.of(1, 2, 3), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4), MutableList.of(1, 2, 3, 4), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5), MutableList.of(1, 2, 3, 4, 5), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6), MutableList.of(1, 2, 3, 4, 5, 6), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7), MutableList.of(1, 2, 3, 4, 5, 6, 7), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8), MutableList.of(1, 2, 3, 4, 5, 6, 7, 8), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9), MutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10), MutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), MutableList.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11), MutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), MutableList.class);
    }

    @Test
    public void immutableSets()
    {
        this.assertEqualsAndInstanceOf(UnifiedSet.newSet().toImmutable(), ImmutableSet.empty(), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSet(), ImmutableSet.of(1), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSet(), ImmutableSet.of(1, 2), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSet(), ImmutableSet.of(1, 2, 3), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSet(), ImmutableSet.of(1, 2, 3, 4), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5).toSet(), ImmutableSet.of(1, 2, 3, 4, 5), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6).toSet(), ImmutableSet.of(1, 2, 3, 4, 5, 6), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7).toSet(), ImmutableSet.of(1, 2, 3, 4, 5, 6, 7), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8).toSet(), ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9).toSet(), ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10).toSet(), ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), ImmutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11).toSet(), ImmutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), ImmutableSet.class);
    }

    @Test
    public void mutableSets()
    {
        this.assertEqualsAndInstanceOf(UnifiedSet.newSet(), MutableSet.empty(), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSet(), MutableSet.of(1), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSet(), MutableSet.of(1, 2), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSet(), MutableSet.of(1, 2, 3), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSet(), MutableSet.of(1, 2, 3, 4), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5).toSet(), MutableSet.of(1, 2, 3, 4, 5), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6).toSet(), MutableSet.of(1, 2, 3, 4, 5, 6), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7).toSet(), MutableSet.of(1, 2, 3, 4, 5, 6, 7), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8).toSet(), MutableSet.of(1, 2, 3, 4, 5, 6, 7, 8), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9).toSet(), MutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10).toSet(), MutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), MutableSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11).toSet(), MutableSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), MutableSet.class);
    }

    @Test
    public void mutableBags()
    {
        this.assertEqualsAndInstanceOf(HashBag.newBag(), MutableBag.empty(), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toBag(), MutableBag.of(1), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toBag(), MutableBag.of(1, 2), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toBag(), MutableBag.of(1, 2, 3), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toBag(), MutableBag.of(1, 2, 3, 4), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5).toBag(), MutableBag.of(1, 2, 3, 4, 5), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6).toBag(), MutableBag.of(1, 2, 3, 4, 5, 6), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7).toBag(), MutableBag.of(1, 2, 3, 4, 5, 6, 7), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8).toBag(), MutableBag.of(1, 2, 3, 4, 5, 6, 7, 8), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9).toBag(), MutableBag.of(1, 2, 3, 4, 5, 6, 7, 8, 9), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10).toBag(), MutableBag.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), MutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11).toBag(), MutableBag.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), MutableBag.class);
    }

    @Test
    public void immutableBags()
    {
        this.assertEqualsAndInstanceOf(HashBag.newBag(), ImmutableBag.empty(), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toBag(), ImmutableBag.of(1), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toBag(), ImmutableBag.of(1, 2), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toBag(), ImmutableBag.of(1, 2, 3), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toBag(), ImmutableBag.of(1, 2, 3, 4), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5).toBag(), ImmutableBag.of(1, 2, 3, 4, 5), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6).toBag(), ImmutableBag.of(1, 2, 3, 4, 5, 6), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7).toBag(), ImmutableBag.of(1, 2, 3, 4, 5, 6, 7), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8).toBag(), ImmutableBag.of(1, 2, 3, 4, 5, 6, 7, 8), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9).toBag(), ImmutableBag.of(1, 2, 3, 4, 5, 6, 7, 8, 9), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10).toBag(), ImmutableBag.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), ImmutableBag.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11).toBag(), ImmutableBag.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), ImmutableBag.class);
    }

    @Test
    public void immutableSortedSets()
    {
        this.assertEqualsAndInstanceOf(TreeSortedSet.newSet(), ImmutableSortedSet.empty(), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedSet(), ImmutableSortedSet.of(1), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedSet(), ImmutableSortedSet.of(1, 2), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedSet(), ImmutableSortedSet.of(1, 2, 3), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedSet(), ImmutableSortedSet.of(1, 2, 3, 4), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5).toSortedSet(), ImmutableSortedSet.of(1, 2, 3, 4, 5), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6).toSortedSet(), ImmutableSortedSet.of(1, 2, 3, 4, 5, 6), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7).toSortedSet(), ImmutableSortedSet.of(1, 2, 3, 4, 5, 6, 7), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8).toSortedSet(), ImmutableSortedSet.of(1, 2, 3, 4, 5, 6, 7, 8), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9).toSortedSet(), ImmutableSortedSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10).toSortedSet(), ImmutableSortedSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11).toSortedSet(), ImmutableSortedSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), ImmutableSortedSet.class);
    }

    @Test
    public void immutableSortedSetsWithComparator()
    {
        this.assertEqualsAndInstanceOf(TreeSortedSet.newSet(Comparators.reverseNaturalOrder()), ImmutableSortedSet.of(Comparators.reverseNaturalOrder()), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7, 8), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7, 8, 9), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11).toSortedSet(Comparators.reverseNaturalOrder()),
                ImmutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), ImmutableSortedSet.class);
    }

    @Test
    public void mutableSortedSetsWithComparator()
    {
        this.assertEqualsAndInstanceOf(TreeSortedSet.newSet(Comparators.reverseNaturalOrder()), ImmutableSortedSet.of(Comparators.reverseNaturalOrder()), ImmutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7, 8), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7, 8, 9), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11).toSortedSet(Comparators.reverseNaturalOrder()),
                MutableSortedSet.of(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), MutableSortedSet.class);
    }

    @Test
    public void mutableSortedSets()
    {
        this.assertEqualsAndInstanceOf(TreeSortedSet.newSet(), MutableSortedSet.empty(), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedSet(), MutableSortedSet.of(1), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedSet(), MutableSortedSet.of(1, 2), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedSet(), MutableSortedSet.of(1, 2, 3), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedSet(), MutableSortedSet.of(1, 2, 3, 4), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(5).toSortedSet(), MutableSortedSet.of(1, 2, 3, 4, 5), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(6).toSortedSet(), MutableSortedSet.of(1, 2, 3, 4, 5, 6), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(7).toSortedSet(), MutableSortedSet.of(1, 2, 3, 4, 5, 6, 7), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(8).toSortedSet(), MutableSortedSet.of(1, 2, 3, 4, 5, 6, 7, 8), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(9).toSortedSet(), MutableSortedSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(10).toSortedSet(), MutableSortedSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), MutableSortedSet.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(11).toSortedSet(), MutableSortedSet.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), MutableSortedSet.class);
    }

    @Test
    public void mutableSortedMaps()
    {
        this.assertEqualsAndInstanceOf(TreeSortedMap.newMap(), MutableSortedMap.empty(), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedMap(Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(1, 1), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedMap(Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(1, 1, 2, 2), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedMap(Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(1, 1, 2, 2, 3, 3), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedMap(Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(1, 1, 2, 2, 3, 3, 4, 4), MutableSortedMap.class);
    }

    @Test
    public void mutableSortedMapsWithComparator()
    {
        this.assertEqualsAndInstanceOf(TreeSortedMap.newMap(Comparators.reverseNaturalOrder()), MutableSortedMap.of(Comparators.reverseNaturalOrder()), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(TreeSortedMap.newMap(Comparators.reverseNaturalOrder()), MutableSortedMap.of(null), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3, 4, 4), MutableSortedMap.class);
    }

    @Test
    public void mutableSortedMapsWithFunction()
    {
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedMapBy(key -> -key, Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedMapBy(key -> -key, Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedMapBy(key -> key, Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3), MutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedMapBy(key -> -key, Functions.getPassThru(), Functions.getPassThru()),
                MutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3, 4, 4), MutableSortedMap.class);
    }

    @Test
    public void immutableSortedMaps()
    {
        this.assertEqualsAndInstanceOf(TreeSortedMap.newMap(), ImmutableSortedMap.empty(), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedMap(Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(1, 1), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedMap(Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(1, 1, 2, 2), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedMap(Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(1, 1, 2, 2, 3, 3), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedMap(Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(1, 1, 2, 2, 3, 3, 4, 4), ImmutableSortedMap.class);
    }

    @Test
    public void immutableSortedMapsWithComparator()
    {
        this.assertEqualsAndInstanceOf(TreeSortedMap.newMap(Comparators.reverseNaturalOrder()), ImmutableSortedMap.of(Comparators.reverseNaturalOrder()), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3, 4, 4), ImmutableSortedMap.class);
    }

    @Test
    public void immutableSortedMapsWithFunction()
    {
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toSortedMapBy(key -> -key, Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toSortedMapBy(key -> -key, Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toSortedMapBy(key -> -key, Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3), ImmutableSortedMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toSortedMapBy(key -> -key, Functions.getPassThru(), Functions.getPassThru()),
                ImmutableSortedMap.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3, 4, 4), ImmutableSortedMap.class);
    }

    @Test
    public void mutableMaps()
    {
        this.assertEqualsAndInstanceOf(UnifiedMap.newMap(), MutableMap.empty(), MutableMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toMap(Functions.getPassThru(), Functions.getPassThru()),
                MutableMap.of(1, 1), MutableMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toMap(Functions.getPassThru(), Functions.getPassThru()),
                MutableMap.of(1, 1, 2, 2), MutableMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toMap(Functions.getPassThru(), Functions.getPassThru()),
                MutableMap.of(1, 1, 2, 2, 3, 3), MutableMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toMap(Functions.getPassThru(), Functions.getPassThru()),
                MutableMap.of(1, 1, 2, 2, 3, 3, 4, 4), MutableMap.class);
    }

    @Test
    public void immutableMaps()
    {
        this.assertEqualsAndInstanceOf(UnifiedMap.newMap(), ImmutableMap.empty(), ImmutableMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(1).toMap(Functions.getPassThru(), Functions.getPassThru()),
                ImmutableMap.of(1, 1), ImmutableMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(2).toMap(Functions.getPassThru(), Functions.getPassThru()),
                ImmutableMap.of(1, 1, 2, 2), ImmutableMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(3).toMap(Functions.getPassThru(), Functions.getPassThru()),
                ImmutableMap.of(1, 1, 2, 2, 3, 3), ImmutableMap.class);
        this.assertEqualsAndInstanceOf(Interval.oneTo(4).toMap(Functions.getPassThru(), Functions.getPassThru()),
                ImmutableMap.of(1, 1, 2, 2, 3, 3, 4, 4), ImmutableMap.class);
    }

    public void assertEqualsAndInstanceOf(Object expected, Object actual, Class<?> clazz)
    {
        Verify.assertEqualsAndHashCode(expected, actual);
        Verify.assertInstanceOf(clazz, actual);
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(Iterables.class);
    }
}
