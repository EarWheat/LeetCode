package coding.ThreadPool.PrintABC;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-15 16:10
 * @desc:
 */
public class Print {
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,3,200, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
//        threadPoolExecutor.execute(new PrintThread("a"));
//        threadPoolExecutor.execute(new PrintThread("b"));
//        threadPoolExecutor.execute(new PrintThread("c"));
//        threadPoolExecutor.shutdown();
        System.out.println("=========");
        PrintThread printThread1 = new PrintThread("a");
        PrintThread printThread2 = new PrintThread("b");
        PrintThread printThread3 = new PrintThread("c");
        printThread1.run();
        printThread2.run();
        printThread3.run();
    }
}
