/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.factory;

import java.util.List;

import org.eclipse.collections.api.factory.list.FixedSizeListFactory;
import org.eclipse.collections.api.factory.list.ImmutableListFactory;
import org.eclipse.collections.api.factory.list.MultiReaderListFactory;
import org.eclipse.collections.api.factory.list.MutableListFactory;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.list.fixed.FixedSizeListFactoryImpl;
import org.eclipse.collections.impl.list.immutable.ImmutableListFactoryImpl;
import org.eclipse.collections.impl.list.mutable.ListAdapter;
import org.eclipse.collections.impl.list.mutable.MultiReaderMutableListFactory;
import org.eclipse.collections.impl.list.mutable.MutableListFactoryImpl;

/**
 * This class should be used to create instances of MutableList, ImmutableList and FixedSizeList
 * <p>
 * Mutable Examples:
 *
 * <pre>
 * MutableList&lt;String&gt; emptyList = MutableList.empty();
 * MutableList&lt;String&gt; listWith = MutableList.of("a", "b", "c");
 * MutableList&lt;String&gt; listOf = MutableList.of("a", "b", "c");
 * </pre>
 *
 * Immutable Examples:
 *
 * <pre>
 * ImmutableList&lt;String&gt; emptyList = ImmutableList.empty();
 * ImmutableList&lt;String&gt; listWith = ImmutableList.of("a", "b", "c");
 * ImmutableList&lt;String&gt; listOf = ImmutableList.of("a", "b", "c");
 * </pre>
 *
 * FixedSize Examples:
 *
 * <pre>
 * FixedSizeList&lt;String&gt; emptyList = FixedSizeList.empty();
 * FixedSizeList&lt;String&gt; listWith = FixedSizeList.of("a", "b", "c");
 * FixedSizeList&lt;String&gt; listOf = FixedSizeList.of("a", "b", "c");
 * </pre>
 */
@SuppressWarnings("ConstantNamingConvention")
public final class Lists
{
    public static final ImmutableListFactory immutable = ImmutableListFactoryImpl.INSTANCE;
    public static final MutableListFactory mutable = MutableListFactoryImpl.INSTANCE;
    public static final FixedSizeListFactory fixedSize = FixedSizeListFactoryImpl.INSTANCE;
    public static final MultiReaderListFactory multiReader = MultiReaderMutableListFactory.INSTANCE;

    private Lists()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }

    /**
     * @since 9.0.
     */
    public static <T> MutableList<T> adapt(List<T> list)
    {
        return ListAdapter.adapt(list);
    }
}
