package Test;

/**
 * 创建一个Thread的子类.
 * @author initial
 * @create 2020-11-06 16:34
 */
public class Consumer extends Thread {

    /* 因为店员类中有共享的数据和数据的操作方法.
    所以声明一个店员类对象clerk, 用来创建Consumer对象时
    进行初始化 */
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

   /* 消费者只需要做消费商品的事情,其它不用管
        所以无限调用clerk.consumeProduct()方法. */
    @Override
    public void run() {
        while (true) {
            clerk.consumeProduct();
        }
    }

}
