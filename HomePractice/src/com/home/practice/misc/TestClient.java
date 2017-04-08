package com.home.practice.misc;

import com.home.practice.linkedlist.MyLinkedList;
import com.home.practice.linkedlist.Node;

import java.util.*;

public class TestClient {
	static int solveMeFirst(int a, int b) {
		return a + b;
	}

	static long sumOfArray(int n, Scanner in) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += in.nextInt();
		}
		return sum;
	}

	/**
	 * 1 2 3 4 5 6 7 8 9
	 * 
	 * @param n
	 * @param in
	 * @return
	 */

	static long absdiff(int n, Scanner in) {
		int[][] ar = new int[n][n];
		long diff = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ar[i][j] = in.nextInt();
			}
		}
		
		long sum1, sum2 = sum1 = 0;
		for (int i = 0; i < n; i++) {
			sum1 += ar[i][i];
			sum2 += ar[i][n - i - 1];
		}
		diff = sum1 - sum2;
		return diff > 0 ? diff : -1 * diff;
	}
	static void isPanagram(String s){
		boolean []panagram = new boolean[26];
		char []sarr = s.toUpperCase().toCharArray();
		for(char ch:sarr){
			if(ch>=65 && ch<=90)
				panagram[ch-65] = true;
		}
		boolean p=true;
		for (boolean b : panagram) {
			p &=b;
		}
		if(p)
			System.out.println("pangram");
		else System.out.println("not pangram");
	}

	public static void main(String[] args) {

		System.out.println(shortestPal("abab"));
	}

    static String removeDuplicateChars(String userKeyword){

        int charLength = userKeyword.length();
        String modifiedKeyword="";
        for(int i=0;i<charLength;i++)
        {
            if(!modifiedKeyword.contains(userKeyword.charAt(i)+""))
                modifiedKeyword+=userKeyword.charAt(i);
        }
        return modifiedKeyword;
    }

	public  static String shortestPal(String s)
	{
		String rev_s = new StringBuilder(s).reverse().toString();
		//use special character to avoid overlap
		String l = s + "#" + rev_s;

		int[] p = new int[l.length()];

		//build KMP table.
		//i -> suffix boundary
		//j -> prefix boundary


		for(int i=1; i<l.length(); i++)
		{
			//update prefix boundary to previous match position
			int j = p[i-1];

			//move to the last prefix boundary match
			while(j>0 && l.charAt(i)!=l.charAt(j))
				j = p[j-1];

			//if prefix boundary matches suffix boundary,
			//increase prefix length
			if(l.charAt(i) == l.charAt(j)) p[i] = j + 1;
		}

		return rev_s.substring(0, s.length() - p[l.length() - 1]) + s;
	}
}
