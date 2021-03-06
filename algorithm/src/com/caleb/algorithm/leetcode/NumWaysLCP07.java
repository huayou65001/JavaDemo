package com.caleb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author:Caleb
 * @Date :2021-07-01 09:44:12
 * 
 *       传递信息
 * 
 *       小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 *       每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A
 *       传信息）。每轮信息必须需要传递给另一个人，且信息可重复经过同一个人 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号]
 *       关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回
 *       0。
 * 
 */
public class NumWaysLCP07 {

	public int numWays(int n, int[][] relation, int k) {
		if (relation.length < k) {
			return 0;
		}
		// 建立伙伴传递信息对应关系
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < relation.length; i++) {
			List<Integer> rel = map.getOrDefault(relation[i][0], new ArrayList<Integer>());
			rel.add(relation[i][1]);
			map.put(relation[i][0], rel);
		}
		int planCount = 0;
		// 进行广度优先遍历
		Queue<Integer> que = new LinkedList<>();
		que.addAll(map.get(0));
		for (int i = 1; i < k + 1; i++) {
			int size = que.size();
			while (!que.isEmpty() && size > 0) {
				int nextMate = que.poll();
				if (i == k) {
					if (nextMate == n - 1) {
						planCount++;
					}
				} else {
					que.addAll(map.getOrDefault(nextMate, new ArrayList<Integer>()));
				}
				size--;
			}
		}
		return planCount;
	}

	public int numWays1(int n, int[][] relation, int k) {
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 0; i < k; i++) {
			int[] next = new int[n];
			for (int j = 0; j < relation.length; j++) {
				next[relation[j][1]] += dp[relation[j][0]];
			}
			dp = next;
		}
		return dp[n - 1];
	}

	public static void main(String[] args) {
		int[][] relation = { { 0, 2 }, { 2, 1 }, { 3, 4 }, { 2, 3 }, { 1, 4 }, { 2, 0 }, { 0, 4 } };
		NumWaysLCP07 n = new NumWaysLCP07();
		System.out.println(n.numWays1(5, relation, 3));
	}

}