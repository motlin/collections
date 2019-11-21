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

import org.eclipse.collections.api.factory.bag.ImmutableBagFactory;
import org.eclipse.collections.api.factory.bag.MultiReaderBagFactory;
import org.eclipse.collections.api.factory.bag.MutableBagFactory;
import org.eclipse.collections.impl.bag.immutable.ImmutableBagFactoryImpl;
import org.eclipse.collections.impl.bag.mutable.MultiReaderMutableBagFactory;
import org.eclipse.collections.impl.bag.mutable.MutableBagFactoryImpl;

/**
 * This class should be used to create instances of MutableBag and ImmutableBag
 * <p>
 * Mutable Examples:
 *
 * <pre>
 * MutableBag&lt;String&gt; emptyBag = MutableBag.empty();
 * MutableBag&lt;String&gt; bagWith = MutableBag.of("a", "b", "c");
 * MutableBag&lt;String&gt; bagOf = MutableBag.of("a", "b", "c");
 * </pre>
 *
 * Immutable Examples:
 *
 * <pre>
 * ImmutableBag&lt;String&gt; emptyBag = ImmutableBag.empty();
 * ImmutableBag&lt;String&gt; bagWith = ImmutableBag.of("a", "b", "c");
 * ImmutableBag&lt;String&gt; bagOf = ImmutableBag.of("a", "b", "c");
 * </pre>
 */

@SuppressWarnings("ConstantNamingConvention")
public final class Bags
{
    public static final ImmutableBagFactory immutable = ImmutableBagFactoryImpl.INSTANCE;
    public static final MutableBagFactory mutable = MutableBagFactoryImpl.INSTANCE;
    public static final MultiReaderBagFactory multiReader = MultiReaderMutableBagFactory.INSTANCE;

    private Bags()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
