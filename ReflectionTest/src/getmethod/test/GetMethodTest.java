package getmethod.test;

import getclass.test.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author initial
 * @create 2021-03-14 13:57
 */
public class GetMethodTest {

    @Test
    public void test(){
        //1. 创建Class实例
        Class<Person> personClass = Person.class;
      

        try {
            //2. 创建运行时类对象
            Person person = personClass.getDeclaredConstructor().newInstance();

            //3. 使用getDeclaredMethod()方法获取指定的方法
            // 参数1: 指明要获取的方法名  参数2: 指明该方法的形参类型
            Method showName = personClass.getDeclaredMethod("showName", String.class);

            //4. 设置权限
            showName.setAccessible(true);

            //5. 获取之后,即可调用
            //invoke()方法:  参数1: 指明用哪个对象调用此方法.  参数2: 指明方法参数是什么
            //invoke()方法的返回值,即为调用的方法的返回值.
            Object returnValue = showName.invoke(person, "张三");
            System.out.println(returnValue);

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
