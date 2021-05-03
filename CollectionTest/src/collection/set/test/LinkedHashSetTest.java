package collection.set.test;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author initial
 * @create 2021-03-04 13:48
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(123);
        linkedHashSet.add(456);
        linkedHashSet.add(789);

        Iterator iterator = linkedHashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
