package Interview;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/11/8 11:13 AM
 * @Version: 1.initial version; 2022/11/8 11:13 AM
 */
public class Test {

    public static Map<String, Integer> nodes = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0; i < 100; i++) {
            List<Integer> card = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                card.add(i);
            }
            test.cutLiveCardSize(card);
            System.out.println(i + "=======" + card.size());
        }
    }

    public void cutLiveCardSize(List<Integer> cards) {
        if (cards.size() < 7) {
            return;
        }
        while (!matchSize(cards.size())){
            cards.remove(cards.size() - 1);
        }
    }

    public boolean matchSize(int size){
        return (size - 1) % 6 == 0 && ((size - 1) / 6) % 3 == 0;
    }
}
