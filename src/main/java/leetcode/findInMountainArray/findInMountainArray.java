package main.java.leetcode.findInMountainArray;

/*
 * @author:liuzhaolu
 * @createTime: 2020-04-29 09:30
 * @desc:
 * （这是一个 交互式问题 ）

给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。

如果不存在这样的下标 index，就请返回 -1。

 

何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：

首先，A.length >= 3

其次，在 0 < i < A.length - 1 条件下，存在 i 使得：

A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[A.length - 1]
 

你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：

MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
MountainArray.length() - 会返回该数组的长度
 

注意：

对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。

为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请注意这 不是一个正确答案。

 

示例 1：

输入：array = [1,2,3,4,5,3,1], target = 3
输出：2
解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
示例 2：

输入：array = [0,1,2,4,2,1], target = 3
输出：-1
解释：3 在数组中没有出现，返回 -1。
 

提示：

3 <= mountain_arr.length() <= 10000
0 <= target <= 10^9
0 <= mountain_arr.get(index) <= 10^9

 */
public class findInMountainArray {
    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,3,1};
        int[] test2 = {0,1,2,4,2,1};
        int[] test3 = {2,3,4,5,3,1};
        MountainArr mountainArr = new MountainArr(test);
        MountainArr mountainArr2 = new MountainArr(test2);
        MountainArr mountainArr3 = new MountainArr(test3);
        System.out.println(search(3,mountainArr,0,mountainArr.length()-1));     // 2
        System.out.println(search(3,mountainArr2,0,mountainArr2.length()-1));     // -1
        System.out.println(search(1,mountainArr3,0,mountainArr3.length()-1));    // 6
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int left  = 0;
        int right = mountainArr.length() - 1;
        while (left <= right){
            int middle = left + (right - left) / 2;
            int mountainArrMiddle = mountainArr.get(middle);
            if(mountainArrMiddle == target){
                return middle;
            }
            // 左峰，攀升
            if(mountainArrMiddle <= mountainArr.get(middle + 1)){
                // 左峰为有序数组，右峰仍为山峰数组

                // 返回右侧
                if(mountainArrMiddle <= target){
                    left = middle + 1;
                } else { // 返回左侧
                    right = middle - 1;
                }
            } else { // 右峰，下降
                // 返回右侧
                if(mountainArrMiddle >= target){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static int search(int target, MountainArray mountainArray, int left, int right){
        if(left == right){
            return -1;
        }
        int middle = left + (right - left) / 2;
        int mountainArrMiddle = mountainArray.get(middle);
        if(mountainArrMiddle == target){
            return middle;
        }
        // 左峰，攀升
        if(mountainArrMiddle < mountainArray.get(middle + 1)){
            // 左峰为有序数组，右峰仍为山峰数组
            //左锋二分查找
            int leftTarget = erFenSearchUp(target,mountainArray,left,middle - 1);
            // 右峰递归
            int rightTarget = search(target,mountainArray,middle + 1, right);
            if(leftTarget != -1 && rightTarget != -1){
                return Math.min(leftTarget,rightTarget);
            } else if(leftTarget == -1 && rightTarget != -1){
                return rightTarget;
            } else if(leftTarget != -1 && rightTarget == -1){
                return leftTarget;
            } else {
                return -1;
            }
        } else { // 右峰，下降
            // 右峰二分查找
            int rightTarget = erFenSearchDown(target,mountainArray,middle + 1, right);
            // 左峰递归
            int leftTarget = search(target,mountainArray,left, middle - 1);
            if(leftTarget != -1 && rightTarget != -1){
                return Math.min(leftTarget,rightTarget);
            } else if(leftTarget == -1 && rightTarget != -1){
                return rightTarget;
            } else if(leftTarget != -1 && rightTarget == -1){
                return leftTarget;
            } else {
                return -1;
            }
        }
    }

    public static int erFenSearchUp(int target, MountainArray mountainArray, int left, int right){
        if(left == right){
            return -1;
        }
        int middle = left + (right - left) / 2;
        int mountainArrMiddle = mountainArray.get(middle);
        if(mountainArrMiddle == target){
            return middle;
        }
        if(mountainArrMiddle < target){
            return erFenSearchUp(target,mountainArray,middle + 1,right);
        } else {
            return erFenSearchUp(target,mountainArray,left, middle - 1);
        }
    }

    public static int erFenSearchDown(int target, MountainArray mountainArray, int left, int right){
        if(left == right){
            return -1;
        }
        int middle = left + (right - left) / 2;
        int mountainArrMiddle = mountainArray.get(middle);
        if(mountainArrMiddle == target){
            return middle;
        }
        if(mountainArrMiddle < target){
            return erFenSearchDown(target,mountainArray,left,middle - 1);
        } else {
            return erFenSearchDown(target,mountainArray,middle + 1, right);
        }
    }
}
