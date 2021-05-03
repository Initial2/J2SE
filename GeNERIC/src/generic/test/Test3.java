package generic.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author initial
 * @create 2021-03-07 14:18
 */
public class Test3 {
    @Test
    public void test1(){
        //如果不使用通配符
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        //list1 = list2;  这样写是错误的, 因为list1和list2 是并列关系

        //使用通配符
        ArrayList<?> list3 = new ArrayList<>();
        list3 = list1;
        list3 = list2;   //list3就相当于是list1和list2的公共父类,所以编译通过
    }

    //使用通配符 ? 以后, 就不用关心传进来的数组是什么类型了
    public void show(List<?>  list){
        for (Object o : list) {
            System.out.println(o);
        }

    }


    @Test
    public void test2(){
        List<?>  list1 = new ArrayList<>();
        List<Object>  objectList = new ArrayList<>();
        List<String>  stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("egf");
        list1 = stringList;

        //可以获取stringList的数据, 但是类型为Object类型
        Object o = list1.get(0);
        System.out.println(o);


    }
 }
