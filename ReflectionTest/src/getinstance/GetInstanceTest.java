package getinstance;

import getclass.test.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author initial
 * @create 2021-03-13 20:24
 */
public class GetInstanceTest {

    @Test
    public void test1(){
        //通过反射创建运行时类的对象
        //1. 首先获取Class实例
        Class<Person> personClass = Person.class;
        try {
            //2. 通过Class类的实例. 调用getDeclaredConstructor().newInstance();方法
            //来创建运行时类的对象
            Person person = personClass.getDeclaredConstructor().newInstance();
            System.out.println(person);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
    }
