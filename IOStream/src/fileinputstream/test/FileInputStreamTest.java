package fileinputstream.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * 用FileInputStream和FileOutputStream 实现对文件的复制
 * @author initial
 * @create 2021-03-08 19:44
 */
public class FileInputStreamTest {

    @Test
    public void copyFile(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1. 创建File对象 file1为目标文件  file2为复制后的文件
            File file1 = new File("C:\\Users\\Inital\\Desktop\\b3ea5dcf1e679a6.jpg");
            File file2 = new File("C:\\Users\\Inital\\Desktop\\考试安排.jpg");

            //2. 创建FileInputStream 和 FileOutputStream对象
            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);

            //3. 开始复制
            byte[] array = new byte[1024];  //一次读取1024个字节的数据
            int readLength = fileInputStream.read(array); //返回每次读取字节的个数
            while(readLength != -1){
                fileOutputStream.write(array);
                readLength =  fileInputStream.read(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 最后关闭输入输出流
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
