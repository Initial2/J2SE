package streamapi.collect.test;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author initial
 * @create 2021-03-17 16:37
 */
public class CollectTest {
    @Test
    public void test(){
        //把stream中的元素, 改为用set存储
        Stream<Integer> integerStream = Stream.of(21, 25, 61, 6, 61);
        Set<Integer> collect = integerStream.collect(Collectors.toSet());
        collect.forEach(System.out::println);
    
    
    }
}
