package com.home.hackerearth.greytrip;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        System.out.println("hello");
        int []ar={0,4};

        System.out.println(Arrays.toString(happyArray(2,ar)));

    }

    private static int [] happyArray(int n, int []ar){
        int []res =new int[n];
        for (int i=0;i<n;i++){
            res[i] = isHappyNumber(ar[i]);
        }
        return res;
    }

    private static int isHappyNumber(int num) {
        int temp =Math.abs(num);
        while (temp>3){
            int sum = 0;
            while (temp>0){
                sum += (temp%10) * (temp%10);
                temp = temp/10;
            }
            temp = sum;
        }
        if (temp==1)
            return temp;
        else
            return 0;
    }

}
