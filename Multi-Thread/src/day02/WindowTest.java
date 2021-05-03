package day02;

/**
 * @author initial
 * @create 2020-10-26 17:02
 */
public class WindowTest {
  public static void main(String[] args) {
      Window w = new Window();


      Thread t1 = new Thread(w);
      Thread t2 = new Thread(w);
      Thread t3 = new Thread(w);

      t1.start();
      t2.start();
      t3.start();

  }



}
