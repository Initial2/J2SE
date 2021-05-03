package BankTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author initial
 * @create 2020-10-27 12:22
 */
public class Count extends Thread {
    static int totalMoney = 0;
    int money = 3000;




    /*方法1: 使用lock锁
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            try{
                if (money > 0 ){
                    totalMoney +=1000;
                    money = money - 1000;
                    System.out.println(Thread.currentThread().getName()+"存了1000"+"当前账户余额:"+totalMoney);
                }else {
                    break;
                }
            }finally{
                lock.unlock();
            }


            }
        }
    */



    /*//方法2 使用synchronized 同步代码块
    @Override
    public void run() {
       synchronized (Count.class){
           while (true){
                if (money > 0) {
                  totalMoney += 1000;
                  money = money - 1000;
                  System.out.println(Thread.currentThread().getName()+"存了1000"+" 当前账户余额:" + totalMoney);
                }else {
                    break;
                }
           }
       }
    }*/



    //方法3  使用同步方法 synchronized

    @Override
    public void run() {
        show();
    }

    public  synchronized  void show(){
        while (true){
            if (money > 0) {
                totalMoney += 1000;
                money = money - 1000;
                System.out.println(Thread.currentThread().getName()+"存了1000"+" 当前账户余额:" + totalMoney);
            }else {
                break;
            }
        }
    }
}
