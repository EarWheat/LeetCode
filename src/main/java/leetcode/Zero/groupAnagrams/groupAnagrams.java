package leetcode.Zero.groupAnagrams;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-14 10:14
 * @desc 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class groupAnagrams {
    // 用于分组，key为string共性Map，每个Map表示character的数量，value为group
//    public static Map<Map<Character,Integer>, List<String>> groupMap = new HashMap<>();

//    public static class groupMap<K, V>{
//        Map<Character, Integer> key;
//        List<String> value;
//
//    }



    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length < 1){
            return result;
        }
        // 用于分组，key为string共性Map，每个Map表示character的数量，value为group
        Map<String, List<String>> groupMap = new HashMap<>();
        for(int i = 0; i < strs.length;i++){
            matchGroup(strs[i],groupMap);
        }
        for(Map.Entry entry : groupMap.entrySet()){
            result.add((List<String>)entry.getValue());
        }
        return result;
    }

    // 对于一个字符进行分组
    public static void matchGroup(String str,  Map<String, List<String>> groupMap){
        String key = getWordKey(str);
        if(groupMap.size() == 0){
            List<String> value = new ArrayList<>();
            value.add(str);
            groupMap.put(key,value);
            return;
        }
        if(groupMap.containsKey(key)){
            List<String> temp = groupMap.get(key);
            temp.add(str);
            groupMap.put(key,temp);
        } else {
            List<String> value = new ArrayList<>();
            value.add(str);
            groupMap.put(key,value);
        }
    }

//    public static List<String> get(Map<Map<Character,Integer>, List<String>> groupMap, Map<Character,Integer> key){
//        for(Map.Entry entry : groupMap.entrySet()){
//            Map<Character,Integer> temp = (Map<Character,Integer>)entry.getKey();
//            if(isSameKey(temp,key)){
//                return (List<String>)entry.getValue();
//            }
//        }
//        return null;
//    }

    // 根据String获取Key
    public static String getWordKey(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }

//    public static boolean isContainsKey(Map<Map<Character,Integer>, List<String>> group, Map<Character, Integer> key){
//        for(Map.Entry entry : group.entrySet()){
//            if(isSameKey((Map<Character, Integer>)entry.getKey(),key)){
//                return true;
//            }
//        }
//        return false;
//    }

//    public static boolean isSameKey(Map<Character, Integer> key1, Map<Character, Integer> key2){
//        if(key1.size() != key2.size()){
//            return false;
//        }
//        for(Map.Entry entry : key1.entrySet()){
//            Character key = (char)entry.getKey();
//            if(!key2.containsKey(key)){
//                return false;
//            } else {
//                if(!key2.get(key).equals(entry.getValue())){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(JSONObject.toJSONString(groupAnagrams(strings)));
    }
}
