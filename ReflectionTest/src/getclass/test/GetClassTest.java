package getclass.test;

import org.junit.jupiter.api.Test;

/**
 *
 * 获取运行时类实例的4种方式
 * @author initial
 * @create 2021-03-11 17:14
 */
public class GetClassTest {

    @Test
    public void test1() throws ClassNotFoundException {
        //方式一: 使用类名.class
        Class<Person> clazz1 = Person.class;

        //方式二: 使用class.forName(String path);    指明类的路径
        Class<?> clazz2 = Class.forName("getclass.test.Person");


        //方式三: 使用对象.getClass();
        Person p1 = new Person();
        Class clazz3 = p1.getClass();


        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz2 == clazz3);

        //方式四: 使用Class.Loader (仅作为了解)
        ClassLoader classLoader = GetClassTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("getclass.test.Person");


    }
}
