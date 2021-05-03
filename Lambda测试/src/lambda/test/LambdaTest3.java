package lambda.test;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author initial
 * @create 2021-03-16 11:53
 */
public class LambdaTest3 {

    //③:   类名 :: 非静态方法
    public  void test2(){
        //lambda写法
        Comparator<String> comparator = (s1,s2) -> s1.compareTo(s2);
        comparator.compare("a","b");

        //方法引用
        Comparator<String> comparator1 = String :: compareTo;
        comparator1.compare("c","d");


    }


    //②: 类名  :: 静态方法
    public void test1(){
        //lambda写法
        Comparator<Integer> comparator = (num1,num2) -> Integer.compare(num1,num2);
        comparator.compare(19,20);
        //方法引用
        Comparator<Integer> comparator1 = Integer :: compare;
        comparator1.compare(22,20);
    }

    
    //用法① : 对象名 :: 非静态方法
    @Test
    public void test(){
        //这是lambda写法
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("lambda写法");

        //使用方法引用的写法
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("这是方法引用的写法");
    }
}
