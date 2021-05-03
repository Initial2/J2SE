package collection.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author initial
 * @create 2021-03-02 17:32
 */




public class test2 {
    public static void main(String[] args) {
        ArrayList collection = new ArrayList();

        collection.add("123");
        collection.add(456);
        collection.add(789);

        for (Object obj: collection) {
            System.out.println(obj);
        }

    }

    @Test
    public void test1(){
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        //注意区分remove的两种重载形式
        arrayList.remove(2);  //删除索引位置的元素  1,2
        //arrayList.remove(new Integer(2));  //删除指定元素 1,3
        System.out.println(arrayList);
    }
}
