package com.home.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.InputMismatchException;

import static java.lang.Math.abs;

/**
 * Created by manishkumar on 03-01-2017.
 */
/* 1. Arrange postive and negative alternatively
   2. Stack with two queue and viceversa
   3. Number of inversions in an Array
   4. Multiply two big number
  */
public class ArrayProblem {
    public static void main(String[] args) {
        ArrayList<Integer> arr =new ArrayList<Integer>( Arrays.asList(55, -8, 43, 52, 8, 59, -91, -79, -18, -94) );

        System.out.println(maxABSDiffInArray(arr));
    }

    public static int maxABSDiffInArray(ArrayList<Integer> A) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int minIdx,maxIdx=minIdx=1;
        for(int i=0;i<A.size();i++){
            if (max<= A.get(i)){
                max= A.get(i);
                maxIdx = i+1;
            }
            if (min>A.get(i)){
                min = A.get(i);
                minIdx = i+1;
            }
        }
        return abs(max-min) + abs(maxIdx-minIdx);
    }

    public static int maxABSDiffInArray1(ArrayList<Integer> A) {
        int sum = 0;
        for (int i = 1; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                if (sum < abs(A.get(i) - A.get(j)) + abs(i - j))
                    sum = abs(A.get(i) - A.get(j)) + abs(i - j);
            }

        }
        return sum;
    }

}
