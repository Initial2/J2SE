package BankTest;

/**
 * @author initial
 * @create 2020-10-27 12:28
 */
public class Bank {

  public static void main(String[] args) {

      Thread thread1 = new Count();
      Thread thread2 = new Count();

      thread1.setName("账户1");
      thread2.setName("账户2");

      thread1.start();
      thread2.start();
  }
}
