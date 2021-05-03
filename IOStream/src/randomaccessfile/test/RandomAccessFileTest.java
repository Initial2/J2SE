package randomaccessfile.test;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author initial
 * @create 2021-03-10 13:50
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile randomAccessFile1 = null;
        RandomAccessFile randomAccessFile2 = null;
        try {
            //1. 创建RandomAccessFile类对象.  可以直接指定 路径+文件名 或者传一个File类对象
            //指定 randomAccessFile1 的mode为rw 读写类型   指定 randomAccessFile2 的mode为r 只读类型
            randomAccessFile1 = new RandomAccessFile("test.txt", "rw");
            randomAccessFile2 = new RandomAccessFile("test.txt", "r");


            //2. 向文件中写入数据
            randomAccessFile1.writeUTF("这是一个字符串");
            randomAccessFile1.writeInt(1512);

            //3. 再把写入的数据读取出来
            //注意: 读取顺序也必须按照添加的顺序来.  并且元素类型不能错
            String s = randomAccessFile2.readUTF();
            System.out.println(s);
            int i = randomAccessFile2.readInt();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 最后关闭流
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile2 != null) {
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
