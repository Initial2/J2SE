package lambda.test;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author initial
 * @create 2021-03-16 10:26
 */
public class LambdaTest2 {

    //使用判断型接口Predicate
    @Test
    public void test1(){
        //普通写法

        //定义一个判断规则,如果字符串包含杰字, 返回true
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return  s.contains("杰");
            }
        };
        System.out.println(predicate.test("张杰"));

        //使用lambda写法
        Predicate<String> predicate1 = str -> str.contains("杰");
        System.out.println(predicate1.test("周杰伦"));
    }





    //使用消费型接口Consumer
    @Test
    public void test(){
        //普通写法
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("获得金钱:"+integer);
            }
        };
        consumer.accept(500);

        //使用lambda写法
        Consumer<Integer> consumer1 = money ->  System.out.println("获得金钱:"+money);
        consumer1.accept(500);
    }


}
