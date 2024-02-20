/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.sorted.mutable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.annotation.Beta;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.factory.SortedSets;
import org.eclipse.collections.api.factory.primitive.BooleanLists;
import org.eclipse.collections.api.factory.primitive.ByteLists;
import org.eclipse.collections.api.factory.primitive.CharLists;
import org.eclipse.collections.api.factory.primitive.DoubleLists;
import org.eclipse.collections.api.factory.primitive.FloatLists;
import org.eclipse.collections.api.factory.primitive.IntLists;
import org.eclipse.collections.api.factory.primitive.LongLists;
import org.eclipse.collections.api.factory.primitive.ShortLists;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.ordered.OrderedIterable;
import org.eclipse.collections.api.partition.set.sorted.PartitionMutableSortedSet;
import org.eclipse.collections.api.set.SetIterable;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.set.sorted.SortedSetIterable;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.block.procedure.PartitionPredicate2Procedure;
import org.eclipse.collections.impl.block.procedure.PartitionProcedure;
import org.eclipse.collections.impl.block.procedure.RejectProcedure;
import org.eclipse.collections.impl.block.procedure.SelectInstancesOfProcedure;
import org.eclipse.collections.impl.block.procedure.SelectProcedure;
import org.eclipse.collections.impl.block.procedure.checked.CheckedProcedure;
import org.eclipse.collections.impl.collection.mutable.AbstractMutableCollection;
import org.eclipse.collections.impl.lazy.parallel.set.sorted.NonParallelSortedSetIterable;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.multimap.set.sorted.TreeSortedSetMultimap;
import org.eclipse.collections.impl.partition.set.sorted.PartitionTreeSortedSet;
import org.eclipse.collections.impl.utility.ArrayIterate;
import org.eclipse.collections.impl.utility.Iterate;
import org.eclipse.collections.impl.utility.OrderedIterate;
import org.eclipse.collections.impl.utility.internal.IterableIterate;
import org.eclipse.collections.impl.utility.internal.SetIterables;
import org.eclipse.collections.impl.utility.internal.SortedSetIterables;

public class TreeSortedSet<T> extends AbstractMutableSortedSet<T> implements Externalizable
{
    private static final long serialVersionUID = 1L;
    private TreeSet<T> treeSet;

    public TreeSortedSet()
    {
        this.treeSet = new TreeSet<>();
    }

    public TreeSortedSet(Iterable<? extends T> iterable)
    {
        this.treeSet = new TreeSet<>();
        this.addAllIterable(iterable);
    }

    public TreeSortedSet(Comparator<? super T> comparator)
    {
        this.treeSet = new TreeSet<>(comparator);
    }

    public TreeSortedSet(SortedSet<T> set)
    {
        this.treeSet = new TreeSet<>(set);
    }

    public TreeSortedSet(Comparator<? super T> comparator, Iterable<? extends T> iterable)
    {
        this(comparator);
        this.addAllIterable(iterable);
    }

    public static <T> TreeSortedSet<T> newSet()
    {
        return new TreeSortedSet<>();
    }

    public static <T> TreeSortedSet<T> newSet(Comparator<? super T> comparator)
    {
        return new TreeSortedSet<>(comparator);
    }

    public static <T> TreeSortedSet<T> newSet(Iterable<? extends T> source)
    {
        if (source instanceof SortedSet<?>)
        {
            return new TreeSortedSet<>((SortedSet<T>) source);
        }
        TreeSortedSet<T> sortedSet = TreeSortedSet.newSet();
        Iterate.forEach(source, CollectionAddProcedure.on(sortedSet));
        return sortedSet;
    }

    public static <T> TreeSortedSet<T> newSet(Comparator<? super T> comparator, Iterable<? extends T> iterable)
    {
        return new TreeSortedSet<>(comparator, iterable);
    }

    public static <T> TreeSortedSet<T> newSetWith(T... elements)
    {
        return new TreeSortedSet<T>().with(elements);
    }

    public static <T> TreeSortedSet<T> newSetWith(Comparator<? super T> comparator, T... elements)
    {
        return new TreeSortedSet<T>(comparator).with(elements);
    }

    @Override
    public boolean add(T element)
    {
        return this.treeSet.add(element);
    }

    @Override
    public boolean remove(Object element)
    {
        return this.treeSet.remove(element);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection)
    {
        return this.treeSet.addAll(collection);
    }

    @Override
    public boolean contains(Object o)
    {
        return this.treeSet.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection)
    {
        return Iterate.allSatisfyWith(collection, Predicates2.in(), this.treeSet);
    }

    @Override
    public void clear()
    {
        this.treeSet.clear();
    }

