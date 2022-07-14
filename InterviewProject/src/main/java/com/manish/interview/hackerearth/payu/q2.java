package com.manish.interview.hackerearth.payu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Manishkumar
 * @since 08/06/2017.
 */
public class q2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int []arr = new int[N];
		int max=0;
		for (int j = 0; j < N; j++) {
			arr[j] = in.nextInt();
			if (max<arr[j]) max = arr[j];
		}
		solve(arr, max);

	}

	private static void solve(int[] arr, int max) {
		int n = max;
		long sum=0;
		long powOf31 = 1;
		for (int j = 0; j <= n; j++) {
			sum += getLargestSubsetWithXORValue(arr,j) * powOf31;
			powOf31*=31;
		}
		System.out.println(sum % 10000000007l);
	}

	private static int getLargestSubsetWithXORValue(int[] arr, int k) {
		int maxSizeArray=0;
		for (int i=0;i< (1<< arr.length);i++){
			List<Integer> tempArr = new ArrayList<>();
			for (int j=0;j<arr.length;j++){
				if( (i & (1<<j))>0){
					tempArr.add(arr[j]);
				}
			}
			int sum=0;
			for (Integer val:tempArr){
				sum ^=val;
			}
			if (sum ==k){
				if (maxSizeArray< tempArr.size()){
					maxSizeArray = tempArr.size();
				}
			}
		}
		return maxSizeArray;
	}
}
