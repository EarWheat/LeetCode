package leetcode.Two.StockPrice;

import java.util.*;

/**
 * @author ：liuzhaolu
 * @description：2034. 股票价格波动
 * @prd : https://leetcode-cn.com/problems/stock-price-fluctuation/
 * @date ：2022/1/23 2:16 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/23 2:16 下午     liuzhaolu       firstVersion
 */
public class StockPrice {
    int maxTimestamp; //记录最大的时间戳 current方法可直接返回
    HashMap<Integer, Integer> map;//存储 时间戳-股票最新价格
    TreeMap<Integer, Integer> prices; //存储股票价格及出现次数

    public StockPrice() {
        map = new HashMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        Integer n = map.get(timestamp);
        if (n != null) { //说明股票价格需要更新
            Integer pr = prices.get(n);
            if (pr == 1) {
                prices.remove(n);
            } else {
                prices.put(n, pr - 1);
            }
        }
        prices.put(price, prices.getOrDefault(price, 0) + 1);
        map.put(timestamp, price);
    }

    public int current() {
        return map.get(maxTimestamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }
}
