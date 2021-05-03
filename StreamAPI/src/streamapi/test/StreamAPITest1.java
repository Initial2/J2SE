package streamapi.test;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author initial
 * @create 2021-03-16 17:15
 */
public class StreamAPITest1 {

    @Test
    public void test4(){
        //使用Stream.generate()方法
        /*
         首先该方法需要一个Supplier函数式接口的实例, 所以我们可以通过方法引用,
         调用Math.random()来实现获取随机数.
         然后.limit(10)限制次数
         .forEach()终止操作
         */
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

    @Test
    public void test3(){
        //使用无限流
        /*
        首先我们指明, lambda方法i -> i+2, 就是打印偶数
        然后.limit(10), 其实就是一个数据操作的方法,我们限制只输出前10个
        因为如果不做限制,那么他会无限制的算下去.
        然后又因为Stream是延迟操作的,所以我们必须先使用.forEach()方法, 调用终止操作
        以后,他才会开始数据处理.
        forEach()方法就是终止操作, 该方法需要指明一个Consumer接口的实例.
        所以我们可以通过方法引用. 打印偶数
         */
        Stream.iterate(0, i -> i+2).limit(10).forEach(System.out :: println);


    }





    @Test
    public void test2(){
        //使用Stream.of()方法
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<String> a = Stream.of("a", "b", "c");

    }



    @Test
    public void test1(){
        //使用 Arrays.stream()方法
        IntStream stream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
    }



    @Test
    public void test(){
        //实例化方式1: 使用Collection接口中的 stream() 和parallelStream()方法
        //使用stream方法
        Collection<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //使用parallelStream()方法
        List<Integer> list2 = new ArrayList<>();
        Stream<Integer> integerStream = list2.parallelStream();

    }
}
