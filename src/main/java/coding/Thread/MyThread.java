package coding.Thread;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/12 类说明:
 */
public class MyThread extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
