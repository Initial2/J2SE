package ThreadPoolTest;

/**
 * @author initial
 * @create 2020-11-07 19:00
 */
public class ThreadPool1 implements Runnable {
    /* 遍历100以内所有偶数 */
    @Override
    public void run() {
    for (int i = 1; i <= 100; i++) {
      if (i % 2 == 0){
        System.out.println(i);
      }
    }
    }
}
