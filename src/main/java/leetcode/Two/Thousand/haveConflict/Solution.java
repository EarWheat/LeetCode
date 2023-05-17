package leetcode.Two.Thousand.haveConflict;

/**
 * @Desc: 判断两个事件是否存在冲突
 * @Author: 泽露
 * @Date: 2023/5/17 3:51 PM
 * @Version: 1.initial version; 2023/5/17 3:51 PM
 */
public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
    }
}
