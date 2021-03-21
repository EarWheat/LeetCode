package coding.Design.SingleTon;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/21 下午3:49
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class LazySingleTon {
    private static final LazySingleTon instance = null;
    private LazySingleTon(){};
    public static LazySingleTon getInstance(){
        if(instance == null){
            return new LazySingleTon();
        }
        return instance;
    }
}
