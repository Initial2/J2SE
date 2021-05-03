package collection.map.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author initial
 * @create 2021-03-05 15:16
 */
public class HashMapTest {
    @Test
    public void test1(){
        HashMap hashMap = new HashMap();
        hashMap.put(1,125);
        hashMap.put(3,126);
        hashMap.put(2,124);

        //获取所有元素的集合, 是一个Set类型
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            //方式1:直接打印entry
            //System.out.println(iterator.next());

            //方式2: 分别获取key 和value打印
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey()+"---->"+entry.getValue());
        }

    }
}
