package leetcode.Six.topKFrequent;


import java.util.*;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/5/20 下午4:52
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(words).forEach(e -> putMap(map, e));
        List<String> wordCounts = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            wordCounts.add(String.valueOf(entry.getValue()).concat("-").concat(entry.getKey()));
        }
        String[] wordsCountArray =  wordCounts.toArray(new String[]{});
        Arrays.sort(wordsCountArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String count1 = o1.split("-")[0];
                String count2 = o2.split("-")[0];
                if(Integer.parseInt(count1) > Integer.parseInt(count2)){
                    return -1;
                } else if(count1.equals(count2)){
                    String word1 = o1.split("-")[1];
                    String word2 = o2.split("-")[1];
                    int length = Math.min(word1.length(), word2.length());
                    int i = 0;
                    for (i = 0; i < length; i++) {
                        if(word1.charAt(i) < word2.charAt(i)){
                            return -1;
                        }
                        if(word1.charAt(i) > word2.charAt(i)){
                            return 1;
                        }
                    }
                    if(i >= length){
                        if(word1.length() < word2.length()){
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                } else {
                    return 1;
                }
                return 0;
            }
        });
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(wordsCountArray[i].split("-")[1]);
        }
        return result;
    }

    public void putMap(Map<String, Integer> map, String str){
        if(map.containsKey(str)){
            Integer num = map.get(str);
            map.put(str,num + 1);
        } else {
            map.put(str,1);
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(words,4));
    }
}
