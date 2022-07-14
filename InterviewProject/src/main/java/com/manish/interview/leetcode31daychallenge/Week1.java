package com.manish.interview.leetcode31daychallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Integer.*;


public class Week1 {
  public static void main(String[] args) {
    System.out.println(numJewelsInStones("z", "ZZ"));
    System.out.println(canConstruct("a", "b"));
    System.out.println(findComplement(5));
    System.out.println(checkInclusion("adc", "dcda"));
    System.out.println(frequencySort("tree"));
    System.out.println(toKeyVaultSecretName("test.key-value"));
    System.out.println(toKeyVaultSecretName("test-key-value"));
  }

  private static String toKeyVaultSecretName(String property) {
    if (property.matches("[a-z0-9A-Z-]+")) {
      return property.toLowerCase(Locale.US);
    } else if (property.matches("[A-Z0-9_]+")) {
      return property.toLowerCase(Locale.US).replaceAll("_", "-");
    } else {
      return property.toLowerCase(Locale.US)
          .replaceAll("-", "")     // my-project -> myproject
          .replaceAll("_", "")     // my_project -> myproject
          .replaceAll("\\.", "-"); // acme.myproject -> acme-myproject
    }
  }

  /**
   * Given a string, sort it in decreasing order based on the frequency of characters.
   *
   * Input:
   * "tree"
   *
   * Output:
   * "eert"
   *
   * Explanation:
   * 'e' appears twice while 'r' and 't' both appear once.
   * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
   * @param s
   * @return
   */
  public static String frequencySort(String s) {
    List<Character>[] buckets = new List[s.length() + 1];
    Map<Character, Integer> map = new HashMap<>();

    for(char c : s.toCharArray()) map.merge(c, 1, Integer::sum);

    map.forEach((ch, freq) -> {
      if(buckets[freq] == null) buckets[freq] = new ArrayList<>();
      for(int i=0 ; i<freq ; ++i) buckets[freq].add(ch);
    });

    return new StringBuilder(Arrays.stream(buckets)
        .filter(Objects::nonNull) // exclode the null (empty) buckets
        .flatMap(List::stream) // Stream<List<Character>> to Stream<Character>
        .map(String::valueOf) // chars to strings
        .collect(Collectors.joining())) // join the strings together
        .reverse() // as we want the more frequent first
        .toString();
  }

  /**
   * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
   *
   * @param matrix
   * @return
   */
  public static int countSquares(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int [][] dp = new int[m][n];
    int ans = 0;
    for (int i = 0; i < m; ++i)
      for (int j = 0; j < n; ++j) {
        dp[i][j] = matrix[i][j];
        if (i!=0 && j!=0 && dp[i][j]!=0)
          dp[i][j] = min(min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
        ans += dp[i][j];
      }
    return ans;
  }
  /**
   * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words,
   * one of the first string's permutations is the substring of the second string.
   *
   * Input: s1 = "ab" s2 = "eidbaooo"
   * Output: True
   * Explanation: s2 contains one permutation of s1 ("ba").
   *
   * @param s1
   * @param s2
   * @return
   */
  public static boolean checkInclusion(String s1, String s2) {
    int asciiHash = calculateAsciiHash(s1);
    for (int i = 0; i < s2.length() - s1.length()+1; i++) {
      String sub = s2.substring(i, i+s1.length());
      if (asciiHash == calculateAsciiHash(sub)) {
        return true;
      }
    }

    return false;
  }

  private static int calculateAsciiHash(String s1) {
    int res = 0;
    for (char ch : s1.toCharArray()) {
      res += ch;
    }
    return res;
  }

  /**
   *Q2. You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
   * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
   * @param J
   * @param S
   * @return
   */
  public static int numJewelsInStones(String J, String S) {
    int cnt = 0;
    int[] jwels = new int[256];
    for (char ch : J.toCharArray()) {
      jwels[ch] = 1;
    }
    for (char ch : S.toCharArray()) {
      if (jwels[ch] == 1) {
        cnt++;
      }
    }
    return cnt;
  }

  /***
   * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function
   * that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
   *
   * Each letter in the magazine string can only be used once in your ransom note.
   *
   * Note:
   * You may assume that both strings contain only lowercase letters.
   *
   * canConstruct("a", "b") -> false
   * canConstruct("aa", "ab") -> false
   * canConstruct("aa", "aab") -> true
   */
  public static boolean canConstruct(String ransomNote, String magazine) {
    int[] charCnt = new int[256];
    for (char ch : magazine.toCharArray()) {
      charCnt[ch]++;
    }
    for (char ch : ransomNote.toCharArray()) {
      if (charCnt[ch] == 0) {
        return false;
      }
      charCnt[ch]--;
    }
    return true;
  }

  /**
   * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
   */
  public static int findComplement(int num) {
    // Number of bits in number
    int cnt = (int) (Math.floor(Math.log(num) / Math.log(2))) + 1;
    return num ^ ((1 << cnt) - 1);
  }

  static int countBits(int n) {
    int count = 0;
    while (n != 0) {
      count++;
      n >>= 1;
    }

    return count;
  }

  static int countSetBits(int n) {
    int count = 0;
//    while (n > 0) {
//      n &= (n - 1);
//      count++;
//    }
    while (n > 0) {
      count += n & 1;
      n >>= 1;
    }
    return count;
  }

  /**
   * Q1. You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest
   * version of your product fails the quality check. Since each version is developed based on the previous version,
   * all the versions after a bad version are also bad.
   * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
   * find the first bad version. You should minimize the number of calls to the API.
   * @param n
   * @return
   */

  public int firstBadVersion(int n) {
    return helper(1, n);
  }

  public int helper(int i, int j) {
    int m = i + (j - i) / 2;

    if (i >= j) {
      return i;
    }

    if (isBadVersion(m)) {
      return helper(i, m);
    } else {
      return helper(m + 1, j); //not bad, left --> m+1
    }
  }

  // placeholder method
  private boolean isBadVersion(int m) {
    return true;
  }

  public int maxSubarraySumCircular(int[] a) {
    int sum = 0, mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE, curMax = 0, curMin = 0;
    for (int num : a) {
      curMin = min(curMin + num, num);
      mn = min(mn, curMin);
      curMax = Integer.max(curMax + num, num);
      mx = Integer.max(mx, curMax);
      sum += num;
    }
    return (sum - mn == 0) ? mx : Integer.max(mx, sum - mn);
  }

  /**
   * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
   *
   * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
   *
   * The order of output does not matter.
   * Input:
   * s: "cbaebabacd" p: "abc"
   *
   * Output:
   * [0, 6]
   *
   * Explanation:
   * The substring with start index = 0 is "cba", which is an anagram of "abc".
   * The substring with start index = 6 is "bac", which is an anagram of "abc".
   * @param s
   * @param p
   * @return
   */
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> rst = new ArrayList<>();
    if (s == null || s.length() == 0 || s.length() < p.length()) {
      return rst;
    }

    int[] map_p = new int[26];
    for (int i = 0; i < p.length(); i++) {
      map_p[p.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s.length() - p.length() + 1; i++) {
      int[] map_s = new int[26];
      for (int j = 0; j < p.length(); j++) {
        map_s[s.charAt(i + j) - 'a']++;
      }
      if (isMatch(map_p, map_s)) {
        rst.add(i);
      }
    }
    return rst;
  }

  public boolean isMatch(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }
}
