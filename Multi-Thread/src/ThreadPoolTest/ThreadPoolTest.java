package ThreadPoolTest;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author initial
 * @create 2020-11-07 19:00
 */
public class ThreadPoolTest {
  public static void main(String[] args) {

      /*1.
        创建线程池, 使用Executors.newFixedThreadPool()方法,指定创建10个线程.
        注意: ExecutorService 他是一个接口, 所以service他是这个接口实现类的对象.
        接口不会有对象. 它的接口实现类是:ThreadPoolExecutor
       */
      ExecutorService service = Executors.newFixedThreadPool(10);

      /*
        execute()方法,作用就是执行线程. 该方法没有返回值, 所以适合用来执行Runnable接口的
        run()方法. 因为实现Runnable接口的多线程类,run()方法都是没有返回值的.
        我们需要给他指定去执行什么. 所以就把实现Runnable接口的多线程类的对象给他当做参数传递进去就可以了,
        告诉他去执行这个类的run()方法.
       */
      service.execute(new ThreadPool1());

  }
}
