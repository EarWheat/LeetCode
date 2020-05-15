package coding.BuyTicket;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-17 18:20
 * @desc:
 */
public class BuyTicket implements Runnable{
    //票数
    private  int ticketNum=10;
    //标志位
    private boolean flag=true;

    private String name;

    public BuyTicket(String name){
        this.name = name;
    }
    @Override
    public void run() {
        while (flag){
            buyTicket();
        }
    }

    public synchronized void buyTicket(){
        //模仿网络延时
        try {
            Thread.sleep(100);
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
