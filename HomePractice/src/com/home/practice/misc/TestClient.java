package com.home.practice.misc;

import com.home.practice.linkedlist.MyLinkedList;
import com.home.practice.linkedlist.Node;

import java.util.*;

class A{
	int a;
	int b;

	public A(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "A{" +
				"a=" + a +
				", b=" + b +
				'}';
	}
}
public class TestClient {
	public static void main(String[] args) {
		final int []ar = {100,100,50,40,40,20,10};
		final int []alice = {5,25,50,120};
        preProcessScoreArray(ar);
        System.out.println(Arrays.toString(climbingLeaderboard(ar,alice)));
	}

    static List<Integer> uniqueScoreList = new ArrayList<Integer>();
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            int j=0;
            for (; j < uniqueScoreList.size(); j++) {
                if (alice[i]>= uniqueScoreList.get(j)){
                    break;
                }
            }
            res[i] = j+1;
        }
        return res;
    }

    static void preProcessScoreArray(int []scores){
        int currentElement = scores[0];
        for(int i=1;i<scores.length;i++){
            if(currentElement != scores[i]){
                uniqueScoreList.add(currentElement);
                currentElement = scores[i];
            }
        }
        uniqueScoreList.add(currentElement);

        System.out.println(Arrays.toString(uniqueScoreList.toArray()));
    }

    static int[] climbingLeaderboard1(int[] scores, int[] alice) {
        int []res = new int[alice.length];

        return res;
    }
	private static void changeMe(final A a) {
		a.a= 30;
	}
}
