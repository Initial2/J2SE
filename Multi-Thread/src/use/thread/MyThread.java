package use.thread;



/**
 * @author Inital
 */
public class MyThread extends  Thread{

    /**
     * @apiNote 重写run方法,遍历100以内所有的偶数
     */
    @Override
    public void run() {
        for (int i = 1; i <=100; i++) {
            if ( i % 2 == 0){
                System.out.println(i);
            }

        }
    }

}
