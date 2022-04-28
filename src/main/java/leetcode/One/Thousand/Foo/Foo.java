package leetcode.One.Thousand.Foo;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：liuzhaolu
 * @description：1114. 按序打印
 * @prd : https://leetcode-cn.com/problems/print-in-order/
 * @date ：2022/1/8 8:10 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/8 8:10 下午     liuzhaolu       firstVersion
 */
public class Foo {


    private AtomicInteger flag = new AtomicInteger(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag.getAndIncrement();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(flag.get() != 2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag.getAndIncrement();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(flag.get() != 3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,6,1000, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        Foo foo = new Foo();
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new First());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(new Second());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new Third());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static class First implements Runnable{
        @Override
        public void run() {
            System.out.print("first");
        }
    }

    public static class Second implements Runnable{
        @Override
        public void run() {
            System.out.print("second");
        }
    }

    public static class Third implements Runnable{
        @Override
        public void run() {
            System.out.print("third");
        }
    }
}
