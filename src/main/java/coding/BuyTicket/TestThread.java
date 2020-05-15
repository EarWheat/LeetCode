package coding.BuyTicket;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-15 16:54
 * @desc:
 */
public class TestThread implements Runnable {
    //票数
    private  int ticketNum=10;
    //标志位
    private boolean flag=true;

    @Override
    public void run(){
        while (flag){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (ticketNum<=0){
                flag=false;
                return;
            }
            System.out.println(Thread.currentThread().getName()+"---->拿到了第"+ticketNum--+"票");
        }
    }
}
