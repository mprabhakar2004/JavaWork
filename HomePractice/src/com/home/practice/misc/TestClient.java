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
//		Scanner in = new Scanner(System.in);
//        Scanner in1 = new Scanner(System.in);

//		String s =  in.nextLine();
//		isPanagram(s);
//        System.out.print(removeDuplicateChars("ammanisha"));
//
//        Queue<Integer> queue = new LinkedList<Integer>();
//        queue.offer(1);
//        queue.offer(2);
//        System.out.print(queue);
//        int a =in.nextInt();
//        double b= in.nextDouble();
//        in.reset();
//        String s = in1.nextLine();
//        System.out.println(s);
//        System.out.println(b);
//        System.out.println(a);

//        System.out.print(s);
        String []sar = new String[5];
        Arrays.fill(sar, "");
        System.out.print(sar);

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
}
