package coding.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/18 下午4:39
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class StaticRunnable implements Runnable{

    private CountDownLatch countDownLatch;

    StaticRunnable(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                ThreadTest.stringBuffer.append("a");
                ThreadTest.stringBuilder.append("b");
                ThreadTest.num++;
                System.out.println(Thread.currentThread().getName() + "--------" + ThreadTest.num);
                Thread.sleep(20);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
