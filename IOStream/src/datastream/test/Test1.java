package datastream.test;

import org.junit.Test;

import java.io.*;

/**
 * 将基本数据类型写入到指定文件中,并且读取出来
 *
 * @author initial
 * @create 2021-03-09 17:35
 */
public class Test1 {
    @Test
    public void test1() {
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try {
            //1. 创建字节输入流 和输出流
            dataOutputStream = new DataOutputStream(new FileOutputStream("C:\\Users\\Inital\\Desktop\\test.txt"));
            dataInputStream = new DataInputStream(new FileInputStream("C:\\Users\\Inital\\Desktop\\test.txt"));
            //2. 输入数据

            dataOutputStream.writeBoolean(false);  //写入布尔类型
            dataOutputStream.writeUTF("abdaga");  //写入字符串型
            dataOutputStream.writeInt(12315);  //写入整形


            //3. 读取数据
            //注意: 读取数据的顺序和类型, 必须按照写入的顺序和类型读. 类型不能错 否则报错
            boolean b = dataInputStream.readBoolean();
            System.out.println(b);
            String s = dataInputStream.readUTF();
            System.out.println(s);
            int i = dataInputStream.readInt();
            System.out.println(i);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dataOutputStream != null) {
                try {
                    dataOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
