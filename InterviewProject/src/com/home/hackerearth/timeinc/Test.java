package com.home.hackerearth.timeinc;

import java.util.Arrays;

/**
 * Created by Manishkumar on 15-02-2017.
 */
public class Test {

    public static void main(String[] args) {
        int []ar = {1,-1,3,2,-7,-5,11,6};
        System.out.println(Arrays.toString(pushback(ar)));
    }

    private static int [] pushback(int[] ar) {
        int res[] = new int[ar.length];
        int j=ar.length-1;
        for (int i=ar.length-1;i>=0;i--){
            if(ar[i]<0){
                res[j--] = ar[i];
            }
        }
        for (int i=ar.length-1;i>=0;i--){
            if(ar[i]>0){
                res[j--] = ar[i];
            }
        }
        return res;
    }
}
