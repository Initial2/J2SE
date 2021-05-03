package Iinetaddress.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author initial
 * @create 2021-03-10 15:50
 */
public class InetAddressTest {
    public static void main(String[] args) {
        //getHostName() 和getHostAddress()
        InetAddress byName1 = null;

        try {
            byName1 = InetAddress.getByName("www.baidu.com"); //指定域名
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(byName1.getHostAddress());
        System.out.println(byName1.getHostName());


        //使用getLocalHost()方法可以获取本地地址
       /* InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(localHost);
*/

        /*
            1. 使用静态方法getByName()
               该方法可以指定IP地址, 也可以给他指定一个域名.
               然后返回一个实例化对象,代表了你提供的域名/IP地址
         */
       /* InetAddress byName1 = null;
        InetAddress byName2 = null;
        try {
            byName1 = InetAddress.getByName("39.156.66.14");  //指定IP地址
            byName2 = InetAddress.getByName("www.baidu.com"); //指定域名
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        System.out.println(byName1);
        System.out.println(byName2);
        */
    }
}
