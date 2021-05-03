package lambda.test;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author initial
 * @create 2021-03-16 16:07
 */
public class LambdaTest4 {

    //数组引用
    @Test
    public void test2(){

        //lambda写法
        Function<Integer, String[]> function = length -> new String[length];
        String[] apply = function.apply(10);

        //数组引用写法
        Function<Integer, String[]> function1 = String[] :: new;
        String[] apply1 = function1.apply(9);

    }





    //带参引用
    @Test
    public void test1(){
        //lambda写法
        Function<String,Person> supplier1 = s -> new Person(s);
        supplier1.apply("小明");

        //引用带参构造写法
        Function<String,Person> supplier2 = Person :: new;
        supplier2.apply("李四");
    }





    @Test
    public void test(){

        //lambda写法
        Supplier<Person> supplier = () -> new Person();
        supplier.get();

        //构造器引用写法
        Supplier<Person> supplier1 = Person :: new;
        supplier1.get();

    }
}
