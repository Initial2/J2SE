package streamapi.map.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author initial
 * @create 2021-03-17 14:27
 */
public class MapTest1 {
    
    public static Stream<char[]> getCharArray(String str){
        return Stream.of(str.toCharArray());
    }
    
    @Test
    public void test1(){
        //这是一个String类型的Stream流
        Stream<String> helloWorld = Stream.of("hello","world");
       
        /*
        我们调用MapTest1::getCharArray方法. 把这个Stream流中的元素,全部变成字符数组
        然后再返回一个字符数组流.
        此时, helloWorld.flatMap(MapTest1::getCharArray);
        这个方法的返回值也是一个Stream流.
        并且编译器已经帮我们识别了这个字符数组的stream流 ,  Stream<char[]>
        它并没有把这个返回值看成一个整体当做之前的String对待, 而是把里面的元素全部拿出来单独对待.
         */
        Stream<char[]> stream = helloWorld.flatMap(MapTest1::getCharArray);
        stream.forEach(System.out::println);
        
    }
    
  
    
    
    
    @Test
    public void test(){
        
        
        //这是一个数组
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        //这是另一个数组
        List list1 = new ArrayList<>();
        list1.add(4);
        list1.add(5);
        list1.add(6);
        
        //在一个list数组里面,添加一个新的list1数组.
        // 他并不会把list1这个数组当成是一个元素, 类似于[1,2,3,[4,5,6]] 这是4个元素
        //而是 把list1中的每个元素都拿出来,放到list这个数组当中 ,类似于 [1,2,3,4,5,6] 这是6个元素
        list.addAll(list1);
    
        for (Object o : list) {
            System.out.println(o);
        }
        
        
        //使用map()方法, 将stream中所有元素,都扩大为原来的平方
        //使用Math.pow()方法
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        integerStream.map(num1 -> Math.pow(num1,2)).forEach(System.out::println);
    
    
        
        //使用map()方法, 将小写字母全部映射为大写字母
        Stream.of("a","b","c","d").map(String::toUpperCase).forEach(System.out::println);
        
        //这里的map(),就相当于提供了一个函数, 函数里面的参数Function c 相当于让我们指明函数想实现什么操作
        //当我们指定好以后, map()会自动遍历stream中的所有元素, 然后按照我们给定的规则,去把stream中的
        // 元素映射为新的元素
       
        
    }
}
