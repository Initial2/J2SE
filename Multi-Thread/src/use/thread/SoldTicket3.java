package use.thread;

/**
 * @author initial
 * @create 2020-10-19 20:41
 */
public class SoldTicket3  extends Thread {
    @Override
    public void run() {
        while (true) {
            if (SoldTicketTest.numOfTicket > 0) {
                SoldTicketTest.numOfTicket--;
                this.setName("线程3");
                System.out.println(this.getName() + "卖出了一张票. 票号"+SoldTicketTest.numOfTicket);
            }else {
                break;
            }
        }
    }
}
