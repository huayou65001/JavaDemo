package com.caleb.algorithm.leetcode;

/**
 * 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * @author：hanzhigang
 * @Date : 2021/4/28 11:34 PM
 */
public class MaxProduct152 {

    /**
     * 思路：暴力解法
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        int len = nums.length;
        int res = Integer.MIN_VALUE;
        int cur;    // 记录当前值

        for (int i = 0; i < len; i++) {
            cur = 1;
            for (int j = i; j < len; j++) {
                cur *= nums[j];
                if (cur != 0) {
                    res = Math.max(cur, res);
                } else {
                    res = Math.max(cur, res);
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 思路：动态规划
     *
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {

        int len = nums.length;
        int mMax = nums[0]; // 记录最大值
        int mMin = nums[0]; // 记录最小值
        int res = nums[0];  // 当前结果

        for (int i = 1; i < len; i++) {
            mMax = Math.max(mMax * nums[i], Math.max(mMin * nums[i], nums[i]));
            mMin = Math.min(mMax * nums[i], Math.min(mMin * nums[i], nums[i]));
            res = Math.max(res,mMax);
        }

        return mMax;
    }

    public static void main(String[] args) {
        MaxProduct152 maxProduct152 = new MaxProduct152();
        System.out.println(maxProduct152.maxProduct(new int[]{-3, -1, -1}));
    }
}
