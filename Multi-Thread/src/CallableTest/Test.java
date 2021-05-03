package CallableTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author initial
 * @create 2020-11-06 17:24
 */
public class Test {

  public static void main(String[] args) {

    /* 创建Callable接口实现类对象 callable. */
    CallableTest callable = new CallableTest();

    /* 接着创建 FutureTask类的对象, 并且把 callable作为参数,传递到它的构造方法当中 */
    FutureTask futureTask = new FutureTask(callable);

    /* 新建一个线程, 把FutureTask类的对象 作为参数传递到 Thread类构造方法当中.
     * FutureTask类,它内部实现了Runnable接口 ,所以他也是一个Runnable接口的实现类
     * 所以可以作为参数被添加到Thread()的构造方法当中  */
    new Thread(futureTask).start(); // start()以后, 线程才会开始运行

    /*
     如果想要call方法()运行后的返回值,就需要调用FutureTask里面的get方法.对象名.get();
     get方法会产生异常, 所以如果调用该方法,就必须用 try-catch给他包住.
     注意: get方法的返回值是Object类型. 如果有需要可以进行类型转换.
    */
    try {
      int sum = (int) futureTask.get();
      System.out.println("总和为:" + sum);
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
