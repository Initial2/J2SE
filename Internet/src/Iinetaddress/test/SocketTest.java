package Iinetaddress.test;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author initial
 * @create 2021-03-10 17:24
 */
public class SocketTest {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1. 指明你要连接的服务器IP地址和端口号 这里以本地IP作为服务器地址
            socket = new Socket(InetAddress.getLocalHost(), 8099);
            //2. 创建输出流.
            outputStream = socket.getOutputStream();

            //3. 用输出流向服务端发送数据,因为只能发送字节流和整数
            //所以发送字符串需要先使用getBytes()方法把它转换成字节
            outputStream.write("这里是客户端发送的数据".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 发送完以后关闭资源
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    //服务端
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream bos = null;
        try {
            // 1. 注意: 使用 ServerSocket来创建服务端对象.
            serverSocket = new ServerSocket(8099);

            //2. 然后创建Socket对象 来接收客户端发出的信息.
            socket = serverSocket.accept();

            //3. 创建输入流开始读取内容
            inputStream = socket.getInputStream();
            //这里使ByteArrayOutputStream来避免,读取过程中因为容量太小,导致
            //中文被分割读取的乱码现象
            bos = new ByteArrayOutputStream();
            int read;
            while ((read = inputStream.read()) != -1) {
                //把读取出来的数据写入bos中
                bos.write(read);
            }

            //4. 直接打印即可
            System.out.println(bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
