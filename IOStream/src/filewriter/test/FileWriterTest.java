package filewriter.test;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author initial
 * @create 2021-03-08 15:20
 */
public class FileWriterTest {
    @Test
    public void test1(){
        FileWriter fileWriter = null;
        try {
            //1. 创建File类对象,指明要写入的文件路径和名字
            //注意: 文件可以不存在,如果不存在就自动帮我们创建一个.
            File file = new File("C:\\Users\\Inital\\J2SE进阶\\IOStream\\src\\2.txt");

            //2. 创建FileWriter对象
            fileWriter = new FileWriter(file);

            //3. 直接向里面写入内容, 如果使用默认构造器, 当文件已经存在时,会进行覆盖重写.
            //   如果使用FileWriter(file,true). 则当文件存在时,自动写到文件内容后面. 不覆盖重写
            fileWriter.write("天龙八部");
            fileWriter.write("射雕英雄传");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭写入流
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
