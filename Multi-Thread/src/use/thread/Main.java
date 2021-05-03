package use.thread;

/**
 * @author initial
 * @create 2020-10-19 19:58
 */
public class Main {

  public static void main(String[] args) {
     MyThreadTest2 myThreadTest2 = new MyThreadTest2();
     MyThreadTest3 myThreadTest3 = new MyThreadTest3();

     myThreadTest2.start();
    System.out.println(myThreadTest2.getName());
     myThreadTest3.start();
      System.out.println(myThreadTest3.getName());
  }
}
