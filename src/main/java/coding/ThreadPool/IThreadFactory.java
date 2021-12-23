package coding.ThreadPool;

import java.util.concurrent.ThreadFactory;

/**
 * @author ：liuzhaolu
 * @description：自定义线程工厂
 * @prd :
 * @date ：2021/12/23 10:11 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/23 10:11 上午     liuzhaolu       firstVersion
 */
public class IThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("zero");
        return thread;
    }
}
