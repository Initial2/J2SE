package streamapi.test;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * @author initial
 * @create 2021-03-16 20:29
 */
public class StreamAPITest2 {

    @Test
    public void test3(){
        //skip()
        Stream<Integer> integerStream = Stream.of(20, 20, 40, 20, 60, 70, 80, 55);
        //跳过前三个元素,只打印后面的
        integerStream.skip(3).forEach(System.out::println);
    }

    @Test
    public void test2(){
        //使用limit()
        Stream<Integer> integerStream = Stream.of(20, 20, 40, 20, 60, 70, 80, 55);
        //设置只打印数组流中前5个元素
        integerStream.limit(5).forEach(System.out::println);


    }
    @Test
    public void test1(){
        //使用distinct() 去重
        //去除数组中的重复元素
        //该方法通过hashCode() 和equals()方法判断重复,和Set类似
        //所以里面元素的所在类,必须重写了hashCode()和equals()方法才行.
        Stream<Integer> integerStream = Stream.of(20, 20, 40, 20, 60, 70, 80, 55);
        integerStream.distinct().forEach(System.out::println);


    }





    @Test
    public void test(){

        //1. 过滤操作filter()
        //用filter()方法,过滤数组中大于50的元素
        Stream<Integer> integerStream = Stream.of(20, 30, 40, 50, 60, 70, 80, 55);
        integerStream.filter(num -> num > 50 ).forEach(System.out::println);

        //用filter()方法,过滤字符串中包含"a"的字符
        Stream<String> abcd = Stream.of("abcd", "bb", "cad", "hello");
        abcd.filter( str -> str.contains("a")).forEach(System.out::println);

    }
}
