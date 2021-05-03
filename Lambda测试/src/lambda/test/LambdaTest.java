package lambda.test;

import org.junit.jupiter.api.Test;

import java.util.Comparator;


/**
 * @author initial
 * @create 2021-03-15 18:05
 */
public class LambdaTest {

    @Test
    public void test1(){
        //以 Runnable接口为例
        // 默认写法
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个默认的写法");
            }
        };
        runnable1.run();

        //使用lambda写法
        Runnable runnable2 = () -> System.out.println("这是一个lambda表达式");
        runnable2.run();
    }

    @Test
    public void test2(){
        //以comparator接口为例

        //默认写法
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator1.compare(19, 20));

        //使用lambda写法
        Comparator<Integer> comparator2 = Integer::compareTo;
        System.out.println(comparator2.compare(20, 21));
    }
}
