package leetcode.One.defangIPaddr;

/**
 * @Desc:
 * @Author: 泽露
 * @Date: 2022/6/21 2:49 PM
 * @Version: 1.initial version; 2022/6/21 2:49 PM
 */
public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
