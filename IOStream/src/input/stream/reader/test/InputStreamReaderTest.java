package input.stream.reader.test;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author initial
 * @create 2021-03-09 14:52
 */
public class InputStreamReaderTest {
    @Test
    public void test1() {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            //1. 创建字节输入流对象 字节输出流对象
            FileInputStream inputStream = new FileInputStream("C:\\Users\\Inital\\Desktop\\魔兽.txt");
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Inital\\Desktop\\魔兽(修改后).txt");

            //2. 创建InputStreamReader 和  OutputStreamWriter对象,把需要转换的流添加进去

            /* InputStreamReader(inputStream) 如果不指定解码格式,则默认用utf-8.
                为了避免乱码,我们只需要保证解码格式和文本保存的格式一致即可
             */
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

            //转换编码输出, 源文件用的utf-8, 这里改为用gbk的方式存储
            outputStreamWriter = new OutputStreamWriter(outputStream, "gbk");

            //3. 开始操作
            char[] array = new char[10];
            int read = inputStreamReader.read(array);
            while (read != -1) {
                String s = new String(array, 0, read);
                outputStreamWriter.write(s);
                read = inputStreamReader.read(array);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4. 最后关闭流
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
