package object.stream.test;

import java.io.Serializable;

/**
 * 可序列化的自定义类
 * @author initial
 * @create 2021-03-10 13:09
 */
public class Person  implements Serializable {
        //提供一个全局常量, 数值可以自己定义. 但是必须要有
        private  static final  long serialVersionUID = 12581958151521L;
        private String name;
        private int age;
        private static String sex ;  //虽然他是基本数据类型. 但是不可被序列化
        private transient double account ;////虽然他也是基本数据类型. 但是不可被序列化
        private Job job;  //如果Job类没有满足可序列化要求, 那么也无法序列化

}
class Job{

}
