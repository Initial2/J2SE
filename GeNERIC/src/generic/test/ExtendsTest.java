package generic.test;

import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author initial
 * @create 2021-03-06 17:37
 */
public class ExtendsTest {
    @Test
    public void test1(){

        //在数组中,这样写是可以的 因为String 是Object的子类.
        //这里就相当于了多态的写法.
        Object[] array1 = new Object[5];
        String[] array2 = new String[5];
        array1 = array2;

        //但是在泛型当中, 这样是错误的. 编译不通过
       /* List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();*/
       // list1 =  list2; 错误

        //AbstractList 是  ArrayList的父类
        AbstractList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
    }
}
