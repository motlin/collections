/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.sorted.immutable;

import java.util.Comparator;

import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableSortedBagFactoryTest
{
    @Test
    public void empty()
    {
        Assert.assertEquals(TreeBag.newBag(), ImmutableSortedBag.empty());
        Verify.assertInstanceOf(ImmutableSortedBag.class, ImmutableSortedBag.empty());

        Assert.assertEquals(TreeBag.newBag(Comparators.reverseNaturalOrder()), ImmutableSortedBag.empty(Comparators.reverseNaturalOrder()));
        Verify.assertInstanceOf(ImmutableSortedBag.class, ImmutableSortedBag.empty(Comparators.reverseNaturalOrder()));
    }

    @Test
    public void ofElements()
    {
        Assert.assertEquals(new ImmutableSortedBagImpl<>(MutableSortedBag.of(1, 1, 2)), ImmutableSortedBag.of(1, 1, 2));
        Assert.assertEquals(new ImmutableSortedBagImpl<>(MutableSortedBag.of(Comparators.reverseNaturalOrder(), 1, 1, 2)), ImmutableSortedBag.of(Comparators.reverseNaturalOrder(), 1, 1, 2));

        Assert.assertEquals(TreeBag.newBag(), ImmutableSortedBag.of());
        Verify.assertInstanceOf(ImmutableSortedBag.class, ImmutableSortedBag.of());
        Comparator<Integer> nullComparator = null;
        Assert.assertEquals(TreeBag.newBag(), ImmutableSortedBag.of(nullComparator));
        Verify.assertInstanceOf(ImmutableSortedBag.class, ImmutableSortedBag.of(nullComparator));
        Assert.assertEquals(TreeBag.newBag(Comparators.reverseNaturalOrder()), ImmutableSortedBag.of(Comparator.reverseOrder()));
        Verify.assertInstanceOf(ImmutableSortedBag.class, ImmutableSortedBag.of(Comparator.reverseOrder()));
        Assert.assertEquals(TreeBag.newBag(Comparators.reverseNaturalOrder()), ImmutableSortedBag.of(Comparator.reverseOrder(), new Integer[]{}));
        Verify.assertInstanceOf(ImmutableSortedBag.class, ImmutableSortedBag.of(Comparator.reverseOrder(), new Integer[]{}));
        Assert.assertEquals(TreeBag.newBag(), ImmutableSortedBag.of(new Integer[]{}));
        Verify.assertInstanceOf(ImmutableSortedBag.class, ImmutableSortedBag.of(new Integer[]{}));
    }

    @Test
    public void withElements()
    {
        Assert.assertEquals(new ImmutableSortedBagImpl<>(MutableSortedBag.of(1, 1, 2)), ImmutableSortedBag.of(1, 1, 2));
        Verify.assertThrows(IllegalArgumentException.class, () -> new ImmutableSortedBagImpl<>(MutableSortedBag.of(Comparators.reverseNaturalOrder(), FastList.newList().toArray())));
        Assert.assertEquals(new ImmutableSortedBagImpl<>(MutableSortedBag.of(Comparators.reverseNaturalOrder(), 1, 1, 2)), ImmutableSortedBag.of(Comparators.reverseNaturalOrder(), 1, 1, 2));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(new ImmutableSortedBagImpl<>(MutableSortedBag.of(1, 1, 2)), ImmutableSortedBag.ofAll(new ImmutableSortedBagImpl<>(TreeBag.newBagWith(1, 1, 2))));
        Assert.assertEquals(new ImmutableSortedBagImpl<>(MutableSortedBag.of(1, 1, 2)), ImmutableSortedBag.ofAll(FastList.newListWith(1, 1, 2)));
        Assert.assertEquals(new ImmutableSortedBagImpl<>(MutableSortedBag.of(Comparators.reverseNaturalOrder(), 1, 1, 2)), ImmutableSortedBag.ofAll(Comparators.reverseNaturalOrder(), FastList.newListWith(1, 1, 2)));
    }

    @Test
    public void ofSortedBag()
    {
        Assert.assertEquals(new ImmutableSortedBagImpl<>(ImmutableSortedBag.of(1)), ImmutableSortedBag.ofSortedBag(new ImmutableSortedBagImpl<>(TreeBag.newBagWith(1))));
        Assert.assertEquals(new ImmutableSortedBagImpl<>(ImmutableSortedBag.of(1)), ImmutableSortedBag.ofSortedBag(TreeBag.newBagWith(1)));
        Assert.assertEquals(ImmutableSortedBag.of(Comparators.reverseNaturalOrder()), ImmutableSortedBag.ofSortedBag(TreeBag.newBag(Comparators.reverseNaturalOrder())));
    }

    @Test
    public void withSortedBag()
    {
        Assert.assertEquals(new ImmutableSortedBagImpl<>(ImmutableSortedBag.of(1)), ImmutableSortedBag.ofSortedBag(new ImmutableSortedBagImpl<>(TreeBag.newBagWith(1))));
    }
}
