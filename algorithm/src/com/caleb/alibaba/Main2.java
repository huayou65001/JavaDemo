package com.caleb.alibaba;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:Caleb
 * @Date :2021-08-09 19:25:56
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] x = new int[n];
			for(int i = 0;i<n;i++){
				x[i] = sc.nextInt();
			}
			Set<Integer> set = new HashSet<>();
			for(int i = 0;i<n;i++){
				int l = 0;

				for(int j = i;j<n;j++){
					l += x[j];
					set.add(l);
				}
			}
			int max = set.stream().max(Integer::compareTo).orElse(0);
			System.out.println(max == set.size() ? "Yes" : "No");
		}
		sc.close();
	}

}