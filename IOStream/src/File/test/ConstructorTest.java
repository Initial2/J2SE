package File.test;

import java.awt.*;
import java.io.File;

/**
 *
 * File类常用构造器测试
 * @author initial
 * @create 2021-03-07 16:42
 */
public class ConstructorTest {
    public static void main(String[] args) {

        //1. 使用文件路径创造对象 . 可以是绝对路径或者相对路径
        //绝对路径
        File file1 = new File("C:\\Users\\Inital\\Desktop\\test1.txt");
        System.out.println(file1);
        //相对路径
        File file2 = new File("test2.txt");
        System.out.println(file2);

        //2. 使用父路径和子路径
        //"C:\\Users\\Inital"为父路径
        //Desktop 是在它之后的 所以是子路径
        File file3 = new File("C:\\Users\\Inital","Desktop");
        System.out.println(file3);

        //3.使用父File对象+ 子路径的方法
        File file4 = new File(file3,"test3.txt");
        System.out.println(file4);
    }
}
