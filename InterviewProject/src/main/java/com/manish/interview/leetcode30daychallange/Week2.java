package com.manish.interview.leetcode30daychallange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

public class Week2 {
  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    node5.next = node6;
    node4.next = node5;
    node3.next = node4;
    node2.next = node3;
    node1.next = node2;

    //System.out.println(middleNode(node1).val);
    System.out.println(backspaceCompare("a#c", "c"));

    System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
//    System.out.println(lastStoneWeight(new int[]{3,1}));

    System.out.println(stringShift("abc", new int[][] { {0,1},{1,2}} ));
    System.out.println(stringShift("abcdefg", new int[][] { {1,1},{1,1}, {0,2}, {1,3}} ));

  }

  //region Day1
  public static ListNode middleNode(ListNode head) {
    ListNode p1, p2 = p1 = head;
    while (p2 != null) {
      if (p2.next == null) {
        break;
      }
      p2 = p2.next.next;
      p1 = p1.next;
    }
    return p1;
  }
//endregion

  //region Day2
  public static boolean backspaceCompare(String S, String T) {
    int i = S.length() - 1;
    int j = T.length() - 1;
    while (i >= 0 || j >= 0) {
      int c1 = 0;
      while (i >= 0 && (c1 > 0 || S.charAt(i) == '#')) {
        if (S.charAt(i) == '#') {
          c1++;
        } else {
          c1--;
        }
        i--;
      }
      int c2 = 0;
      while (j >= 0 && (c2 > 0 || T.charAt(j) == '#')) {
        if (T.charAt(j) == '#') {
          c2++;
        } else {
          c2--;
        }
        j--;
      }
      if (i >= 0 && j >= 0) {
        if (S.charAt(i) != T.charAt(j)) {
          return false;
        } else {
          i--;
          j--;
        }
      } else {
        if (i >= 0 || j >= 0) {
          return false;
        }
      }
    }
    return i < 0 && j < 0;
  }
//endregion

  //region Day 3
  class Elem {
    public int value;
    public int min;
    public Elem next;

    public Elem(int value, int min) {
      this.value = value;
      this.min = min;
    }
  }

  class MinStack {
    public Elem top;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
      if (top == null) {
        top = new Elem(x, x);
      } else {
        Elem e = new Elem(x, Math.min(x, top.min));
        e.next = top;
        top = e;
      }
    }

    public void pop() {
      if (top == null) {
        return;
      }
      Elem temp = top.next;
      top.next = null;
      top = temp;
    }

    public int top() {
      if (top == null) {
        return -1;
      }
      return top.value;
    }

    public int getMin() {
      if (top == null) {
        return -1;
      }
      return top.min;
    }
  }
  //endregion Day 3

  //region day 4
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  static int diameter(TreeNode root)
  {
    /* base case if tree is empty */
    if (root == null)
      return 0;

    /* get the height of left and right sub trees */
    int lheight = height(root.left);
    int rheight = height(root.right);

    /* get the diameter of left and right subtrees */
    int ldiameter = diameter(root.left);
    int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree */
    return Math.max(lheight + rheight,
        Math.max(ldiameter, rdiameter));

  }
  static int height(TreeNode node)
  {
    /* base case tree is empty */
    if (node == null)
      return 0;

        /* If tree is not empty then height = 1 + max of left
           height and right heights */
    return (1 + Math.max(height(node.left), height(node.right)));
  }
  //endregion

  //region day 5
  public static int lastStoneWeight(int[] stones) {
    List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());

    while (list.size()>1){
      int max1 = Integer.MIN_VALUE;
      int max2 = Integer.MIN_VALUE;
      int maxIdx, minIdx=maxIdx=0;
      for (int i=0;i< list.size();i++){

        if (max1 <= list.get(i)){
          max2 = max1;
          minIdx = maxIdx;
          max1 = list.get(i);
          maxIdx = i;
        }else if (max2 < list.get(i) && max1> list.get(i)) {
          max2 = list.get(i);
          minIdx = i;

        }


      }
      if (max1 == max2){
        list.remove(minIdx);
        list.remove(maxIdx-1);
      }else {


        list.remove(maxIdx);
        list.add(maxIdx , max1-max2);
        list.remove(minIdx);

      }
    }
    return list.size()==0?0:list.get(0);
  }
//endregion
  public static String stringShift(String s, int[][] shift) {
    for (int[] ints : shift) {

      int[] curElem = ints;
      if (curElem[0] == 0) {
        for (int j=0;j<curElem[1];j++)
          s = s.substring(1)+ (s.charAt(0));
      } else {
        for (int j=0;j<curElem[1];j++)
          s = s.charAt(s.length() - 1)+ s.substring( 0, s.length() - 1);
      }
    }
    return s;
  }
}

