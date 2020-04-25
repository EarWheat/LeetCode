package coding.Thread;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/12 类说明:
 */
public class ThreadTest {
    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();	//开启一个线程

        MyRunnable myRunnable = new MyRunnable();
        Thread runnable = new Thread(myRunnable);
        runnable.start();	//开启一个线程

    }
}
