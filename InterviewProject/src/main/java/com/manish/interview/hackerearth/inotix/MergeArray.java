package com.manish.interview.hackerearth.inotix;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int [] a= {5,6,7,7};
        int []b= {0,1,2,3};
        System.out.println(Arrays.toString(mergeArrays(a,b )));
    }
    static int[] mergeArrays(int[] a, int[] b) {
        int [] res = new int[a.length + b.length];
        int i=0,j=0,k=0;
        while (i<a.length && j<b.length){
            if(a[i] < b[j]){
                res[k++] = a[i++];
            }else if(a[i] > b[j]){
                res[k++] = b[j++];
            }else {
                res[k++] = a[i++];
                res[k++] = b[j++];
            }
        }
        while (i<a.length){
            res[k++] = a[i++];
       }
        while (j<a.length){
            res[k++] = b[j++];
        }
        return res;
    }
}
