package com.manish.interview.practice.misc;

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


    }

    static void minimumBribes(int[] q) {
        int sum = 0;
        int count=0;
        int []minArr = new int[q.length];

        for(int i=0;i<q.length-1;i++){
            count = 0;
            for (int j=i+1;j<q.length;j++){
                if(q[i]>q[j]){
                    count++;
                }
            }
            minArr[i] = count;
        }

        for (int i=0;i<minArr.length;i++){
            if(minArr[i]<=2){
                sum+=minArr[i];
            }else{
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(sum);
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
