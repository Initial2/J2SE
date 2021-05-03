package use.thread;

/**
 * @author initial
 * @create 2020-10-18 17:11
 */
public class MyThreadTest {

  public static void main(String[] args) {

      // 新建子类对象
      MyThread myThread = new MyThread();
      //调用start()方法
      myThread.start();

      // 遍历100内所有奇数
      for (int i = 1; i <=100; i++) {
          if ( i % 2 != 0){
              System.out.println(i);
          }

      }
  }




}
