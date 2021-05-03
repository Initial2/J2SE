package getinstance;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

/**
 * @author initial
 * @create 2021-03-13 20:46
 */
public class GetInstanceTest2 {

    @Test
    public void test1(){
        // 反射的动态性体现


        //首先获取随机数,根据数字创建不同的对象
        Random random = new Random();
        int i = random.nextInt(3);
        String classPath = null;

        switch (i){
            case 0 :
                classPath = "java.lang.Object" ;
                break;
            case 1:
                classPath = "java.util.ArrayList";
                break;
            case 2:
                classPath = "java.util.Date";

        }

        Object obj = creatNewInstance(classPath);
        System.out.println(obj);
    }

    //该方法,只需给它提供一个类的路径, 就可以创建该类的对象,
    public Object creatNewInstance(String classPath){
        Object o = null;
        try {
            Class clazz = Class.forName(classPath);
            o = clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return o;
    }
}
