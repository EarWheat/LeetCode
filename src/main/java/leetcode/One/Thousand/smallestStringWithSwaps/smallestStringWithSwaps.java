package leetcode.One.Thousand.smallestStringWithSwaps;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/11 下午3:04
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class smallestStringWithSwaps {
    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0){
            return s;
        }
        char[] chars = new char[s.length()]; // 对s可交换的索引进行染色
        char flag = 'a';    // 初始标记
        Map<Character, Set<Integer>> map = new HashMap<>(); // 被染成key的索引集合，用于同化
        for(List<Integer> list : pairs){
            char a = chars[list.get(0)];
            char b = chars[list.get(1)];
            if(isColorful(a) && isColorful(b)){ // a，b都已经染色
                // 同化为小的颜色
                if(a < b){
                    if(map.containsKey(b)){
                        list.addAll(map.get(b));
                        map.remove(b);
                    }
                    fillColor(chars,map,a,list);
                } else {
                    if(map.containsKey(a)){
                        list.addAll(map.get(a));
                        map.remove(a);
                    }
                    fillColor(chars,map,b,list);
                }
            } else if(isColorful(a) && !isColorful(b)){
                fillColor(chars,map,a,list);
            } else if(isColorful(b) && !isColorful(a)){
                fillColor(chars,map,b,list);
            } else {
                fillColor(chars,map,flag,list);
                flag++;
            }
        }
//        for(int i = 0; i < chars.length; i++){
//            if(!isColorful(chars[i])){
//                Set<Integer> set = new HashSet<>();
//                set.add(i);
//                map.put(flag, set);
//                chars[i] = flag++;
//            }
//        }
        return orderChars(map,s);
    }

    /**
     * 是否已经染色
     * @param c
     * @return
     */
    public static boolean isColorful(char c){
        if('a' <= c && c <= 'z'){
            return true;
        }
        return false;
    }

    /**
     * 填充颜色
     * @param chars
     * @param map
     * @param flag
     * @param list
     */
    public static void fillColor(char[] chars, Map<Character, Set<Integer>> map, char flag, List<Integer> list){
        for(Integer integer : list){
            chars[integer] = flag;
        }
        Set<Integer> temp;
        if(map.containsKey(flag)){
            temp = map.get(flag);
        } else {
            temp = new HashSet<>();
        }
        temp.addAll(list);
        map.put(flag,temp);
    }

    /**
     * 排序
     */
    public static String orderChars(Map<Character, Set<Integer>> map, String s){
        char[] result = s.toCharArray();
        for(Map.Entry<Character, Set<Integer>> entry : map.entrySet()){
            Set<Integer> set = entry.getValue();
            Object[] sets = set.toArray();
            Arrays.sort(sets);
            char[] array = new char[sets.length];
            int i = 0;
            for(Object integer : sets){
                array[i++] = s.charAt((int)integer);
            }
            Arrays.sort(array);
            i = 0;
            for(Object integer : sets){
                result[(int)integer] = array[i++];
            }
        }
//        return JSONObject.toJSONString(result);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            stringBuilder.append(result[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[][] temp = new int[][]{{9,1},{5,11},{9,7},{2,7},{14,16},{6,16},{0,5},{12,9},{6,5},{9,10},{4,7},{3,2},{10,1},{3,15},{12,4},{10,10},{15,12}};
        List<List<Integer>> inputList = new ArrayList<>();
        for(int i = 0; i < temp.length; i++){
            int[] t = temp[i];
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < t.length; j++){
                list.add(t[j]);
            }
            inputList.add(list);
        }
        System.out.println(smallestStringWithSwaps("yhiihxbordwyjybyt", inputList));
    }
}
