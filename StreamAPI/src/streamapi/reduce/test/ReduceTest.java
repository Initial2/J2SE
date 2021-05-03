package streamapi.reduce.test;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author initial
 * @create 2021-03-17 16:20
 */
public class ReduceTest {
    @Test
    public void test(){
        //1. 创建整数数组
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> reduce1 = integerStream1.reduce(Integer::sum);
        System.out.println(reduce1);
    
    
        //1. 创建整数数组
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        //2. 通过reduce((T identity, BinaryOperator<T> accumulator)方法
        //  计算所有元素的总和
        // 其中 0为归约的初始值, Integer::sum就是具体归约的方法
        Integer reduce = integerStream.reduce(0, Integer::sum);
        System.out.println(reduce);
    
    }
}
