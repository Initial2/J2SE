package communication;

/**
 * @author initial
 * @create 2020-11-06 10:28
 */
public class CommunicationTest {
  public static void main(String[] args) {
    //


    PrintNumber number = new PrintNumber();

    Thread thread1 = new Thread(number);
    Thread thread2 = new Thread(number);

    thread1.setName("线程1");
    thread2.setName("线程2");

    thread1.start();
    thread2.start();
  }
}
