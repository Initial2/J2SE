package generic.test;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author initial
 * @create 2021-03-06 14:20
 */
public class HashMapTest {

    @Test
    public void test1(){
        //HashMap中,可以分别用两个泛型指定 key 和 value 的类型.
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("张三",18);
        hashMap.put("李四",21);
        hashMap.put("王五",36);
        //hashMap.put(215,521); 编译错误, key和value的类型必须和指定的一样

        //进行遍历
        /*
        这里体现了泛型是可以嵌套使用的. Set中定义的元素类型是Map.Entry
        Map.Entry中定义的元素类型就是我们指定的String , Integer
         */
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            //获取,每一个Entry. 因为我们提前指定了泛型. 所以编译器就知道元素的类型了
            //就不用在进行强转
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key + "  --- "+ value);
        }


    }
}
