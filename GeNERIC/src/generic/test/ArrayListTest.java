package generic.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author initial
 * @create 2021-03-06 14:12
 */
public class ArrayListTest {

    @Test
    public void test1(){
        //在ArrayList当中使用泛型,定义为String类型
        //那么list当中就只能放String类型的元素了
        ArrayList<String> list = new ArrayList<String>();

        //当我们在集合当中定义了泛型以后. 在编译时,就会自动检查元素类型,保证数据的一致性
        list.add("AA");
        list.add("BB");
        list.add("BB");
        // list.add(123); 编译报错,不能添加整型

        //在遍历时也不用再进行类型强转了
        //注意: Iterator也使用了泛型结构.  它和list定义的泛型相同
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }



    }
}
