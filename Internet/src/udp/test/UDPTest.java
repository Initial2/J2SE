package udp.test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * 使用UDP 协议.  发送端向接收端发送一串数据.
 * 接收端获取数据并且打印到控制台.
 *
 * @author initial
 * @create 2021-03-11 13:24
 */
public class UDPTest {

    //发送端
    @Test
    public void sender() {
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            //1. 首先创建UDP协议的对象,此时不用指定接收端的IP地址和端口号
            datagramSocket = new DatagramSocket();

            //2. 创建要发送的数据,放到字节数组当中
            String str = " 这是发送端发来的数据";
            byte[] data = str.getBytes(StandardCharsets.UTF_8);

            //3.  用DatagramPacket创建数据包, 把要发送的数据放进去.
            //并且指明发送的长度 要接受者的IP地址和端口号
            datagramPacket = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 8899);

            //4. 发送数据
            datagramSocket.send(datagramPacket);

            //5. 关闭资源
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }

        }


    }

    //接收端
    @Test
    public void receiver() {
        DatagramSocket datagramSocket = null;
        try {
            //1. 创建接收端, 此时要指明接受的数据来源端口号
            datagramSocket = new DatagramSocket(8899);

            //2. 创建byte[]数组接收数据
            byte[] bytes = new byte[100];

            //3. 创建DatagramPacket来指定接收的长度和用什么接收
            DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);


            //4. 打印接收到的数据
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 关闭资源
            if (datagramSocket != null) {
                datagramSocket.close();

            }
        }


    }
}
