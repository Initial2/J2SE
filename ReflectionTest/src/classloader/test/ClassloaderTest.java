package classloader.test;

import org.junit.jupiter.api.Test;

/**
 * @author initial
 * @create 2021-03-13 19:36
 */
public class ClassloaderTest {

    @Test
    public void test1(){
        // 类的加载器Classloader的测试

        //1. 系统类加载器,可以通过我们自定义类获取
        //1. 使用 当前类.class 获取Class对象. 然后调用Class对象的getClassLoader()方法,
        //即可获取系统类加载器
        ClassLoader classLoader = ClassloaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //2. 调用系统类加载器的getParent()方法,可以获取它上一级的加载器
        //也就是Extension Classloader 拓展类加载器
        ClassLoader parentClassLoader = classLoader.getParent();
        System.out.println(parentClassLoader);


        //3. 但是,我们不能通过拓展类的getParent()方法,获取它上一级的加载器
        //也就是 引导类加载器
        // 因为引导类加载器我们无法获取
        ClassLoader parent = parentClassLoader.getParent();
        System.out.println(parent);


    }
}
