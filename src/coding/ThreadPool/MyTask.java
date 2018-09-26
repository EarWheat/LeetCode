package coding.ThreadPool;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/26 类说明:
 */
public class MyTask implements Runnable{

    private int taskNum;

    public MyTask(int taskNum){
        this.taskNum = taskNum;
    }

    @Override
    public void run(){
        System.out.println("正在执行task"+taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
