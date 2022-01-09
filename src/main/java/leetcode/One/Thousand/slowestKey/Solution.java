package leetcode.One.Thousand.slowestKey;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author ：liuzhaolu
 * @description：1629. 按键持续时间最长的键
 * @prd : https://leetcode-cn.com/problems/slowest-key/
 * @date ：2022/1/9 5:33 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/9 5:33 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxLiveTime = 0;
        List<Character> keys = new ArrayList<>();
        for (int i = 0; i < releaseTimes.length; i++) {
            if(i == 0){
                maxLiveTime = releaseTimes[i];
                keys.add(keysPressed.charAt(i));
            } else {
                if(releaseTimes[i] - releaseTimes[i - 1] == maxLiveTime){
                    keys.add(keysPressed.charAt(i));
                } else if(releaseTimes[i] - releaseTimes[i - 1] > maxLiveTime){
                    maxLiveTime = releaseTimes[i] - releaseTimes[i - 1];
                    keys.clear();
                    keys.add(keysPressed.charAt(i));
                }
            }
        }
        if(keys.size() == 0){
            return 0;
        }
        return keys.stream().max(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(o1 > o2){
                    return 1;
                } else if(o1 < o2){
                    return -1;
                }
                return 0;
            }
        }).get();
    }
}
