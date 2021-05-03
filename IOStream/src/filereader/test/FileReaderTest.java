package filereader.test;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author initial
 * @create 2021-03-08 14:05
 */
public class FileReaderTest {
    @Test
    public void test2() {
        FileReader fileReader = null;
        try {
            //1. 创建File类对象加载文件
            File file = new File("C:\\Users\\Inital\\J2SE进阶\\IOStream\\src\\1.txt");

            //2. 创建FileReader对象, 把file作为参数传递进去
            fileReader = new FileReader(file);

            //3.读取数据, 使用read(char[] cbuf)方法一次读取多个字符
            //数组的长度决定一次读入的个数, 可以自己指定. 这里指定长度为5
            char[] cbuf = new char[5];
            //该方法返回每次数组里面读入元素的个数,如果返回-1,则代表文件读完了
            int read = fileReader.read(cbuf);

            while (read != -1) {
              /* 打印读取数据方式1: 使用for循环遍历char数组
               for (int i = 0; i< read; i++){
                   System.out.print(cbuf[i]);
               }
                read = fileReader.read(cbuf);*/

                //方式2: 使用String带参构造器. 指定读取区间为[0,read). 读入几个元素,我就拿出来几个元素
                // 避免读取重复元素
                String s = new String(cbuf, 0, read);
                System.out.print(s);
                read = fileReader.read(cbuf);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4. 最后关闭流
            //首先进行判断 如果是空的,也就是fileReader就没创建成功,那么就不用关闭了.
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            //1. 创建File类对象加载文件
            File file = new File("C:\\Users\\Inital\\J2SE进阶\\IOStream\\src\\1.txt");

            //2. 创建FileReader对象, 把file作为参数传递进去
            fileReader = new FileReader(file);

            /*
                3. 读取数据, read()方法读取的是字符对应的ASCII码值,所以是整数
                   当该方法读取结束之后, 返回-1.
             */
            int read = fileReader.read();
            while (read != -1) {
                System.out.print((char) read);
                read = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4. 最后关闭流
            //首先进行判断 如果是空的,也就是fileReader就没创建成功,那么就不用关闭了.
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
