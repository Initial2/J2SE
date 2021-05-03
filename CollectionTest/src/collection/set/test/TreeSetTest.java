package collection.set.test;

import org.junit.Test;

import java.time.Period;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author initial
 * @create 2021-03-04 14:12
 */
public class TreeSetTest {

    @Test
    public void test1(){


        //自定义排序方式 使用Comparator接口
        // 按照姓名从小到大排序
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof  Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return p1.getName().compareTo(p1.getName());
                }else{
                    return -1;
                }
            }

        };

        //把我们定义的规则给他加进去
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("Jerry",14));
        treeSet.add(new Person("Tom",19));

        Iterator iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
