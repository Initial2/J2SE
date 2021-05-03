package use.thread;

/**
 * @author initial
 * @create 2020-10-19 20:41
 */
public class SoldTicketTest {
    static int numOfTicket = 100;

    public static void main(String[] args){
        SoldTicket1 s1 = new SoldTicket1();
        SoldTicket2 s2 = new SoldTicket2();
        SoldTicket3 s3 = new SoldTicket3();

                s1.start();
                s2.start();
                s3.start();

    }


}




