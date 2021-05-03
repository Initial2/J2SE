package getfields.test;

import getclass.test.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

/**
 *
 * 获取运行时类的属性
 * @author initial
 * @create 2021-03-14 10:45
 */
public class GetFieldsTest {
    @Test
    public void test(){
        //getFields()方法,可以获取运行时类和其所有父类的声明为public的属性
        Class<Person> clazz = Person.class;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

    }

    @Test
    public  void  test2(){
        //使用getDeclaredFields()方法,可以获取所有运行时类声明的属性
        Class<Person> personClass = Person.class;

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {

            //使用getModifiers()可以获取运行时类的属性的权限
            //注意: 获取到的权限是整型的代号. 我们可以通过 Modifier.toString(int mode)方法
            //把获取到的代号输入进去,他可以自动给我们转换为权限修饰符
            int modifiers = declaredField.getModifiers();
            Modifier.toString(modifiers);

            //获取运行时类的属性的类型 使用getType()方法
            Class<?> type = declaredField.getType();
            System.out.println(type);

            String name = declaredField.getName();
            System.out.println(name);


        }
    }

    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        //先获取带泛型的父类
        Type genericSuperclass = personClass.getGenericSuperclass();

        //获取泛型的类型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //由于类型可能不止一个, 例HashMap<K,V> 所以用数组存储.
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);
    }
    @Test
    public void test4(){

        Class<Person> personClass = Person.class;
        personClass.getInterfaces();
    }

}
