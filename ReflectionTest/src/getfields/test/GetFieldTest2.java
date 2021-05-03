package getfields.test;

import getclass.test.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author initial
 * @create 2021-03-14 13:34
 */
public class GetFieldTest2 {
    @Test
    public void test() {

        //1. 首先创建Class类的实例
        Class<Person> personClass = Person.class;

        try {
            //2. 创建运行时类的对象
            Person person = personClass.getDeclaredConstructor().newInstance();

            //3. 通过get()方法, 获取指定名字的属性
            //注意: 不是用运行时类的对象调用该方法. 使用Class的实例调用
            Field name = personClass.getDeclaredField("name");

            //4. 设置访问权限, 因为如果属性不是public的, 默认是不允许访问的
            //我们可以通过setAccessible()方法. 指定权限
            name.setAccessible(true);

            //5. 通过set()方法,即可给该属性赋值
            //set()方法: 参数1: 指明改那个对象的name属性,  参数2:指明要把属性改成啥
            name.set(person, "张三");

            //6. 通过get()方法 可以获取对应的属性值
            //get()方法 参数1:  指明获取哪个对象的name值
            Object o = name.get(person);
            System.out.println(o);


        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
