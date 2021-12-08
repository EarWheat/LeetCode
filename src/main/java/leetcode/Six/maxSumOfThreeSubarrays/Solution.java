package leetcode.Six.maxSumOfThreeSubarrays;

/**
 * @author ：liuzhaolu
 * @description：TODO
 * @prd :
 * @date ：2021/12/8 5:21 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/8 5:21 下午     liuzhaolu       firstVersion
 */
public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int kSum[]=new int[nums.length+1-k];//kSum[p]表示从p开始的k个数字之和
        for(int i=0;i<k;i++){kSum[0]+=nums[i];}
        for(int i=1;i<=nums.length-k;i++){kSum[i]=kSum[i-1]-nums[i-1]+nums[i+k-1];}
        int leftMax[]=new int[kSum.length];//kSum左边从0-p取得最大值的坐标
        int rightMax[]=new int[kSum.length];//kSum右边取得最大值的坐标
        rightMax[kSum.length-1]=kSum.length-1;
        for(int i=1;i<kSum.length;i++){
            leftMax[i]=kSum[i]>kSum[leftMax[i-1]]?i:leftMax[i-1];
            rightMax[kSum.length-1-i]=kSum[kSum.length-1-i]>=kSum[rightMax[kSum.length-i]]?kSum.length-1-i:rightMax[kSum.length-i];
        }
        int ans[]=new int[0];
        int maxSum=0;
        for(int i=k;i<=nums.length-2*k;i++){
            if(maxSum<kSum[i]+kSum[leftMax[i-k]]+kSum[rightMax[i+k]]){
                maxSum=kSum[i]+kSum[leftMax[i-k]]+kSum[rightMax[i+k]];
                ans=new int[]{leftMax[i-k],i,rightMax[i+k]};
            }
        }
        return ans;
    }
}
