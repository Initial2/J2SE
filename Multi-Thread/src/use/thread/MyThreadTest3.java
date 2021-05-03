package use.thread;

/**
 * @author initial
 * @create 2020-10-19 19:57
 */
public class MyThreadTest3  extends Thread{
    /**
     *
     * 遍历所有偶数
     */
    @Override
    public void run() {
    for (int i = 1; i <= 100; i++) {
      if (i % 2 == 0){
        System.out.println(i);
      }
    }
    }
}
