package object.stream.test;

import org.junit.Test;

import java.io.*;

/**
 * @author initial
 * @create 2021-03-10 12:34
 */
public class ObjectInputOutPutStreamTest {
    @Test
    public void test1() {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            //1. 创建 ObjectInputStream和 ObjectOutputStream流对象
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.txt"));
            objectInputStream = new ObjectInputStream(new FileInputStream("object.txt"));


            //2. 创建String类对象
            String string = new String("这是一个对象");

            //3. 写入此对象
            objectOutputStream.writeObject(string);

            //4. 写入后再读取出来打印 因为我们知道读取的对象时String类型的, 所以可以进行强转
            String o = (String) objectInputStream.readObject();
            System.out.println(o);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //5. 最后关闭流
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
