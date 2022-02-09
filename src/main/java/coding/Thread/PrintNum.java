package coding.Thread;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2022/2/8 2:34 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/8 2:34 下午     liuzhaolu       firstVersion
 */
public class PrintNum {

    public static AtomicInteger num = new AtomicInteger(0);
    public static AtomicInteger runThread = new AtomicInteger(0);
//    public static int num = 1;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 3, TimeUnit.MINUTES, new ArrayBlockingQueue<>(3));
        executor.execute(() -> {
            while (num.get() <= 3000 && runThread.get() == 0) {
                if (num.get() % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + "-----" + num);
                }
                num.getAndIncrement();
            }
//            while (num <= 3000){
//                if(num % 2 == 0){
//                    System.out.println(Thread.currentThread().getName() + "-----" + num);
//                    num++;
//                }
//            }
        });
        executor.execute(() -> {
            while (num.get() <= 3000) {
                if (num.get() % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + "-----" + num);
                    num.getAndIncrement();
                }
            }
//            while (num <= 3000){
//                if(num % 2 != 0){
//                    System.out.println(Thread.currentThread().getName() + "-----" + num);
//                    num++;
//                }
//            }
        });
    }
}
