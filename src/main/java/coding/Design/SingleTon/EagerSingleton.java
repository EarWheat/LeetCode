package coding.Design.SingleTon;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/3/21 上午8:41
 * @desc 饿汉单例模式
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton(){};
    public static EagerSingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        EagerSingleton eagerSingleton = new EagerSingleton();
        EagerSingleton eagerSingleton1 = new EagerSingleton();
        System.out.println(eagerSingleton.equals(eagerSingleton1));
        EagerSingleton eagerSingleton2 = EagerSingleton.getInstance();
        EagerSingleton eagerSingleton3 = EagerSingleton.getInstance();
        System.out.println(eagerSingleton2.equals(eagerSingleton3));
    }
}
