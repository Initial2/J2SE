package communication;

/**
 *  定义一个实现类, 功能是交叉打印1-100
 * @author initial
 * @create 2020-11-06 10:29
 */
public class PrintNumber implements Runnable {
    //初始化数值,从1开始打印
    private int num = 1;
    Object obj = new Object();
  @Override
  public  void run() {
    synchronized (obj){
          while (true) {
          /* 当线程运行notify方法时, 会唤醒一个正在阻塞的线程, 即执行了wait()的线程 */
            this.notify();

            if (num <= 100) {
            System.out.println(Thread.currentThread().getName() + ":" + num);
            num++;
            try {
                /*当正在运行的线程执行wait()方法时, 线程进入阻塞状态, 然后
                 释放同步监视器(锁) , cpu进而去执行别的线程  wait()方法会报异常,
                 所以用try-catch来包住 */
              wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          } else {
            break;
          }
      }
    }
  }
}
