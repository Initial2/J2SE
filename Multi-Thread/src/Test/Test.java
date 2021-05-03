package Test;

/**
 * @author initial
 * @create 2020-11-06 16:37
 */
public class Test {

    public static void main(String[] args){

        /* 首先创建Clerk类对象 clerk*/
        Clerk clerk = new Clerk();

        /*把clerk对象作为参数, 分别创建两个线程 p1,c1
        * 因为这两个线程都需要用clerk里面的东西.*/
        Productor p1 = new Productor(clerk);
        Consumer c1 = new Consumer(clerk);

        p1.setName("生产者");
        c1.setName("消费者");

        p1.start();
        c1.start();

    }




}
