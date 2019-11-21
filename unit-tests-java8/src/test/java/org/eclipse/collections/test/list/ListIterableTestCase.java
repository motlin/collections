/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.list;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.test.OrderedIterableWithDuplicatesTestCase;
import org.junit.Test;

import static org.eclipse.collections.impl.test.Verify.assertThrows;
import static org.eclipse.collections.test.IterableTestCase.assertEquals;

public interface ListIterableTestCase extends OrderedIterableWithDuplicatesTestCase, TransformsToListTrait
{
    @Override
    <T> ListIterable<T> newWith(T... elements);

    @Override
    default <T> ListIterable<T> getExpectedFiltered(T... elements)
    {
        return ImmutableList.of(elements);
    }

    @Override
    default <T> MutableList<T> newMutableForFilter(T... elements)
    {
        return MutableList.of(elements);
    }

    @Override
    default <T> ListIterable<T> getExpectedTransformed(T... elements)
    {
        return ImmutableList.of(elements);
    }

    @Test
    default void ListIterable_forEachWithIndex()
    {
        RichIterable<Integer> integers = this.newWith(1, 2, 3);
        MutableCollection<Pair<Integer, Integer>> result = MutableList.empty();
        integers.forEachWithIndex((each, index) -> result.add(Tuples.pair(each, index)));
        assertEquals(
                ImmutableList.of(Tuples.pair(1, 0), Tuples.pair(2, 1), Tuples.pair(3, 2)),
                result);
    }

    @Test
    default void ListIterable_indexOf()
    {
        ListIterable<Integer> integers = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        assertEquals(3, integers.indexOf(3));
        assertEquals(-1, integers.indexOf(0));
        assertEquals(-1, integers.indexOf(null));
        ListIterable<Integer> integers2 = this.newWith(1, 2, 2, null, 3, 3, 3, null, 4, 4, 4, 4);
        assertEquals(3, integers2.indexOf(null));
    }

    @Test
    default void ListIterable_lastIndexOf()
    {
        ListIterable<Integer> integers = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        assertEquals(5, integers.lastIndexOf(3));
        assertEquals(-1, integers.lastIndexOf(0));
        assertEquals(-1, integers.lastIndexOf(null));
        ListIterable<Integer> integers2 = this.newWith(1, 2, 2, null, 3, 3, 3, null, 4, 4, 4, 4);
        assertEquals(7, integers2.lastIndexOf(null));
    }

    @Test
    default void OrderedIterable_forEach_from_to()
    {
        ListIterable<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);

        MutableList<Integer> result = MutableList.empty();
        integers.forEach(5, 7, result::add);
        assertEquals(ImmutableList.of(3, 3, 2), result);

        MutableList<Integer> result2 = MutableList.empty();
        integers.forEach(0, 9, result2::add);
        assertEquals(ImmutableList.of(4, 4, 4, 4, 3, 3, 3, 2, 2, 1), result2);

        ListIterable<Integer> integers2 = this.newWith(4, 4, 4, 4, 3, 3, 3);
        MutableList<Integer> result3 = MutableList.empty();
        integers2.forEach(5, 6, result3::add);
        assertEquals(ImmutableList.of(3, 3), result3);

        MutableList<Integer> result4 = MutableList.empty();
        integers2.forEach(3, 3, result4::add);
        assertEquals(ImmutableList.of(4), result4);

        MutableList<Integer> result5 = MutableList.empty();
        integers2.forEach(4, 4, result5::add);
        assertEquals(ImmutableList.of(3), result5);

        MutableList<Integer> result6 = MutableList.empty();
        integers2.forEach(5, 5, result6::add);
        assertEquals(ImmutableList.of(3), result6);

        MutableList<Integer> result7 = MutableList.empty();
        integers2.forEach(6, 6, result7::add);
        assertEquals(ImmutableList.of(3), result7);

        assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(-1, 0, result::add));
        assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(0, -1, result::add));
        assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(0, 10, result::add));
        assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(10, 0, result::add));
    }

    @Test
    default void OrderedIterable_forEach_from_to_reverse_order()
    {
        ListIterable<Integer> integers = this.newWith(4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        MutableList<Integer> result = MutableList.empty();
        integers.forEach(7, 5, result::add);
        assertEquals(ImmutableList.of(2, 3, 3), result);
    }

    @Test
    default void ListIterable_distinct()
    {
        ListIterable<String> letters = this.newWith("A", "a", "b", "c", "B", "D", "e", "e", "E", "D").distinct(HashingStrategies.fromFunction(String::toLowerCase));
        ListIterable<String> expected = FastList.newListWith("A", "b", "c", "D", "e");
        assertEquals(letters, expected);

        ListIterable<String> empty = this.<String>newWith().distinct(HashingStrategies.fromFunction(String::toLowerCase));
        assertEquals(empty, this.newWith());
    }
}