    @Override
    public TreeSortedSet<T> clone()
    {
        TreeSortedSet<T> clone = (TreeSortedSet<T>) super.clone();
        clone.treeSet = (TreeSet<T>) this.treeSet.clone();
        return clone;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }

        return this.treeSet.equals(object);
    }

    @Override
    public int hashCode()
    {
        return this.treeSet.hashCode();
    }

    @Override
    public TreeSortedSet<T> with(T element)
    {
        this.treeSet.add(element);
        return this;
    }

    public TreeSortedSet<T> with(T element1, T element2)
    {
        this.treeSet.add(element1);
        this.treeSet.add(element2);
        return this;
    }

    public TreeSortedSet<T> with(T element1, T element2, T element3)
    {
        this.treeSet.add(element1);
        this.treeSet.add(element2);
        this.treeSet.add(element3);
        return this;
    }

    public TreeSortedSet<T> with(T... elements)
    {
        ArrayIterate.forEach(elements, CollectionAddProcedure.on(this.treeSet));
        return this;
    }

    @Override
    public TreeSortedSet<T> without(T element)
    {
        this.remove(element);
        return this;
    }

    @Override
    public TreeSortedSet<T> withAll(Iterable<? extends T> elements)
    {
        this.addAllIterable(elements);
        return this;
    }

    @Override
    public TreeSortedSet<T> withoutAll(Iterable<? extends T> elements)
    {
        this.removeAllIterable(elements);
        return this;
    }

    @Override
    public TreeSortedSet<T> newEmpty()
    {
        return TreeSortedSet.newSet(this.treeSet.comparator());
    }

    @Override
    public TreeSortedSet<T> tap(Procedure<? super T> procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    public void each(Procedure<? super T> procedure)
    {
        IterableIterate.forEach(this, procedure);
    }

    @Override
    public TreeSortedSet<T> select(Predicate<? super T> predicate)
    {
        TreeSortedSet<T> result = this.newEmpty();
        this.forEach(new SelectProcedure<>(predicate, result));
        return result;
    }

    @Override
    public TreeSortedSet<T> reject(Predicate<? super T> predicate)
    {
        TreeSortedSet<T> result = this.newEmpty();
        this.forEach(new RejectProcedure<>(predicate, result));
        return result;
    }

    @Override
    public PartitionMutableSortedSet<T> partition(Predicate<? super T> predicate)
    {
        PartitionTreeSortedSet<T> partitionTreeSortedSet = new PartitionTreeSortedSet<>(this.comparator());
        this.forEach(new PartitionProcedure<>(predicate, partitionTreeSortedSet));
        return partitionTreeSortedSet;
    }

    @Override
    public <P> PartitionMutableSortedSet<T> partitionWith(Predicate2<? super T, ? super P> predicate, P parameter)
    {
        PartitionTreeSortedSet<T> partitionTreeSortedSet = new PartitionTreeSortedSet<>(this.comparator());
        this.forEach(new PartitionPredicate2Procedure<>(predicate, parameter, partitionTreeSortedSet));
        return partitionTreeSortedSet;
    }

    @Override
    public PartitionMutableSortedSet<T> partitionWhile(Predicate<? super T> predicate)
    {
        PartitionTreeSortedSet<T> result = new PartitionTreeSortedSet<>(this.comparator());
        return IterableIterate.partitionWhile(this, predicate, result);
    }

    @Override
    public <S> TreeSortedSet<S> selectInstancesOf(Class<S> clazz)
    {
        TreeSortedSet<S> result = (TreeSortedSet<S>) this.newEmpty();
        this.forEach(new SelectInstancesOfProcedure<>(clazz, result));
        return result;
    }

    @Override
    public <V> TreeSortedSetMultimap<V, T> groupBy(Function<? super T, ? extends V> function)
    {
        return Iterate.groupBy(this.treeSet, function, TreeSortedSetMultimap.newMultimap(this.comparator()));
    }

    @Override
    public <V> TreeSortedSetMultimap<V, T> groupByEach(Function<? super T, ? extends Iterable<V>> function)
    {
        return Iterate.groupByEach(this.treeSet, function, TreeSortedSetMultimap.newMultimap(this.comparator()));
    }

    @Override
    public <P> TreeSortedSet<T> selectWith(Predicate2<? super T, ? super P> predicate, P parameter)
    {
        return Iterate.selectWith(this.treeSet, predicate, parameter, this.newEmpty());
    }

    @Override
    public <P> TreeSortedSet<T> rejectWith(Predicate2<? super T, ? super P> predicate, P parameter)
    {
        return Iterate.rejectWith(this.treeSet, predicate, parameter, this.newEmpty());
    }

    @Override
    public <P, V> MutableList<V> collectWith(Function2<? super T, ? super P, ? extends V> function, P parameter)
    {
        return Iterate.collectWith(this.treeSet, function, parameter, Lists.mutable.empty());
    }

    @Override
    public <S> MutableList<Pair<T, S>> zip(Iterable<S> that)
    {
        if (that instanceof Collection || that instanceof RichIterable)
        {
            int thatSize = Iterate.sizeOf(that);
            MutableList<Pair<T, S>> target = Lists.mutable.withInitialCapacity(Math.min(this.size(), thatSize));
            return Iterate.zip(this, that, target);
        }
        return Iterate.zip(this, that, Lists.mutable.empty());
    }

    @Override
    public TreeSortedSet<Pair<T, Integer>> zipWithIndex()
    {
        Comparator<? super T> comparator = this.comparator();
        if (comparator == null)
        {
            TreeSortedSet<Pair<T, Integer>> pairs = TreeSortedSet.newSet(Comparators.byFunction(Functions.firstOfPair(), Comparators.naturalOrder()));
            return Iterate.zipWithIndex(this, pairs);
        }
        return Iterate.zipWithIndex(this, TreeSortedSet.newSet(Comparators.byFirstOfPair(comparator)));
    }

    @Override
    public MutableSortedSet<T> distinct()
    {
        return this.clone();
    }

    @Override
    public <S> boolean corresponds(OrderedIterable<S> other, Predicate2<? super T, ? super S> predicate)
    {
        return OrderedIterate.corresponds(this, other, predicate);
    }

    @Override
    public Comparator<? super T> comparator()
    {
        return this.treeSet.comparator();
    }

    @Override
    public MutableSortedSet<T> subSet(T fromElement, T toElement)
    {
        return SortedSetAdapter.adapt(this.treeSet.subSet(fromElement, toElement));
    }

    @Override
    public MutableSortedSet<T> headSet(T toElement)
    {
        return SortedSetAdapter.adapt(this.treeSet.headSet(toElement));
    }

    @Override
    public MutableSortedSet<T> tailSet(T fromElement)
    {
        return SortedSetAdapter.adapt(this.treeSet.tailSet(fromElement));
    }

    @Override
    public T first()
    {
        return this.treeSet.first();
    }

    @Override
    public T last()
    {
        return this.treeSet.last();
    }

    @Override
    public int indexOf(Object object)
    {
        if (this.treeSet.contains(object))
        {
            return this.treeSet.headSet((T) object).size();
        }
        return -1;
    }

    @Override
    public T getFirst()
    {
        return this.first();
    }

    @Override
    public T getLast()
    {
        return this.last();
    }

    @Override
    public MutableSortedSet<SortedSetIterable<T>> powerSet()
    {
        return (MutableSortedSet<SortedSetIterable<T>>) (MutableSortedSet<?>) SortedSetIterables.powerSet(this);
    }

    @Override
    public <B> LazyIterable<Pair<T, B>> cartesianProduct(SetIterable<B> set)
    {
        return SetIterables.cartesianProduct(this, set);
    }

    @Override
    public TreeSortedSet<T> union(SetIterable<? extends T> set)
    {
        return SetIterables.unionInto(this, set, this.newEmpty());
    }

    @Override
    public TreeSortedSet<T> intersect(SetIterable<? extends T> set)
    {
        return SetIterables.intersectInto(this, set, this.newEmpty());
    }

    @Override
    public TreeSortedSet<T> difference(SetIterable<? extends T> subtrahendSet)
    {
        return SetIterables.differenceInto(this, subtrahendSet, this.newEmpty());
    }

    @Override
    public Iterator<T> iterator()
    {
        return this.treeSet.iterator();
    }

    @Override
    public int size()
    {
        return this.treeSet.size();
    }

    @Override
    public MutableSortedSet<T> toReversed()
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".toReversed() not implemented yet");
    }

    @Override
    public void reverseForEach(Procedure<? super T> procedure)
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".reverseForEach() not implemented yet");
    }

    @Override
    public void reverseForEachWithIndex(ObjectIntProcedure<? super T> procedure)
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".reverseForEachWithIndex() not implemented yet");
    }

    @Override
    public int detectLastIndex(Predicate<? super T> predicate)
    {
        throw new UnsupportedOperationException(this.getClass().getSimpleName() + ".detectLastIndex() not implemented yet");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(this.comparator());
        out.writeInt(this.size());
        this.forEach(new CheckedProcedure<T>()
        {
            public void safeValue(T each) throws Exception
            {
                out.writeObject(each);
            }
        });
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        this.treeSet = new TreeSet<>((Comparator<T>) in.readObject());
        int size = in.readInt();
        for (int i = 0; i < size; i++)
        {
            this.add((T) in.readObject());
        }
    }
}
