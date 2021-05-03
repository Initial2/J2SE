package day02;
/**
 * @author initial
 * @create 2020-10-26 17:57
 */
public class DeadLock {

  public static void main(String[] args) {
    // 声明两个字符串
    StringBuffer s1 = new StringBuffer();
    StringBuffer s2 = new StringBuffer();

    // 创建线程1,使用匿名实现类创建
    new Thread(
            new Runnable() {
              @Override
              public void run() {
                // 先拿s1作为锁, 然后对两个字符串进行修改
                synchronized (s1) {
                  s1.append("1");
                  s2.append("a");

                  // 线程1运行到此睡眠100ms, 此时cpu极有可能转而去运行线程2, 因为当前
                  //线程已经是阻塞得了.
                  try {
                    Thread.sleep(100);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }

                  // 线程1执行到这里,再拿s2作为锁, 然后对两个字符串进行修改
                  // 如果线程1睡眠后, cpu去运行下面那个线程2了.
                  // 下面那个线程2也会睡眠100ms, 这时cpu再返回来执行当前线程1.
                  // 那么下面那个线程就会拿着s2的锁.然后我们想要运行接下来这个同步代码块,也需要s2的锁.
                  // 这样就会产生死锁.  因为下面那个代码块它需要s1锁 才能接着执行, 而我们当前这个线程需要
                  // s2锁, 才能接着执行.  同步代码块的锁必须执行完毕,才会释放,让下一个线程用.
                  // 所以两个线程陷入互相等待对方结束释放锁的处境.
                  synchronized (s2) {
                    s1.append("2");
                    s2.append("b");
                    System.out.println(s1);
                    System.out.println(s2);
                  }
                }
              }
            })
        .start();



    new Thread(
            new Runnable() {
              @Override
              public void run() {
                // 先拿s2作为锁, 然后对两个字符串进行修改
                synchronized (s2) {
                  s1.append("3");
                  s2.append("c");

                  // 线程运行到此睡眠100ms, 此时cpu极有可能转而去运行上个线程, 因为当前
                  //线程已经是阻塞得了.
                  try {
                    Thread.sleep(100);
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }

                  synchronized (s1) {
                    s1.append("4");
                    s2.append("d");
                    System.out.println(s1);
                    System.out.println(s2);
                  }
                }
              }
            })
        .start();
  }
}
