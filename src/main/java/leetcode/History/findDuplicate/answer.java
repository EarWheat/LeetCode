package leetcode.History.findDuplicate;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-26 10:05
 * @desc: 快慢指针算法
 */
public class answer {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
