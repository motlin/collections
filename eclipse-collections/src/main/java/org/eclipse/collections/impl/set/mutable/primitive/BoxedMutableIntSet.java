/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.ParallelUnsortedSetIterable;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.set.mutable.AbstractMutableSet;

/**
 * This wrapper is used to adapt a primitive set as a MutableSet and may be useful for compatibility. It performs boxing
 * on the fly, losing many of the performance benefits of a primitive collection. We do not intend to optimize this
 * class for performance.
 */
public class BoxedMutableIntSet
        extends AbstractMutableSet<Integer>
        implements MutableSet<Integer>
{
    private final MutableIntSet delegate;

    public BoxedMutableIntSet(MutableIntSet delegate)
    {
        this.delegate = Objects.requireNonNull(delegate);
    }

    @Override
    public int size()
    {
        return this.delegate.size();
    }

    @Override
    public Integer getFirst()
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".getFirst() not implemented yet");
    }

    @Override
    public Integer getLast()
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".getLast() not implemented yet");
    }

    @Override
    public boolean add(Integer integer)
    {
        return this.delegate.add(integer.intValue());
    }

    @Override
    public void clear()
    {
        this.delegate.clear();
    }

    @Override
    public void each(Procedure<? super Integer> procedure)
    {
        this.delegate.each(procedure::value);
    }

    @Override
    public ParallelUnsortedSetIterable<Integer> asParallel(ExecutorService executorService, int batchSize)
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".asParallel() not implemented yet");
    }

    @Override
    public Iterator<Integer> iterator()
    {
        MutableIntIterator delegateIterator = this.delegate.intIterator();
        return new Iterator<Integer>()
        {
            @Override
            public boolean hasNext()
            {
                return delegateIterator.hasNext();
            }

            @Override
            public Integer next()
            {
                return delegateIterator.next();
            }

            @Override
            public void remove()
            {
                delegateIterator.remove();
            }
        };
    }
}
