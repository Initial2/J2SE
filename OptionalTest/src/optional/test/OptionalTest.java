package optional.test;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author initial
 * @create 2021-03-17 17:07
 */
public class OptionalTest {
    @Test
    public void test(){
    
        String str1 = null;
        Optional<String> s = Optional.ofNullable(str1);
        
        //如果 s不是空的, 就把s的值返回.
        //如果 s是空的, 就执行括号里的备胎语句.  把备胎返回
        String str2 = s.orElse("这是备用字符串");
        System.out.println(str2);
        
    
    
        //Optional.of()  可以创建任意类型的对象, 但是这个对象不能为空.
        Optional<Integer> integer = Optional.of(123);
        //判断integer中有没有元素,如果有就给他打印
        integer.ifPresent(System.out::println);
        
    
    
        //创建一个Optional对象, 里面啥也没有是空的
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
    }
}
