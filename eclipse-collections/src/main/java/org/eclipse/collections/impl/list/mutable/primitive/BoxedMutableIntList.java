/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.mutable.primitive;

import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.list.mutable.AbstractMutableList;

/**
 * This wrapper is used to adapt a primitive set as a MutableSet and may be useful for compatibility. It performs boxing
 * on the fly, losing many of the performance benefits of a primitive collection. We do not intend to optimize this
 * class for performance.
 */
public class BoxedMutableIntList
        extends AbstractMutableList<Integer>
        implements MutableList<Integer>, RandomAccess
{
    private final MutableIntList delegate;

    public BoxedMutableIntList(MutableIntList delegate)
    {
        this.delegate = Objects.requireNonNull(delegate);
    }

    @Override
    public int size()
    {
        return this.delegate.size();
    }

    @Override
    public boolean add(Integer integer)
    {
        return this.delegate.add(integer.intValue());
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c)
    {
        return this.delegate.addAllAtIndex(index, c.stream().mapToInt(Integer::intValue).toArray());
    }

    @Override
    public void clear()
    {
        this.delegate.clear();
    }

    @Override
    public Integer get(int index)
    {
        return this.delegate.get(index);
    }

    @Override
    public Integer set(int index, Integer element)
    {
        return this.delegate.set(index, element.intValue());
    }

    @Override
    public void add(int index, Integer element)
    {
        this.delegate.addAtIndex(index, element.intValue());
    }

    @Override
    public Integer remove(int index)
    {
        return this.delegate.removeAtIndex(index);
    }
}
