package leetcode.replaceSpace;

/*
 * @author:liuzhaolu
 * @createTime: 2019-09-01 17:23
 * @desc:
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }
}
