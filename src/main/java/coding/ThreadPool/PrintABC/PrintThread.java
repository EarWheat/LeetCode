package coding.ThreadPool.PrintABC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-15 16:01
 * @desc: 顺序打印ABC
 */
public class PrintThread implements Runnable {

    private String name;
    private static Lock lock = new ReentrantLock();

    private static Integer currentCount = 0;

    private static final Integer MAX_COUNT = 30;

    private static String [] chars = {"a", "b", "c"};


    public PrintThread(String name){
        this.name = name;
    }
    @Override
    public synchronized void run(){
        while (currentCount < MAX_COUNT){
            try{
                lock.lock();
                while(this.name.equals(chars[currentCount%3])&& currentCount<MAX_COUNT){
                    System.out.println(name + "\t" + currentCount);
                    currentCount ++;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
