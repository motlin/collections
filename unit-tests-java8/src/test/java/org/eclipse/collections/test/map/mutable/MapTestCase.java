/*
 * Copyright (c) 2024 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.map.mutable;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.collections.impl.tuple.ImmutableEntry;
import org.junit.jupiter.api.Test;

import static org.eclipse.collections.test.IterableTestCase.assertIterablesEqual;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public interface MapTestCase
{
    // Returns Object to allow subclasses to return either Map or MapIterable, and be cast to Map either way
    <T> Object newWith(T... elements);

    // Returns Object to allow subclasses to return either Map or MapIterable, and be cast to Map either way
    <K, V> Object newWithKeysValues(Object... elements);

    default boolean supportsNullKeys()
    {
        return true;
    }

    default boolean supportsNullValues()
    {
        return true;
    }

    default boolean supportsRemovingNullInEntries()
    {
        return false;
    }

    @Test
    default void Iterable_toString()
    {
        Map<String, Integer> map = (Map<String, Integer>) this.newWithKeysValues("Two", 2, "One", 1);
        assertThat(map.toString(), isOneOf("{One=1, Two=2}", "{Two=2, One=1}"));
        assertThat(map.keySet().toString(), isOneOf("[One, Two]", "[Two, One]"));
        assertThat(map.values().toString(), isOneOf("[1, 2]", "[2, 1]"));
        assertThat(map.entrySet().toString(), isOneOf("[One=1, Two=2]", "[Two=2, One=1]"));
    }

    @Test
    default void Map_clear()
    {
        Map<Object, String> map = (Map<Object, String>) this.newWith("Three", "Two", "One");
        map.clear();
        assertIterablesEqual(this.newWith(), map);

        Map<Object, Object> map2 = (Map<Object, Object>) this.newWith();
        map2.clear();
        assertIterablesEqual(this.newWith(), map2);
    }

    @Test
    default void Map_remove()
    {
        Map<Integer, String> map1 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertIterablesEqual("Two", map1.remove(2));
        assertIterablesEqual(
                this.newWithKeysValues(3, "Three", 1, "One"),
                map1);

        Map<Integer, String> map2 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertNull(map2.remove(4));
        assertEquals(
                this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                map2);

        Map<Integer, String> map3 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        if (this.supportsNullKeys())
        {
            assertNull(map3.remove(null));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map3);

            Map<Integer, String> map4 =
                    (Map<Integer, String>) this.newWithKeysValues(3, "Three", null, "Two", 1, "One");
            assertEquals("Two", map4.remove(null));
            assertIterablesEqual(
                    this.newWithKeysValues(3, "Three", 1, "One"),
                    map4);
        }
        else
        {
            assertThrows(NullPointerException.class, () -> map3.remove(null));
        }

        if (this.supportsNullValues())
        {
            Map<Integer, String> map5 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One", 4, null);
            assertNull(map5.remove(4));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map5);
        }
    }

    @Test
    default void Map_entrySet_remove()
    {
        Map<Integer, String> map1 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertTrue(map1.entrySet().remove(ImmutableEntry.of(2, "Two")));
        assertIterablesEqual(
                this.newWithKeysValues(3, "Three", 1, "One"),
                map1);

        Map<Integer, String> map2 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertFalse(map2.entrySet().remove(ImmutableEntry.of(4, "Four")));
        assertEquals(
                this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                map2);

        Map<Integer, String> map3 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertFalse(map3.entrySet().remove(ImmutableEntry.of(2, "One")));
        assertEquals(
                this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                map3);

        Map<Integer, String> map4 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertFalse(map4.entrySet().remove(ImmutableEntry.of(4, "One")));
        assertEquals(
                this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                map4);

        Map<Integer, String> map5 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        if (this.supportsNullKeys())
        {
            assertFalse(map5.entrySet().remove(ImmutableEntry.of(null, "Two")));
            assertIterablesEqual(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map5);

            Map<Integer, String> map6 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", null, "Two", 1, "One");
            assertTrue(map6.entrySet().remove(ImmutableEntry.of(null, "Two")));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 1, "One"),
                    map6);

            Map<Integer, String> map7 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", null, "Two", 1, "One");
            assertFalse(map7.entrySet().remove(ImmutableEntry.of(null, "One")));
            assertEquals(
                    this.newWithKeysValues(3, "Three", null, "Two", 1, "One"),
                    map7);
        }
        else if (this.supportsRemovingNullInEntries())
        {
            assertFalse(map5.entrySet().remove(ImmutableEntry.of(null, "Two")));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map5);
        }
        else
        {
            assertThrows(NullPointerException.class, () -> map5.entrySet().remove(ImmutableEntry.of(null, "Two")));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map5);
        }

        if (this.supportsNullValues())
        {
            Map<Integer, String> map8 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One", 4, null);
            assertTrue(map8.entrySet().remove(ImmutableEntry.of(4, null)));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map8);

            Map<Integer, String> map9 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One", 4, null);
            assertFalse(map9.entrySet().remove(ImmutableEntry.of(4, "One")));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One", 4, null),
                    map9);
        }
        else if (this.supportsRemovingNullInEntries())
        {
            assertFalse(map5.entrySet().remove(ImmutableEntry.of(4, null)));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map5);
        }
        else
        {

            assertThrows(NullPointerException.class, () -> map5.entrySet().remove(ImmutableEntry.of(4, null)));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map5);
        }
    }

    @Test
    default void Map_put()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertNull(map.put(4, "Four"));
        assertIterablesEqual(
                this.newWithKeysValues(3, "Three", 2, "Two", 1, "One", 4, "Four"),
                map);
        assertEquals("Three", map.put(3, "Three3"));
        assertIterablesEqual(
                this.newWithKeysValues(3, "Three3", 2, "Two", 1, "One", 4, "Four"),
                map);

        if (this.supportsNullValues())
        {
            assertNull(map.put(5, null));
            assertEquals(
                    this.newWithKeysValues(3, "Three3", 2, "Two", 1, "One", 4, "Four", 5, null),
                    map);
            assertNull(map.put(5, "Five"));
            assertEquals(
                    this.newWithKeysValues(3, "Three3", 2, "Two", 1, "One", 4, "Four", 5, "Five"),
                    map);
        }

        if (this.supportsNullKeys())
        {
            assertNull(map.put(null, "Six"));
            assertIterablesEqual(
                    this.newWithKeysValues(3, "Three3", 2, "Two", 1, "One", 4, "Four", 5, "Five", null, "Six"),
                    map);
            assertEquals("Six", map.put(null, "Seven"));
            assertIterablesEqual(
                    this.newWithKeysValues(3, "Three3", 2, "Two", 1, "One", 4, "Four", 5, "Five", null, "Seven"),
                    map);
        }

        AlwaysEqual key1 = new AlwaysEqual();
        AlwaysEqual key2 = new AlwaysEqual();
        Object value1 = new Object();
        Object value2 = new Object();
        Map<AlwaysEqual, Object> map2 = (Map<AlwaysEqual, Object>) this.newWithKeysValues(key1, value1);
        Object previousValue = map2.put(key2, value2);
        assertSame(value1, previousValue);
        map2.forEach((key, value) -> assertSame(key1, key));
        map2.forEach((key, value) -> assertSame(value2, value));
    }

    @Test
    default void Map_putAll()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(
                3, "Three",
                2, "2");
        Map<Integer, String> toAdd = (Map<Integer, String>) this.newWithKeysValues(
                2, "Two",
                1, "One");

        map.putAll(toAdd);

        Map<Integer, String> expected = (Map<Integer, String>) this.newWithKeysValues(
                3, "Three",
                2, "Two",
                1, "One");
        assertIterablesEqual(expected, map);

        assertThrows(NullPointerException.class, () -> map.putAll(null));
        assertIterablesEqual(expected, map);

        map.putAll(Map.of());
        assertIterablesEqual(expected, map);

        //Testing JDK map
        Map<Integer, String> map2 = (Map<Integer, String>) this.newWithKeysValues(
                3, "Three",
                2, "2");
        Map<Integer, String> hashMapToAdd = new LinkedHashMap<>();
        hashMapToAdd.put(2, "Two");
        hashMapToAdd.put(1, "One");
        map2.putAll(hashMapToAdd);

        assertIterablesEqual(expected, map2);
    }

    @Test
    default void Map_merge()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");

        // null value
        assertThrows(NullPointerException.class, () -> map.merge(1, null, (v1, v2) -> {
            fail("Expected no merge to be performed since the value is null");
            return null;
        }));
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        // null remapping function
        assertThrows(NullPointerException.class, () -> map.merge(1, "4", null));
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        // new key, remapping function isn't called
        String value1 = map.merge(4, "4", (v1, v2) -> {
            fail("Expected no merge to be performed since the key is not present in the map");
            return null;
        });
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"), map);
        assertIterablesEqual("4", value1);

        // existing key
        String value2 = map.merge(2, "Two", (v1, v2) -> {
            assertIterablesEqual("2", v1);
            assertIterablesEqual("Two", v2);
            return v1 + v2;
        });
        assertEquals("2Two", value2);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2Two", 3, "3", 4, "4"), map);

        // existing key, null returned from remapping function, removes key
        String value3 = map.merge(3, "Three", (v1, v2) -> null);
        assertNull(value3);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2Two", 4, "4"), map);

        // new key, null returned from remapping function
        String value4 = map.merge(5, "5", (v1, v2) -> null);
        assertEquals("5", value4);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2Two", 4, "4", 5, "5"), map);

        // existing key, remapping function throws exception
        assertThrows(IllegalArgumentException.class, () -> map.merge(4, "Four", (v1, v2) -> {
            throw new IllegalArgumentException();
        }));
        assertEquals(this.newWithKeysValues(1, "1", 2, "2Two", 4, "4", 5, "5"), map);
    }

    @Test
    default void Map_replace()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");

        String value1 = map.replace(1, "One");
        assertEquals("1", value1);
        assertEquals(this.newWithKeysValues(1, "One", 2, "2", 3, "3"), map);

        String value2 = map.replace(1, "One");
        assertEquals("One", value2);
        assertEquals(this.newWithKeysValues(1, "One", 2, "2", 3, "3"), map);

        String value3 = map.replace(4, "Four");
        assertNull(value3);
        assertEquals(this.newWithKeysValues(1, "One", 2, "2", 3, "3"), map);

        if (this.supportsNullKeys())
        {
            String value4 = map.replace(null, "Four");
            assertNull(value4);
            assertEquals(this.newWithKeysValues(1, "One", 2, "2", 3, "3"), map);

            Map<Integer, String> map2 = (Map<Integer, String>) this.newWithKeysValues(1, "1", null, "2", 3, "3");
            String value5 = map2.replace(null, "Four");
            assertEquals("2", value5);
            assertEquals(this.newWithKeysValues(1, "1", null, "Four", 3, "3"), map2);
        }

        if (this.supportsNullValues())
        {
            Map<Integer, String> map3 = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");
            String value6 = map3.replace(3, null);
            assertEquals("3", value6);
            assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, null), map3);

            Map<Integer, String> map4 = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");
            String value7 = map4.replace(4, null);
            assertNull(value7);
            assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map4);
        }
    }

    @Test
    default void Map_replaceAll()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");

        map.replaceAll((k, v) -> v + v);
        assertEquals(this.newWithKeysValues(1, "11", 2, "22", 3, "33"), map);

        if (this.supportsNullValues())
        {
            map.replaceAll((k, v) -> k == 2 ? null : v);
            assertEquals(this.newWithKeysValues(1, "11", 2, null, 3, "33"), map);
        }

        if (this.supportsNullKeys())
        {
            Map<Integer, String> map2 = (Map<Integer, String>) this.newWithKeysValues(1, "1", null, "2", 3, "3");
            map2.replaceAll((k, v) -> v + v);
            assertEquals(this.newWithKeysValues(1, "11", null, "22", 3, "33"), map2);
        }
    }

    @Test
    default void Map_putIfAbsent()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");

        String value1 = map.putIfAbsent(1, "1");
        assertEquals("1", value1);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        String value2 = map.putIfAbsent(1, "One");
        assertEquals("1", value2);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        if (this.supportsNullValues())
        {
            String value3 = map.putIfAbsent(1, null);
            assertEquals("1", value3);
            assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);
        }

        String value4 = map.putIfAbsent(4, "4");
        assertNull(value4);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4"), map);

        if (supportsNullValues())
        {
            String value5 = map.putIfAbsent(5, null);
            assertNull(value5);
            assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4", 5, null), map);
        }
        if (this.supportsNullKeys())
        {
            String value6 = map.putIfAbsent(null, "6");
            assertNull(value6);
            assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4", 5, null, null, "6"), map);

            String value7 = map.putIfAbsent(null, "7");
            assertEquals("6", value7);
            assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "4", 5, null, null, "6"), map);
        }
    }

    @Test
    default void Map_removeValue()
    {
        Map<Integer, String> map1 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertTrue(map1.remove(2, "Two"));
        assertEquals(
                this.newWithKeysValues(3, "Three", 1, "One"),
                map1);

        Map<Integer, String> map2 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertFalse(map2.remove(4, "Four"));
        assertEquals(
                this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                map2);

        Map<Integer, String> map3 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertFalse(map3.remove(2, "One"));
        assertEquals(
                this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                map3);

        Map<Integer, String> map4 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
        assertFalse(map4.remove(4, "One"));
        assertEquals(
                this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                map4);

        if (this.supportsNullKeys())
        {
            Map<Integer, String> map5 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One");
            assertFalse(map5.remove(null, "Two"));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map5);

            Map<Integer, String> map6 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", null, "Two", 1, "One");
            assertTrue(map6.remove(null, "Two"));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 1, "One"),
                    map6);

            Map<Integer, String> map7 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", null, "Two", 1, "One");
            assertFalse(map7.remove(null, "One"));
            assertEquals(
                    this.newWithKeysValues(3, "Three", null, "Two", 1, "One"),
                    map7);
        }

        if (this.supportsNullValues())
        {
            Map<Integer, String> map8 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One", 4, null);
            assertTrue(map8.remove(4, null));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One"),
                    map8);

            Map<Integer, String> map9 = (Map<Integer, String>) this.newWithKeysValues(3, "Three", 2, "Two", 1, "One", 4, null);
            assertFalse(map9.remove(4, "One"));
            assertEquals(
                    this.newWithKeysValues(3, "Three", 2, "Two", 1, "One", 4, null),
                    map9);
        }
    }

    @Test
    default void Map_computeIfAbsent()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");

        String value1 = map.computeIfAbsent(1, k -> "1");
        assertEquals("1", value1);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        String value2 = map.computeIfAbsent(1, k -> "One");
        assertEquals("1", value2);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        String value3 = map.computeIfAbsent(1, k -> null);
        assertEquals("1", value3);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        String value4 = map.computeIfAbsent(4, k -> "Four");
        assertEquals("Four", value4);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "Four"), map);

        String value5 = map.computeIfAbsent(5, k -> null);
        assertNull(value5);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "Four"), map);

        if (this.supportsNullKeys())
        {
            String value6 = map.computeIfAbsent(null, k -> "4");
            assertEquals(value6, "4");
            assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "Four", null, "4"), map);

            String value7 = map.computeIfAbsent(null, k -> null);
            assertEquals(value7, "4");
            assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3", 4, "Four", null, "4"), map);
        }
    }

    @Test
    default void Map_computeIfPresent()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");

        String value1 = map.computeIfPresent(1, (k, v) -> "1");
        assertEquals("1", value1);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        String value2 = map.computeIfPresent(1, (k, v) -> "One");
        assertEquals("One", value2);
        assertEquals(this.newWithKeysValues(1, "One", 2, "2", 3, "3"), map);

        String value3 = map.computeIfPresent(1, (k, v) -> null);
        assertNull(value3);
        assertEquals(this.newWithKeysValues(2, "2", 3, "3"), map);

        String value4 = map.computeIfPresent(4, (k, v) -> "Four");
        assertNull(value4);
        assertEquals(this.newWithKeysValues(2, "2", 3, "3"), map);

        String value5 = map.computeIfPresent(4, (k, v) -> null);
        assertNull(value5);
        assertEquals(this.newWithKeysValues(2, "2", 3, "3"), map);

        if (this.supportsNullKeys())
        {
            String value6 = map.computeIfPresent(null, (k, v) -> "4");
            assertNull(value6);
            assertEquals(this.newWithKeysValues(2, "2", 3, "3"), map);

            Map<Integer, String> map2 = (Map<Integer, String>) this.newWithKeysValues(1, "1", null, "2", 3, "3");
            String value7 = map2.computeIfPresent(null, (k, v) -> "Two");
            assertEquals("Two", value7);
            assertEquals(this.newWithKeysValues(1, "1", null, "Two", 3, "3"), map2);
        }
    }

    @Test
    default void Map_compute()
    {
        Map<Integer, String> map = (Map<Integer, String>) this.newWithKeysValues(1, "1", 2, "2", 3, "3");

        String value1 = map.compute(1, (k, v) -> "1");
        assertEquals("1", value1);
        assertEquals(this.newWithKeysValues(1, "1", 2, "2", 3, "3"), map);

        String value2 = map.compute(1, (k, v) -> "One");
        assertEquals("One", value2);
        assertEquals(this.newWithKeysValues(1, "One", 2, "2", 3, "3"), map);

        String value3 = map.compute(1, (k, v) -> null);
        assertNull(value3);
        assertEquals(this.newWithKeysValues(2, "2", 3, "3"), map);

        String value4 = map.compute(4, (k, v) -> "Four");
        assertEquals("Four", value4);
        assertEquals(this.newWithKeysValues(2, "2", 3, "3", 4, "Four"), map);

        String value5 = map.compute(5, (k, v) -> null);
        assertNull(value5);
        assertEquals(this.newWithKeysValues(2, "2", 3, "3", 4, "Four"), map);

        if (this.supportsNullKeys())
        {
            String value6 = map.compute(null, (k, v) -> "6");
            assertEquals("6", value6);
            assertEquals(this.newWithKeysValues(2, "2", 3, "3", 4, "Four", null, "6"), map);

            String value7 = map.compute(null, (k, v) -> null);
            assertNull(value7);
            assertEquals(this.newWithKeysValues(2, "2", 3, "3", 4, "Four"), map);
        }
    }

    class AlwaysEqual
            implements Comparable<AlwaysEqual>
    {
        @Override
        public boolean equals(Object obj)
        {
            return obj != null;
        }

        @Override
        public int hashCode()
        {
            return 0;
        }

        @Override
        public int compareTo(AlwaysEqual o)
        {
            return 0;
        }
    }
}
