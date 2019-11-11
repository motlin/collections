/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.lazy.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.list.FixedSizeList;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.block.factory.Functions;
import org.junit.Assert;
import org.junit.Test;

public class FlatCollectIteratorTest
{
    @Test(expected = NoSuchElementException.class)
    public void nextIfDoesntHaveAnything()
    {
        new FlatCollectIterator<>(ImmutableList.empty(), object -> null).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeIsUnsupported()
    {
        new FlatCollectIterator<>(ImmutableList.empty().iterator(), object -> null).remove();
    }

    @Test
    public void nextAfterEmptyIterable()
    {
        Object expected = new Object();
        Iterator<Object> flattenIterator = new FlatCollectIterator<>(
                FixedSizeList.of(
                        FixedSizeList.empty(),
                        FixedSizeList.of(expected)),
                Functions.getPassThru());
        Assert.assertSame(expected, flattenIterator.next());
    }
}
