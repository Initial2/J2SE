package Test;

/**
 * 创建店员类, 他可以通知生产者生产商品, 通知消费者消费商品.
 * @author initial
 * @create 2020-11-06 11:57
 */
public class Clerk {
    /* 初始商品为0 */
    private int num = 0;

    /*生产商品的方法*/
    public synchronized void produceProduct() {
        /* 商品数量小于20, 通知生产者开始生产 . 当生产者生产完商品, 就可以通知消费者开始消费商品了,
            所以使用notify()方法, 唤醒消费者线程, 让他开始消费商品 */
        if(num < 20){
            num++;
            System.out.println(Thread.currentThread().getName()+":正在生产第"+ num +"号商品");
            notify();
        }else{
            /* 如果商品数量 = 20 那么就暂时不需要再生产产品了, 所以生产者进入等待(阻塞)状态.
                调用wait()方法. 该方法会抛出异常,所以使用try-catch包住.
             */
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }

    }

    /*消费商品的方法*/
    public synchronized void consumeProduct() {

        /* 商品数量 > 0 所以可以消费. 消费者就开始消费商品, 消费一次,商品数量-1.
            消费者一旦消费完一个商品,那么总商品数量就<20了, 就可以调用notify()方法
            唤醒生产者线程,让他开始生产商品.*/
            if(num > 0){
                System.out.println(Thread.currentThread().getName()+":正在消费"+num+"号产品");
                num--;
                notify();
            }else{
                /* 当商品数量 <= 0 时, 消费者就没办法消费商品了. 消费者线程进入等待(阻塞)状态.
                    等待有商品了, 在唤醒他消费*/
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }
}
