package Iinetaddress.test;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 客户端向服务端发送图片. 服务端接收后,存到桌面
 *
 * @author initial
 * @create 2021-03-11 11:37
 */
public class SocketTest2 {

    //服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream inputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        OutputStream outputStream = null;
        try {
            //1. 首先创建serverSocket对象
            serverSocket = new ServerSocket(8899);
            //2. 接收客户端发送的数据
            accept = serverSocket.accept();

            //3. 创建输入流, 把接受的图片读取出来
            inputStream = accept.getInputStream();

            //4. 创建输出流, 指明接受到的文件存在哪.
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("图片1.png"));


            //4. 开始处理
            int len;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }

            //5. 处理完之后 给客户端发消息. 提醒已经接收完成
            outputStream = accept.getOutputStream();
            outputStream.write("已经接收完成".getBytes(StandardCharsets.UTF_8));



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
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
            if (accept != null) {
                try {
                    accept.close();
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
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        InputStream inputStream = null;
        try {
            //1. 创建socket对象, 建立和服务端的连接
            socket = new Socket(InetAddress.getLocalHost(), 8899);

            //2. 创建输出流,准备发送图片
            os = socket.getOutputStream();
            //3. 创建输入流, 读取要发送的图片
            bis = new BufferedInputStream(new FileInputStream("Capture001.png"));

            //4. 发送图片
            int len;
            byte[] bytes = new byte[1024];
            while ((len = bis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }

            //5. 发送完之后告诉服务端已经发送完了
            // 使用socket.shutdownOutput() 关闭输出流
            socket.shutdownOutput();


            //6. 然后接受服务端发回的确认消息,并且输出到控制台
            inputStream = socket.getInputStream();
            int leng;
            byte[] bytes1 = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream();
            while((len = inputStream.read(bytes1))!= -1){
                byteArrayOutputStream.write(bytes1);
            }
            System.out.println(byteArrayOutputStream.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os != null) {
                try {
                    os.close();
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
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
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

        }


    }
}
