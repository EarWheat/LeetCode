package leetcode.Seven.isOneBitCharacter;

/**
 * @author ：liuzhaolu
 * @description：717. 1比特与2比特字符
 * @prd : https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * @date ：2022/2/20 2:55 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/2/20 2:55 下午     liuzhaolu       firstVersion
 */
public class Solution {
    // 从起点开始遍历，当遇到1时，这个1一定会把下一个0或1吃掉，因此这时需要跳过下一个。如果能遍历到最后一个0，就说明成功了。
    public boolean isOneBitCharacter(int[] bits) {
        int start = 0 ;
        while(start<bits.length-1){
            if(bits[start] == 0){
                start++;
            }else{
                start+=2;
            }
        }
        return start == bits.length-1;
    }
}
