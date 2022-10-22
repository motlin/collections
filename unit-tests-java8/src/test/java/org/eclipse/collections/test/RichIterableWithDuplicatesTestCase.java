/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test;

import org.junit.jupiter.api.Test;

import static org.eclipse.collections.test.IterableTestCase.assertIterablesEqual;

public interface RichIterableWithDuplicatesTestCase extends RichIterableTestCase
{
    @Override
    default boolean allowsDuplicates()
    {
        return true;
    }

    @Test
    default void Iterable_sanity_check()
    {
        Integer i = 3;
        Iterable<Integer> oneCopy = this.newWith(i);
        Iterable<Integer> twoCopies = this.newWith(i, i);
        assertIterablesEqual(!this.allowsDuplicates(), twoCopies.equals(oneCopy));
    }

    @Test
    default void RichIterable_size()
    {
        assertIterablesEqual(6, this.newWith(3, 3, 3, 2, 2, 1).size());
    }
}
