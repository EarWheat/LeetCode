package coding.Hash;

import coding.Thread.MyThread;

import java.util.HashMap;

/**
 * @author liuzhaolu
 * @version create_time：2018/9/13 类说明:
 */
public class HashTest {

    public static void main(String args[]){
        HashMap<String,String> map = new HashMap<>();
        System.out.println("HashMap default size:"+map.size());
        System.out.println("HashMap hashCode:"+map.hashCode());
        map.put("test","hello world!");
        System.out.println("key test hashCode:"+map.get("test").hashCode());
    }
}
