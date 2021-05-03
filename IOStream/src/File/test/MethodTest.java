package File.test;

import org.junit.Test;

import java.io.File;

/**
 * @author initial
 * @create 2021-03-07 17:05
 */
public class MethodTest {
    @Test
    public void test1(){
        File file = new File("C:\\Users\\Inital\\Desktop\\DataBase");
        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test2(){
        File file = new File("C:\\Users\\Inital\\Desktop\\DataBase");
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
            //返回的是一个个的文件对象所以可以调用File类方法
            System.out.println(file1.lastModified());

        }
    }

    @Test
    public void test3(){
        //把 C:\Users\Inital\Desktop\ 目录下的 1.txt修改为 D:\Program Files 目录下的 2.txt文件
        //注意: 如果想修改成功, 必须满足:  1. file1下的文件必须真实存在
        //                            2.  file2下的文件必须不存在

        File file1 = new File("C:\\Users\\Inital\\Desktop\\1.txt");  //必须真实存在
        File file2 = new File("D:\\Program Files\\2.txt");  //必须不存在

        boolean b = file1.renameTo(file2);
        System.out.println(b);


    }
}
