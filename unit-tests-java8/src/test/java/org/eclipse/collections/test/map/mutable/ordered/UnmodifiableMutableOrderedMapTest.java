/*
 * Copyright (c) 2021 Two Sigma and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.map.mutable.ordered;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.collections.api.map.MutableOrderedMap;
import org.eclipse.collections.impl.map.ordered.mutable.OrderedMapAdapter;
import org.eclipse.collections.impl.map.ordered.mutable.UnmodifiableMutableOrderedMap;
import org.eclipse.collections.test.FixedSizeIterableTestCase;
import org.eclipse.collections.test.map.UnmodifiableMapTestCase;
import org.eclipse.collections.test.map.mutable.UnmodifiableMutableMapIterableTestCase;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

public class UnmodifiableMutableOrderedMapTest implements MutableOrderedMapTestCase, FixedSizeIterableTestCase,
        UnmodifiableMutableMapIterableTestCase, UnmodifiableMapTestCase
{
    @Override
    public <T> MutableOrderedMap<Object, T> newWith(T... elements)
    {
        int i = elements.length;
        MutableOrderedMap<Object, T> result = OrderedMapAdapter.adapt(new LinkedHashMap<>());
        for (T each : elements)
        {
            assertNull(result.put(i, each));
            i--;
        }

        return UnmodifiableMutableOrderedMap.of(result);
    }

    @Override
    public <K, V> MutableOrderedMap<K, V> newWithKeysValues(Object... elements)
    {
        if (elements.length % 2 != 0)
        {
            fail(String.valueOf(elements.length));
        }

        MutableOrderedMap<K, V> result = OrderedMapAdapter.adapt(new LinkedHashMap<>());
        for (int i = 0; i < elements.length; i += 2)
        {
            assertNull(result.put((K) elements[i], (V) elements[i + 1]));
        }
        return UnmodifiableMutableOrderedMap.of(result);
    }

    @Override
    public void Iterable_remove()
    {
        UnmodifiableMutableMapIterableTestCase.super.Iterable_remove();
    }

    @Override
    public void Map_computeIfPresent()
    {
        Map<Integer, String> map = this.newWithKeysValues(1, "1", 2, "2", 3, "3");

        assertThrows(UnsupportedOperationException.class, () -> map.computeIfPresent(1, (k, v) -> "1"));
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        assertThrows(UnsupportedOperationException.class, () -> map.computeIfPresent(1, (k, v) -> "One"));
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        assertThrows(UnsupportedOperationException.class, () -> map.computeIfPresent(1, (k, v) -> null));
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        // TODO: This should throw for consistency with other Unmodifiable Maps
        String value1 = map.computeIfPresent(4, (k, v) -> "Four");
        assertNull(value1);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        // TODO: This should throw for consistency with other Unmodifiable Maps
        String value2 = map.computeIfPresent(4, (k, v) -> null);
        assertNull(value2);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        // TODO: This should throw for consistency with other Unmodifiable Maps
        String value3 = map.computeIfPresent(null, (k, v) -> "4");
        assertNull(value3);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);
    }
}
