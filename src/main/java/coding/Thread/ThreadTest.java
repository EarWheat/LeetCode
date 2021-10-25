package coding.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/12 类说明:
 */
public class ThreadTest {
    public static StringBuffer stringBuffer = new StringBuffer();
    public static StringBuilder stringBuilder = new StringBuilder();
    public static int num = 0;

    public static void main(String[] args) throws InterruptedException {
//
//        MyThread thread = new MyThread();
//        thread.start();	//开启一个线程
//
//        MyRunnable myRunnable = new MyRunnable();
//        Thread runnable = new Thread(myRunnable);
//        runnable.start();	//开启一个线程
        List list = new ArrayList();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        StaticRunnable runnable = new StaticRunnable(countDownLatch);
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();
        countDownLatch.await();
        System.out.println(stringBuffer.length());
        System.out.println(stringBuilder.length());
        System.out.println("=========="+num);
    }
}
