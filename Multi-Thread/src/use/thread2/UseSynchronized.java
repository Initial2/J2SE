package use.thread2;

/**
 * @author initial
 * @create 2020-10-22 21:18
 */
public class UseSynchronized {


   public static void main(String[] args){

       Object obj = new Object();
       synchronized(obj){
           // 需要同步的代码块
       }
   }



}
