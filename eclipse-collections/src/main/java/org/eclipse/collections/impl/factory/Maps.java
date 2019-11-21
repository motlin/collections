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

import java.util.Map;

import org.eclipse.collections.api.factory.map.FixedSizeMapFactory;
import org.eclipse.collections.api.factory.map.ImmutableMapFactory;
import org.eclipse.collections.api.factory.map.MutableMapFactory;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.map.fixed.FixedSizeMapFactoryImpl;
import org.eclipse.collections.impl.map.immutable.ImmutableMapFactoryImpl;
import org.eclipse.collections.impl.map.mutable.MapAdapter;
import org.eclipse.collections.impl.map.mutable.MutableMapFactoryImpl;

/**
 * This class should be used to create instances of MutableMap, ImmutableMap and FixedSizeMap
 * <p>
 * Mutable Examples:
 *
 * <pre>
 * MutableMap&lt;String, String&gt; emptyMap = MutableMap.empty();
 * MutableMap&lt;String, String&gt; mapWith = MutableMap.of("a", "A", "b", "B", "c", "C");
 * MutableMap&lt;String, String&gt; mapOf = MutableMap.of("a", "A", "b", "B", "c", "C");
 * </pre>
 *
 * Immutable Examples:
 *
 * <pre>
 * ImmutableMap&lt;String, String&gt; emptyMap = ImmutableMap.empty();
 * ImmutableMap&lt;String, String&gt; mapWith = ImmutableMap.of("a", "A", "b", "B", "c", "C");
 * ImmutableMap&lt;String, String&gt; mapOf = ImmutableMap.of("a", "A", "b", "B", "c", "C");
 * </pre>
 *
 * FixedSize Examples:
 *
 * <pre>
 * FixedSizeMap&lt;String, String&gt; emptyMap = FixedSizeMap.empty();
 * FixedSizeMap&lt;String, String&gt; mapWith = FixedSizeMap.of("a", "A", "b", "B", "c", "C");
 * FixedSizeMap&lt;String, String&gt; mapOf = FixedSizeMap.of("a", "A", "b", "B", "c", "C");
 * </pre>
 */
@SuppressWarnings("ConstantNamingConvention")
public final class Maps
{
    public static final ImmutableMapFactory immutable = ImmutableMapFactoryImpl.INSTANCE;
    public static final FixedSizeMapFactory fixedSize = FixedSizeMapFactoryImpl.INSTANCE;
    public static final MutableMapFactory mutable = MutableMapFactoryImpl.INSTANCE;

    private Maps()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }

    /**
     * @since 9.0.
     */
    public static <K, V> MutableMap<K, V> adapt(Map<K, V> map)
    {
        return MapAdapter.adapt(map);
    }
}
