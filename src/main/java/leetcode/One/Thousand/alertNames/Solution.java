package leetcode.One.Thousand.alertNames;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大
//于等于三次，这个系统会自动发布一个 警告 。
//
// 给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡
//的时间。
//
// 使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
//
// 请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
//
// 请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使
//用情况。
//
//
//
// 示例 1：
//
//
//输入：keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"],
//keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
//输出：["daniel"]
//解释："daniel" 在一小时内使用了 3 次员工卡（"10:00"，"10:40"，"11:00"）。
//
//
// 示例 2：
//
//
//输入：keyName = ["alice","alice","alice","bob","bob","bob","bob"], keyTime = ["12
//:01","12:00","18:00","21:00","21:20","21:30","23:00"]
//输出：["bob"]
//解释："bob" 在一小时内使用了 3 次员工卡（"21:00"，"21:20"，"21:30"）。
//
//
// 示例 3：
//
//
//输入：keyName = ["john","john","john"], keyTime = ["23:58","23:59","00:01"]
//输出：[]
//
//
// 示例 4：
//
//
//输入：keyName = ["leslie","leslie","leslie","clare","clare","clare","clare"],
//keyTime = ["13:00","13:20","14:00","18:00","18:51","19:30","19:49"]
//输出：["clare","leslie"]
//
//
//
//
// 提示：
//
//
// 1 <= keyName.length, keyTime.length <= 10⁵
// keyName.length == keyTime.length
// keyTime 格式为 "HH:MM" 。
// 保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
// 1 <= keyName[i].length <= 10
// keyName[i] 只包含小写英文字母。
//
// Related Topics 数组 哈希表 字符串 排序 👍 53 👎 0

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2023/2/7 11:35 AM
 * @Version: 1.initial version; 2023/2/7 11:35 AM
 */
public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> doorMap = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            if (doorMap.containsKey(name)) {
                List<String> list = doorMap.get(name);
                list.add(keyTime[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(keyTime[i]);
                doorMap.put(name, list);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : doorMap.entrySet()) {
            List<String> value = entry.getValue();
            if (isAlert(value)) {
                result.add(entry.getKey());
            }
        }
        result.sort((s1, s2) -> {
            int length = Math.min(s1.length(), s2.length());
            for (int i = 0; i < length; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    continue;
                }
                if (s1.charAt(i) < s2.charAt(i)) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        });
        return result;
    }

    public boolean isAlert(List<String> value) {
        value.sort((s1, s2) -> {
            int length = Math.min(s1.length(), s2.length());
            for (int i = 0; i < length; i++) {
                if (s1.charAt(i) == s2.charAt(i)) {
                    continue;
                }
                if (s1.charAt(i) < s2.charAt(i)) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        });
        for (int i = 0; i < value.size() - 2; i++) {
            String start = value.get(i);
            String end = value.get(i + 2);
            // 同一个时间内
            if (start.substring(0, 2).equalsIgnoreCase(end.substring(0, 2))) {
                return true;
            } else {
                Integer startHour = Integer.parseInt(start.split(":")[0]);
                Integer endHour = Integer.parseInt(end.split(":")[0]);
                int startMin = Integer.parseInt(start.split(":")[1]);
                int endMin = Integer.parseInt(end.split(":")[1]);
                if (endHour - startHour == 1 && endMin <= startMin) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alertNames(new String[]{"a","a","a","a","a","b","b","b","b","b","b"}, new String[]{"04:48","23:53","06:36","07:45","12:16","00:52","10:59","17:16","00:36","01:26","22:42"}));
    }
}
