/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.lazy.iterator;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.list.FixedSizeList;
import org.eclipse.collections.api.list.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

public class TapIteratorTest
{
    @Test(expected = NoSuchElementException.class)
    public void nextIfDoesntHaveAnything()
    {
        new TapIterator<>(ImmutableList.empty(), object -> {
        }).next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeIsUnsupported()
    {
        new TapIterator<>(ImmutableList.empty().iterator(), object -> {
        }).remove();
    }

    @Test
    public void nextAfterEmptyIterable()
    {
        Object expected = new Object();
        TapIterator<Object> iterator = new TapIterator<>(
                FixedSizeList.of(expected), object -> { });
        Assert.assertSame(expected, iterator.next());
    }
}
