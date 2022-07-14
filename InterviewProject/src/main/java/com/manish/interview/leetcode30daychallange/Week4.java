package com.manish.interview.leetcode30daychallange;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class Week4 {
  public static void main(String[] args) {
    FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
    System.out.println(firstUnique.showFirstUnique()); // return 2
    firstUnique.add(5);            // the queue is now [2,3,5,5]
    System.out.println(firstUnique.showFirstUnique()); // return 2
    firstUnique.add(2);            // the queue is now [2,3,5,5,2]
    System.out.println(firstUnique.showFirstUnique()); // return 3
    firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
    System.out.println(firstUnique.showFirstUnique()); // return -1
  }
  public static int subarraySum(int[] nums, int k) {
    int count = 0, sum = 0;
    HashMap< Integer, Integer > map = new HashMap< >();
    map.put(0, 1);
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k))
        count += map.get(sum - k);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
  public int rangeBitwiseAnd(int m, int n) {
    while (n > m) {
      n = n & n - 1;
    }
    return m & n;
  }


}

class FirstUnique {
  Set<Integer> all = new HashSet<>();
  Set<Integer> unique = new LinkedHashSet<>();
  public FirstUnique(int[] nums) {
      for (int num:nums){
        add(num);
      }
  }

  public int showFirstUnique() {
    if (unique.isEmpty())
      return -1;
    return unique.iterator().next();
  }

  public void add(int value) {
    if (all.add(value)){
      unique.add(value);
    }else {
      unique.remove(value);
    }
  }
}