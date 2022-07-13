package leetcode.Seven.asteroidCollision;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/7/13 3:05 PM
 * @Version: 1.initial version; 2022/7/13 3:05 PM
 */
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if(asteroids[i] >= 0){
                stack.add(asteroids[i]);
            } else {
                boolean hasCrash = false;
                while (!stack.isEmpty()){
                    Integer peek = stack.peek();
                    if(peek < 0){
                        break;
                    }
                    if(peek > Math.abs(asteroids[i])){
                        hasCrash = true;
                        break;
                    } else if(peek == asteroids[i]){
                        hasCrash = true;
                        stack.pop();
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if(!hasCrash){
                    stack.add(asteroids[i]);
                }
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
