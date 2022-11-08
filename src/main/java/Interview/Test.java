package Interview;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/8 11:13 AM
 * @Version: 1.initial version; 2022/11/8 11:13 AM
 */
public class Test {

    public static Map<String, Integer> nodes = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        nodes.put("1",1);
        nodes.put("2",2);
        nodes.put("3",3);
        new Thread(() -> {
            for (Map.Entry<String, Integer> entry : nodes.entrySet()) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(entry.getKey() + "---" + entry.getValue());
            }
        }).start();


        new Thread(() -> {
            nodes.put("100", 100);
            nodes.put("200", 200);
        }).start();
    }
}
