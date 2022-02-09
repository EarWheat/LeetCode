package coding.Design.SingleTon;

/**
 * @author ：liuzhaolu
 * @description：单例模式双重校验锁
 * @prd :
 * @date ：2022/2/9 4:21 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/9 4:21 下午     liuzhaolu       firstVersion
 */
public class SingleTon {

    private static volatile SingleTon singleTon = null;


    private SingleTon getInstance(){
        if(singleTon == null){
            synchronized (SingleTon.class){
                if(singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }

}
