package use.thread2;

/**
 * @author initial
 * @create 2020-10-20 19:05
 */
public class MyThread2  implements Runnable {
    private  int numOfTickets = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            //使用类 作为对象.
            synchronized (MyThread2.class){
                if (numOfTickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票. 票号"+numOfTickets);
                }else {
                    break;
                }
                numOfTickets--;
            }
        }
    }
}
