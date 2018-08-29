package coding;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/29 类说明:
 */
public class Singleton_2 {
    private static Singleton_2 instace;
    private Singleton_2(){}
    public static synchronized Singleton_2 getInstace(){
        if(instace == null){
            return new Singleton_2();
        }
        return instace;
    }
}
