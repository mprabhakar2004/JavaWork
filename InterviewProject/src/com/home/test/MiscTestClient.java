package com.home.test;

import com.home.hackerearth.timeinc.Test;

import java.util.Arrays;

/**
 * Created by manishkumar on 10-01-2017.
 */

class TestAbst{
    public int a=1;
    TestAbst(){}
    public void fun(){

    }
    public void fun(String s){
        System.out.println("string");
    }
    public void fun(Integer s){
        System.out.println("string");
    }

    public void fun(Object o){
        System.out.println("objetc");
    }
}

class TestAbst1 extends TestAbst{

public int a=2;
}
public class MiscTestClient {
    public static void main(String[] args) {
        TestAbst obj=new TestAbst1();
        //obj.fun(null);
        System.out.println(((TestAbst1)obj).a);
        int [] ar1={3,4,6,8};
        int [] ar2 = {1,2,5};
        merge(ar1,ar2);
        System.out.println(Arrays.toString(ar1));
        System.out.println(Arrays.toString(ar2));
        System.out.println(countWays(6));

    }

    private static int binarySearch(int[] ints, int searchElm) {
        int left = 0;
        int right = ints.length-1;
        while (left <=right){
            int midIdx = (left+right)>>1;
            int midElm = ints[midIdx];
            if (midElm == searchElm)
                return midIdx;
            else if(midElm> searchElm)
                right = midIdx-1;
            else
                left = midIdx +1;
        }
        return -(left + 1);
    }

    public static void merge(int ar1[],int ar2[]){
        int i=0;
        int j=0;
        for(;i<ar1.length;i++){
            if(ar1[i] > ar2[j]){
                int temp = ar1[i];
                ar1[i] = ar2[j];
                ar2 [j] = temp;
            }
        }
    }

    public static int countWays(int n){
        if(n==1 || n==2){
            return n;
        }
        return countWays(n-1) + countWays(n-2);
    }
}
