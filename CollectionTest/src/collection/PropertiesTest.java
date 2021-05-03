package collection;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author initial
 * @create 2021-03-05 16:12
 */
public class PropertiesTest {



    public static void main(String[] args) {
        //使用IO流读取改文件
        Properties properties = new Properties();

        try {
            //创建一个输入流,读取配置文件
            FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
            //把输入流给他
            properties.load(fileInputStream);
            //读取属性
            String name = properties.getProperty("name");
            String age = properties.getProperty("age");
            String sex = properties.getProperty("sex");
            System.out.println(name + age + sex);
        } catch (Exception e){
        }

    }
}
