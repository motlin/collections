/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.immutable;

import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public class ImmutableBagFactoryTest
{
    @Test
    public void immutables()
    {
        ImmutableBag<Object> immutableBag = ImmutableBag.empty();
        Verify.assertIterableSize(0, immutableBag);
        Verify.assertIterableSize(4, ImmutableBag.of(1, 2, 2, 3));
        ImmutableBag<Object> actual = ImmutableBag.ofAll(immutableBag);
        Assert.assertSame(immutableBag, actual);
        Assert.assertEquals(immutableBag, actual);
    }

    @Test
    public void singletonBagCreation()
    {
        Bag<String> singleton = ImmutableBag.of("a");
        Verify.assertInstanceOf(ImmutableSingletonBag.class, singleton);
    }
}
