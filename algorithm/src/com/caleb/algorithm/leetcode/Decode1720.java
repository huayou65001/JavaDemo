package com.caleb.algorithm.leetcode;

/**
 * 解码异或后的数组
 * 未知 整数数组 arr 由 n 个非负整数组成。
 * 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。
 * 例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
 * 给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
 * 请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
 *
 * @author：hanzhigang
 * @Date : 2021/4/4 11:52 PM
 */
public class Decode1720 {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length+1];
        res[0] = first;
        for(int i = 1;i<encoded.length+1;i++){
            res[i] = res[i-1] ^ encoded[i-1];
        }
        return res;
    }
}
