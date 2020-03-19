package Task5;

import java.util.Iterator;
import java.util.SortedSet;

public class TestSet {
    public static void main(String[] args) {
        IntegerComparatorForNavigableSet comparator = new IntegerComparatorForNavigableSet();
        MyNavigableSet mns = new MyNavigableSet(comparator);
        mns.add(1);
        mns.add(4);
        mns.add(6);
        mns.add(3);
        mns.add(5);
        mns.add(7);
        mns.add(7);
        mns.add(8);
        mns.add(2);

        System.out.print("NavigableSet: ");
        Iterator iterator = mns.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.print("ReverseNavigableSet: ");
        Iterator reverseIterator = mns.descendingIterator();
        while(reverseIterator.hasNext()){
            System.out.print(reverseIterator.next() + " ");
        }
        System.out.println();

        System.out.print("Floor (3): ");
        System.out.println(mns.floor(3));

        System.out.print("Subset (3-5): ");
        SortedSet sortedSet = mns.subSet(3,5);
        Iterator subSetIterator = sortedSet.iterator();
        while(subSetIterator.hasNext()){
            System.out.print(subSetIterator.next() + " ");
        }
        System.out.println();

        System.out.print("headSet (4): ");
        SortedSet headSet = mns.headSet(4);
        Iterator headSetIterator = headSet.iterator();
        while(headSetIterator.hasNext()){
            System.out.print(headSetIterator.next() + " ");
        }
        System.out.println();

        System.out.print("tailSet (4): ");
        SortedSet tailSet = mns.tailSet(4);
        Iterator tailSetIterator = tailSet.iterator();
        while(tailSetIterator.hasNext()){
            System.out.print(tailSetIterator.next() + " ");
        }
        System.out.println();

        System.out.print("First: ");
        System.out.println(mns.first());

        System.out.print("Last: ");
        System.out.println(mns.last());

        //TODO normal ceiling
        System.out.print("Ceiling (3): ");
        System.out.println(mns.ceiling(3));

        System.out.print("descendingSet: ");
        MyNavigableSet descendingSet = mns.descendingSet();
        Iterator descendingSetIterator = descendingSet.iterator();
        while(descendingSetIterator.hasNext()){
            System.out.print(descendingSetIterator.next() + " ");
        }
        System.out.println();

        System.out.print("inclusiveHeadSet (5): ");
        MyNavigableSet inclusiveHeadSet = mns.headSet(5, true);
        Iterator inclusiveHeadSetIterator = inclusiveHeadSet.iterator();
        while(inclusiveHeadSetIterator.hasNext()){
            System.out.print(inclusiveHeadSetIterator.next() + " ");
        }
        System.out.println();

        System.out.print("Higher (3): ");
        System.out.println(mns.higher(3));

        System.out.print("Lower (6): ");
        System.out.println(mns.lower(6));

        System.out.print("pollFirst: ");
        System.out.println(mns.pollFirst());

        System.out.print("pollLast: ");
        System.out.println(mns.pollLast());

        System.out.print("NewNavigableSet: ");
        Iterator newIterator = mns.iterator();
        while(newIterator.hasNext()){
            System.out.print(newIterator.next() + " ");
        }
        System.out.println();

        System.out.print("subSet (4, true, 6, false): ");
        MyNavigableSet hardSubSet = mns.subSet(4, true, 6, false);
        Iterator hardSubSetIterator = hardSubSet.iterator();
        while(hardSubSetIterator.hasNext()){
            System.out.print(hardSubSetIterator.next() + " ");
        }
        System.out.println();

        System.out.print("InclusiveTailSet (4, true): ");
        MyNavigableSet inclusiveTailSet = mns.tailSet(4, true);
        Iterator inclusiveTailSetIterator = inclusiveTailSet.iterator();
        while(inclusiveTailSetIterator.hasNext()){
            System.out.print(inclusiveTailSetIterator.next() + " ");
        }
        System.out.println();
    }
}
