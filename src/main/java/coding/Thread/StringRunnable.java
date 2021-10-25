package coding.Thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/16 下午4:17
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class StringRunnable implements Runnable {

    public StringBuffer stringBuffer;
    private CountDownLatch countDownLatch;

    StringRunnable(StringBuffer stringBuffer,CountDownLatch countDownLatch){
        this.stringBuffer = stringBuffer;
        this.countDownLatch = countDownLatch;
    }


    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                stringBuffer.append("a");
                Thread.sleep(100);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}
