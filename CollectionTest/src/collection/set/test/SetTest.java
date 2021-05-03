package collection.set.test;

import java.time.Period;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author initial
 * @create 2021-03-03 14:57
 */
public class SetTest {
    public static void main(String[] args) {

        Person p1 = new Person("Tttt", 14);
        Person p2 = new Person("Tttt", 14);

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());


        Set set = new HashSet();
        set.add(123);
        set.add(new Person("Tom", 14));
        set.add(new Person("Tom", 14));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next().hashCode());
        }
    }


}
