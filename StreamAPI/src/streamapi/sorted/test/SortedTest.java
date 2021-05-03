package streamapi.sorted.test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author initial
 * @create 2021-03-17 15:38
 */
public class SortedTest {
    
    @Test
    public void test(){
        
        //定制排序
        //1. 首先创建一个对象数组
        Person[] people = new Person[]{new Person("张三", 55, 5500), new Person("李四", 20, 5400), new Person("王五", 55, 3000)};
        //2. 把数组转化为Stream流
        Stream<Person> stream = Arrays.stream(people);
        
        //3. 给定排序规则
        /*
            按照年龄排序,如果年龄相同,则按照薪资排序
         */
        stream.sorted((num1,num2) -> {
            if (num1.age == num2.age){
                return Integer.compare(num1.salary,num2.salary);
            }
             return Integer.compare(num1.age, num2.age);
        }).forEach(System.out::println);
    
    
        
        
        Stream<Integer> integerStream = Stream.of(521, 52, 216, 632, -125, 0, 16);
        //使用sorted()自然排序 从小到大
        integerStream.sorted().forEach(System.out::println);
    
    }
    
    private class Person {
        String name;
        int age;
        int salary;
        public Person(String name, int i, int i1) {
            this.name = name;
            this.age = i;
            this.salary = i1;
        }
    
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }
    }
}
