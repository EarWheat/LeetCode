package leetcode.One.Thousand.OrderedStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/8/16 12:00 PM
 * @Version: 1.initial version; 2022/8/16 12:00 PM
 */
public class OrderedStream {

    String[] stream;
    int ptr = 0;

    public OrderedStream(int n) {
        stream = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        stream[idKey - 1] = value;
        if (idKey - 1 == ptr) {
            for (int i = idKey - 1; i < stream.length; i++) {
                if (stream[i] == null) {
                    break;
                } else {
                    result.add(stream[i]);
                    ptr++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        os.insert(3, "ccccc"); // 插入 (3, "ccccc")，返回 []
        os.insert(1, "aaaaa"); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        os.insert(2, "bbbbb"); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        os.insert(5, "eeeee"); // 插入 (5, "eeeee")，返回 []
        os.insert(4, "ddddd"); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }
}

