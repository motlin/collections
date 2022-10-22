/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.MutableIntIntMap;
import org.eclipse.collections.impl.map.mutable.AbstractMutableMap;

/**
 * This wrapper is used to adapt a primitive set as a MutableSet and may be useful for compatibility. It performs boxing
 * on the fly, losing many of the performance benefits of a primitive collection. We do not intend to optimize this
 * class for performance.
 */
public class BoxedMutableIntIntMap
        extends AbstractMutableMap<Integer, Integer>
        implements MutableMap<Integer, Integer>
{
    private final MutableIntIntMap delegate;

    public BoxedMutableIntIntMap(MutableIntIntMap delegate)
    {
        this.delegate = Objects.requireNonNull(delegate);
    }

    @Override
    public int size()
    {
        return this.delegate.size();
    }

    @Override
    public <E> MutableMap<Integer, Integer> collectKeysAndValues(
            Iterable<E> iterable,
            Function<? super E, ? extends Integer> keyFunction,
            Function<? super E, ? extends Integer> valueFunction)
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName()
                + ".collectKeysAndValues() not implemented yet");
    }

    @Override
    public MutableMap<Integer, Integer> newEmpty()
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".newEmpty() not implemented yet");
    }

    @Override
    public Integer removeKey(Integer key)
    {
        if (this.delegate.containsKey(key))
        {
            return this.delegate.removeKeyIfAbsent(key, -1);
        }
        return null;
    }

    @Override
    public MutableMap<Integer, Integer> clone()
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".clone() not implemented yet");
    }

    @Override
    public <K, V> MutableMap<K, V> newEmpty(int capacity)
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".newEmpty() not implemented yet");
    }

    @Override
    public Integer put(Integer key, Integer value)
    {
        if (this.delegate.containsKey(key))
        {
            return this.delegate.getAndPut(key, value, -1);
        }
        return null;
    }

    @Override
    public Integer remove(Object key)
    {
        if (key instanceof Integer)
        {
            return this.removeKey((Integer) key);
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Integer> m)
    {
        m.forEach(this::put);
    }

    @Override
    public void clear()
    {
        this.delegate.clear();
    }

    @Override
    public Set<Integer> keySet()
    {
        return this.delegate.keySet().boxed();
    }

    @Override
    public Collection<Integer> values()
    {
        return this.delegate.values().boxed();
    }

    @Override
    public Set<Entry<Integer, Integer>> entrySet()
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".entrySet() not implemented yet");
    }

    @Override
    public Integer get(Object key)
    {
        if (key instanceof Integer)
        {
            return this.delegate.getIfAbsent((Integer) key, -1);
        }

        return null;
    }

    @Override
    public boolean containsKey(Object key)
    {
        if (key instanceof Integer)
        {
            return this.delegate.containsKey((Integer) key);
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value)
    {
        if (value instanceof Integer)
        {
            return this.delegate.containsValue((Integer) value);
        }

        return false;
    }

    @Override
    public void forEachKeyValue(Procedure2<? super Integer, ? super Integer> procedure)
    {
        this.delegate.forEachKeyValue(procedure::accept);
    }
}
