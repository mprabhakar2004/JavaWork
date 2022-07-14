package com.manish.interview.leetcode30daychallange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Week1 {
  public static void main(String[] args) {
    System.out.println(singleNumber(new int[]{4, 5, 5, 2, 2, 1, 1, 3, 3}));
    System.out.println(isHappy(18));
    System.out.println(maximumSum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    int[] nums = new int[]{0, 1, 0, 3, 12};
    moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
    System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));

    System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    System.out.println(countElements(new int[]{1,1,3,3,5,5,7,7}));
  }

  public static int singleNumber(int[] arr) {
    int uniqueNum = 0;
    for (int value : arr) {
      uniqueNum ^= value;
    }

    return uniqueNum;
  }

  // day2
  public static boolean isHappy(int n) {

    int sum = 0;
    HashSet<Integer> numSeen = new HashSet<>();
    while (!numSeen.contains(n)) {
      sum = 0;
      numSeen.add(n);
      while (n > 0) {
        int rem = n % 10;
        n /= 10;
        sum += rem * rem;
      }
      if (sum == 1) {
        return true;
      }
      n = sum;
    }
    return false;
  }

  // Day3
  public static int maximumSum(int[] nums) {
    int maxSum = Integer.MIN_VALUE, sumTillHere = 0;
    for (int num : nums) {
      sumTillHere += num;
      if (maxSum < sumTillHere) {
        maxSum = sumTillHere;
      }
      if (sumTillHere < 0) {
        sumTillHere = 0;
      }
    }
    return maxSum;
  }

  //Day4
  public static void moveZeroes(int[] nums) {
    int j = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[j++] = nums[i];
      }
    }
    while (j < nums.length) {
      nums[j++] = 0;
    }
  }

  //Day5
  public static int maxProfit(int[] prices) {
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
      int diff = prices[i] - prices[i - 1];
      if (diff > 0) {
        profit += diff;
      }
    }
    return profit;
  }

  //Day6
  public static List<List<String>> groupAnagrams(String[] strs) {
    LinkedHashMap<String, ArrayList<String>> res = new LinkedHashMap<>();
    for (String str : strs) {
      char[] strArr = str.toCharArray();
      Arrays.sort(strArr);
      String curStr = new String(strArr);
//      char[] arr = new char[26];
//      for(int i=0; i<str.length(); i++){    // Second approach
//        arr[str.charAt(i)-'a']++;
//      }
//      String ns = new String(arr);
      ArrayList<String> val = res.get(curStr);
      if (val == null) {
        val = new ArrayList<>();
      }
      val.add(str);
      res.put(curStr, val);

//      if (!ans.containsKey(key)) ans.put(key, new ArrayList());   // second approach
//      ans.get(key).add(s);
    }
    return res.values().stream().collect(Collectors.toList()); // new ArrayList(res.values())
  }

  //Day7
  public static int countElements(int[] arr) {
    int count = 0;
    Set<Integer> nums = new HashSet<>();
    for (int elem:arr){
      nums.add(elem);
    }
    for (int elem:arr){
      if (nums.contains(elem+1)){
        count++;
      }
    }
    return count;
  }
}