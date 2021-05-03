package day02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author initial
 * @create 2020-10-26 16:59
 */
public class Window  implements Runnable{
    private  int numOfTickets = 100;

    // 使用Lock锁 开解决线程安全问题.
    //1.新建一个ReentrantLock类的对象
    private ReentrantLock lock = new ReentrantLock();


    @Override
    public void run() {
        while (true) {
            // 调用lock的 lock()方法来进行上锁(同步). lock.lock()后面必须紧跟try{}
            //裹住的需要同步的代码块
            lock.lock();
            try{
                if (numOfTickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出了一张票. 票号"+numOfTickets);
                    numOfTickets--;
                    System.out.println(lock.isHeldByCurrentThread());
                }
            }finally{
                // 最后使用lock.unlock()方法进行手动解锁.
                // 且该方法必须卸载finally语句中.
                lock.unlock();
            }

        }
    }
}
