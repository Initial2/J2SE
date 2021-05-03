package buffer.test;

import org.junit.Test;

import java.io.*;

/**
 * BufferedReader 和 BufferedWriter的测试
 * 实现文本文件的复制操作
 *
 * @author initial
 * @create 2021-03-09 13:39
 */
public class BufferedTest {
    @Test
    public void test1() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {

            //1. 首先创建文件对象
            File srcFile = new File("C:\\Users\\Inital\\Desktop\\魔兽.txt");
            File destFile = new File("C:\\Users\\Inital\\Desktop\\复制品.txt");

            //2. 创建节点流  因为BufferedReader 和 BufferedWriter不能够直接使用,
            //它俩是处理流 , 所以需要先有节点流
            FileReader fileReader = new FileReader(srcFile);
            FileWriter fileWriter = new FileWriter(destFile);

            //3. 创建处理流
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);

            //4. 处理操作
           /* 方式1: 按照之前的方法. 一次读取指定长度,然后写到目标文件
            char[] array = new char[10];
            int read = bufferedReader.read(array);
            while (read != -1){
                bufferedWriter.write(array);
                read = bufferedReader.read();
            }*/

            //方式2: 使用readLine()方法 一次读取一行
            String data = bufferedReader.readLine();  //该方法当读取结束时,返回null
            while (data != null) {
                //注意此方法,读取后的文本是没有换行符的,所以我们可以手动添加换行符
                bufferedWriter.write(data + "\n");
                data = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
             /*
               5. 关闭流
                 注意:  只用关闭外层的bufferedReader和bufferedWriter即可.
                       当这两个关闭以后,处于内层的fileReader和fileWriter也就会自动关闭了
             */
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
