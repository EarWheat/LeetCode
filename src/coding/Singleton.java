package coding;

/**
 * @author liuzhaolu
 * @version create_time：2018/8/29 类说明:
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    private static Singleton getInstance(){
        return instance;
    }

}
