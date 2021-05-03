package ThreadPoolTest;

import java.util.concurrent.Callable;

/**
 * @author initial
 * @create 2020-11-07 19:46
 */
public class ThreadPool2  implements Callable<Integer> {
    /*
      遍历100以内所有奇数,并且返回总和
       */
      @Override
      public Integer call() throws Exception {
          int sum = 0;
            for (int i = 0; i <= 100; i++) {
                if (i % 2 != 0) {
                    System.out.println(i);
                    sum += i;
                }
            }
          return sum;
      }
}
