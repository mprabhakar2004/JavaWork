package com.home.hackerearth.serionlabs;


import java.util.*;

public class Test {

    public static void main(String[] args) {

        int [] ar = {0,1,1,0,1,0,1};
//        ar[2] = 1;
//        ar[3]  =1;
//        System.out.println(findMaxArray(ar)); // 0 1 1 0 0 0 0
//        ar[4] = 1;
//        System.out.println(findMaxArray(ar)); // 0 1 1 0 1 0 0
//        ar[6] =1;
        System.out.println(findMaxArray(ar)); // 0 1 1 0 1 0 1


    }

    private static int findMaxArray(int[] ar) {
        int i=0,j=1;
        int maxLength = 0;
        int minIndex = 0;
        boolean flag= false;

        for (i=0,j=1;j<ar.length ;i++,j++){
            if(ar[i]==ar[j]){
                if(maxLength < (j-minIndex) && !flag)
                    maxLength = j-minIndex;
                minIndex = 0;
                flag= true;
            }else {
                if (minIndex ==0) {
                    minIndex = i;
                    flag = false;
                }
            }
        }
        if (maxLength < (j-minIndex ) && !flag)
            maxLength = j-minIndex ;
        return maxLength;
    }

}
