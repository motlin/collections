/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.map.immutable.sorted;

import java.util.Map;

import org.eclipse.collections.api.map.sorted.ImmutableSortedMap;
import org.eclipse.collections.test.FixedSizeIterableTestCase;
import org.eclipse.collections.test.map.SortedMapIterableTestCase;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

public interface ImmutableSortedMapIterableTestCase extends SortedMapIterableTestCase, FixedSizeIterableTestCase
{
    @Override
    <T> ImmutableSortedMap<Object, T> newWith(T... elements);
}
