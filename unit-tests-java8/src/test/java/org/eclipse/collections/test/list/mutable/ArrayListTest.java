/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.list.mutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.impl.test.junit.Java8Runner;
import org.eclipse.collections.test.list.ListTestCase;
import org.junit.runner.RunWith;

import static org.eclipse.collections.test.IterableTestCase.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Java8Runner.class)
public class ArrayListTest implements ListTestCase
{
    @SafeVarargs
    @Override
    public final <T> List<T> newWith(T... elements)
    {
        return new ArrayList<>(Arrays.asList(elements));
    }

    @Override
    public void List_subList_subList_clear()
    {
        List<String> list = this.newWith("A", "B", "C", "D", "E", "F");
        List<String> sublist = list.subList(3, 6);
        List<String> sublist2 = sublist.subList(0, 2);
        assertEquals(Lists.immutable.with("D", "E", "F"), sublist);
        assertEquals(Lists.immutable.with("D", "E"), sublist2);

        sublist2.clear();
        assertEquals(Lists.immutable.with("A", "B", "C", "F"), list);
        assertEquals(Lists.immutable.with("F"), sublist);
        assertEquals(Lists.immutable.with(), sublist2);

        sublist2.add("J");
        assertEquals(Lists.immutable.with("A", "B", "C", "J", "F"), list);
        assertEquals(Lists.immutable.with("J", "F"), sublist);
        assertEquals(Lists.immutable.with("J"), sublist2);

        sublist.add("H");
        assertEquals(Lists.immutable.with("A", "B", "C", "J", "F", "H"), list);
        assertEquals(Lists.immutable.with("J", "F", "H"), sublist);

        assertThrows(ConcurrentModificationException.class, sublist2::size);
    }
}
