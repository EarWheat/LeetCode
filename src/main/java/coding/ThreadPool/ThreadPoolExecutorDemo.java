package coding.ThreadPool;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/26 类说明:
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args){
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(5);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, queue, new IThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0;i < 15; i++){
            MyTask myTask = new MyTask(i);
            poolExecutor.execute(myTask);
            System.out.println("线程池中的线程数目：" + poolExecutor.getPoolSize() + "             "+
                                "队列中等待执行的任务数量：" + poolExecutor.getQueue().size() + "           "+
                                "已执行完成的任务数目：" + poolExecutor.getCompletedTaskCount());
        }
        poolExecutor.shutdown();
    }
}


