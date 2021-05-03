package collection.test;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author initial
 * @create 2021-03-02 15:57
 */
public class test1 {

    //1. add(E e)方法  向集合中添加指定元素
    @Test
    public  void  test(){
        //因为Collection是接口,所以用它实现类创建对象
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add("abc");
        collection.add(new Date());

        System.out.println(collection.contains(123));
        collection.clear();
        System.out.println(collection.contains(456));
    }

    @Test
    public void test2(){
        Collection collection = new ArrayList();
        //向集合中添加一个字符串对象
        collection.add(new String("ABC"));

        //再建一个字符串对象进行对比
        boolean abc = collection.contains(new String("ABC"));
        System.out.println(abc);

    }

    @Test
    public void test3() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);

        Object[] objects = collection.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }

    @Test
    public void test4(){
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3, 4});
        System.out.println(integers);

    }

}
