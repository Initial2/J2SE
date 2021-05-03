package classloader.test;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author initial
 * @create 2021-03-13 19:53
 */
public class ClassLoaderTest2 {

    @Test
    public void test1() {
        FileInputStream fileInputStream = null;
        String account;
        String password;

        //方式1: 使用FileInputStream的方式 读取Properties配置文件
        try {
            Properties properties = new Properties();
            //创建输入流
            fileInputStream = new FileInputStream("src//JDBC.properties");
            //加载输入流
            properties.load(fileInputStream);
            //读取账户
            account = properties.getProperty("account");
            //读取密码
            password = properties.getProperty("password");
            System.out.println("用户名为: " + account);
            System.out.println("密码为: " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    @Test
    public void test2(){
        String account;
        String password;
        InputStream resourceAsStream = null;
        try {
            // 使用ClassLoader实现对配置文件的加载
            //1. 首先获取当前自定义类的加载器
            ClassLoader classLoader = ClassLoaderTest2.class.getClassLoader();

            //2.使用getResourceAsStream(),加载配置文件
            //该方法类似于FileInputStream. 可以加载Properties文件然后以流的方式输入
            // 该方法默认识别路径为当前module的src目录下
            resourceAsStream = classLoader.getResourceAsStream("JDBC.properties");

            //3. 用Properties来加载当前输入流
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            //4. 获取信息
            //读取账户
            account = properties.getProperty("account");
            //读取密码
            password = properties.getProperty("password");
            System.out.println("用户名为: " + account);
            System.out.println("密码为: " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5, 关闭资源
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
