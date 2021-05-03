package use.thread2;

/**
 * @author initial
 * @create 2020-10-20 19:07
 */
public class MyThread2Test {
    public static void main(String[] args){

        MyThread2 myThread2 = new MyThread2();
        Thread thread1 = new Thread(myThread2);
        Thread thread2 = new Thread(myThread2);
        Thread thread3 = new Thread(myThread2);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
