package coding.BuyTicket;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-17 18:27
 * @desc:
 */
public class netStation {
    public static void main(String[] args){
        BuyTicket buyTicket = new BuyTicket();
        Thread A = new Thread(buyTicket,"hello");
        Thread B = new Thread(buyTicket,"world");
        Thread C = new Thread(buyTicket,"coding");
        A.start();
        B.start();
        C.start();
    }
}
