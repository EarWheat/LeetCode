package coding.BuyTicket;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-17 18:27
 * @desc:
 */
public class netStation {
    public static void main(String[] args){
//        BuyTicket buyTicket = new BuyTicket("zero");
//        Thread A = new Thread(buyTicket,"hello");
//        Thread B = new Thread(buyTicket,"world");
//        Thread C = new Thread(buyTicket,"coding");
//        B.start();
//        A.start();
//        C.start();

//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,3,200, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
//        threadPoolExecutor.execute(new BuyTicket("zero"));
//        threadPoolExecutor.execute(new BuyTicket("lzl"));
//        threadPoolExecutor.execute(new BuyTicket("gloria"));
//        threadPoolExecutor.shutdown();

        TestThread testThread = new TestThread();
        Thread a = new Thread(testThread,"zero");
        Thread b = new Thread(testThread,"lzl");
        a.start();
        b.start();
    }
}
