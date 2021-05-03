package ThreadPoolTest;

import java.util.concurrent.*;

/**
 * @author initial
 * @create 2020-11-07 19:50
 */
public class ThreadPoolTest2 {

      public static void main(String[] args) {

            /* 1. 首先创建线程池,指定线程池数量  */
            ExecutorService service = Executors.newFixedThreadPool(5);

            /*
                调整线程池的大小, 设置为5个.
                注意:
                    1. service其实就是ExecutorService的实现类对象,即ThreadPoolExecutor这个类的对象.
                    但是由于多态写法, ExecutorService service = Executors.newFixedThreadPool(5);
                    ExecutorService这个接口里面是没有可以调整线程池大小的方法.
                    所以我们没法调用setCorePoolSize()方法.
                    2. 但是我们确定ExecutorService它的实现类对就是ThreadPoolExecutor这个类.
                       例如使用 instance of 关键字对它进行判断 service instance of ThreadPoolExecutor
                       它的返回值就是true, 这就证明了我们是对的.
                       所以可以对它进行强转. 用它的实现类当中的这些方法.
             */
          ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
          service1.setCorePoolSize(5);




              /* 2. 调用submit()方法获取call()方法返回值.
             * submit()方法, 首先他需要一个Callable接口的实现类对象.
             * 它有返回值,返回值是Future类型. 我们可以创建一个Future类型的对象接受返回值.
             * 然后调用对象名.get()方法, 获取call()方法的返回值.
             * 注意: 因为Call方法里面,我们定义的它的泛型是一个Integer类型,
             * 所以task.get()方法, 它的返回值也是一个Integer类型. */
            Future<Integer> task = service.submit(new ThreadPool2());
            try {
                int num = task.get();
                System.out.println(num);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
      }
}
