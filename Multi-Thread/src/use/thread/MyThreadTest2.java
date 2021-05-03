package use.thread;

/**
 * @author initial
 * @create 2020-10-19 19:55
 */
public class MyThreadTest2 extends Thread {
    /**
     * 遍历100以内的奇数
     */
    @Override
    public void run() {
    System.out.println(Thread.currentThread());

        for (int i = 1; i <= 100; i++) {
          if (i % 2 != 0){
            System.out.println(i);
          }

    }
    }
}
