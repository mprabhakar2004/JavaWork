package com.manish.interview.leetcode30daychallange;

import java.util.HashMap;
import java.util.Stack;


public class Week3 {
  public static void main(String[] args) {
//    System.out.println(Arrays.toString(productExceptSelf(new int[]{0, 1})));
//    System.out.println(checkValidString("(*))"));

    System.out.println(minPathSumDynamic(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
  }

  //search in rotated array
  public static int search(int[] nums, int target) {
    int left = 0;
    int right= nums.length-1;
    while(left<=right){
      int mid = left + (right-left)/2;
      if(target==nums[mid])
        return mid;
      if(nums[left]<=nums[mid]){
        if(nums[left]<=target&& target<nums[mid]){
          right=mid-1;
        }else{
          left=mid+1;
        }
      }else{
        if(nums[mid]<target&& target<=nums[right]){
          left=mid+1;
        }else{
          right=mid-1;
        }
      }
    }
    return -1;
  }
  public static int minPathSumDynamic(int[][] grid) {
    if(grid == null || grid.length==0)
      return 0;
    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[m][n];
    dp[0][0] = grid[0][0];
    // initialize top row
    for(int i=1; i<n; i++){
      dp[0][i] = dp[0][i-1] + grid[0][i];
    }
// initialize left column
    for(int j=1; j<m; j++){
      dp[j][0] = dp[j-1][0] + grid[j][0];
    }
// fill up the dp table
    for(int i=1; i<m; i++){
      for(int j=1; j<n; j++){
        if(dp[i-1][j] > dp[i][j-1]){
          dp[i][j] = dp[i][j-1] + grid[i][j];
        }else{
          dp[i][j] = dp[i-1][j] + grid[i][j];
        }
      }
    }
    return dp[m-1][n-1];
  }
  public static int minPathSum(int[][] grid) {
    return dfs(0, 0, grid);
  }

  // Minimum Path Sum : Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
  //which minimizes the sum of all numbers along its path.
  public static int dfs(int i, int j, int[][] grid) {
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return grid[i][j];
    }
    if (i < grid.length - 1 && j < grid[0].length - 1) {
      int r1 = grid[i][j] + dfs(i + 1, j, grid);
      int r2 = grid[i][j] + dfs(i, j + 1, grid);
      return Math.min(r1, r2);
    }
    if (i < grid.length - 1) {
      return grid[i][j] + dfs(i + 1, j, grid);
    }
    if (j < grid[0].length - 1) {
      return grid[i][j] + dfs(i, j + 1, grid);
    }
    return 0;
  }

  public static int[] productExceptSelf(int[] nums) {
    int[] res = new int[nums.length];
    int p = 1;
    for (int i = 0; i < nums.length; i++) {
      res[i] = p;
      p = p * nums[i];
    }
    p = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] = p * res[i];
      p = p * nums[i];
    }
    return res;
  }


  public static boolean checkValidString(String s) {
    Stack<Integer> pair = new Stack<>();
    Stack<Integer> star = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        pair.push(i);
      } else if (ch == '*') {
        star.push(i);
      } else {
        if (!pair.isEmpty()) {
          pair.pop();
        } else if (!star.isEmpty()) {
          star.pop();
        } else {
          return false;
        }
      }
    }
    return isBalanced(pair, star);
  }

  private static boolean isBalanced(Stack<Integer> pair, Stack<Integer> star) {
    while (!pair.isEmpty()) {
      if (star.isEmpty()) {
        return false;
      } else if (star.peek() > pair.peek()) {
        star.pop();
        pair.pop();
      } else {
        return false;
      }
    }
    return true;
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          count++;
          merge(grid, i, j);
        }
      }
    }
    return count;
  }

  public void merge(char[][] grid, int i, int j) {
    int m = grid.length;
    int n = grid[0].length;
    if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
      return;
    }
    grid[i][j] = 'X';
    merge(grid, i - 1, j);
    merge(grid, i + 1, j);
    merge(grid, i, j - 1);
    merge(grid, i, j + 1);
  }


}
