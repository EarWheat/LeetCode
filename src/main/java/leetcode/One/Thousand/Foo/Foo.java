package leetcode.One.Thousand.Foo;

import lombok.SneakyThrows;

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


    private volatile int flag = 1;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(flag != 2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(flag != 3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,6,1000, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        Foo foo = new Foo();
        poolExecutor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.first(new First());
            }
        });
        poolExecutor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.second(new Second());
            }
        });
        poolExecutor.execute(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                foo.third(new Third());
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
