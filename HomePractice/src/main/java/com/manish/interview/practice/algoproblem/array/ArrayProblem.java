package com.manish.interview.practice.algoproblem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
        int [] ar = new int[]{1,1,1,0,0};

        //System.out.println(minimumSwapRequiredToMake1Together(ar));

        spiralTraversal(new int[][]{{1,2,3,4,111},{5,6,7,8,112},{9,10,11,12,113},{13,14,15,16,114},{17,18,19,20,21}});
        System.out.println("");
        spiralTraversalAntiClockWise(new int[][]{{1,2,3,4,111},{5,6,7,8,112},{9,10,11,12,113},{13,14,15,16,114},{17,18,19,20,21}});
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

    /**
     * Given an array of 0’s and 1’s. Need to tell minimum number of swaps
     * required to take all 1’s to one side. Only adjacent swap is allowed.
     *
     * Algorithm :
     *      1. Count no. of 1 in array => X
     *      2. Find subarray of length X having max no. of 1 in it.
     *          2.1 Create pre-compute array oneCountArray where oneCountArray[i] = no. of 1 in oneCountArray[0..i]
     *          2.2 Find no. of 1 in subarray of length X using sliding window
     *              noOfOneInSubArray = oneCountArray[i] - oneCountArray[i-X]
     *          2.3 Find max among them
     *      3. Count no. of 0 in subarray.
     *          noOf0 = X- maxNoOfOneInSubArray
     *
     *
     * @param ar
     * @return
     */
    public static int minimumSwapRequiredToMake1Together(int []ar){

        int noOfOne = 0;
        for (int i=0;i<ar.length;i++){
            if (ar[i] ==1){
                noOfOne ++;
            }
        }
        //Will use sliding window approach with length noOfOne to count the max 1 in sub array
        // First create a pre-compute array to find out max 1 till index i

        int []oneCountArray = new int[ar.length];
        oneCountArray[0] = ar[0];
        for (int i=1;i<ar.length ;i ++){
            if (ar[i]==1){
                oneCountArray[i] = oneCountArray[i-1] +1;
            }else {
                oneCountArray[i] = oneCountArray[i-1];
            }
        }

        int noOfOneInSubarray,maxOneInSubArray=noOfOneInSubarray = oneCountArray[noOfOne-1];
        for (int i=noOfOne;i<ar.length;i++){
            noOfOneInSubarray = oneCountArray[i] - oneCountArray[i-noOfOne];
            if (maxOneInSubArray< noOfOneInSubarray){
                maxOneInSubArray = noOfOneInSubarray;
            }
        }
        return noOfOne - maxOneInSubArray;
    }

    /**
     *  1   2   3   4   111
     *  5   6   7   8   112
     *  9   10  11  12  113
     *  13  14  15  16  114
     *  17  18  19  20  21
     *
     *
     * @param ar
     */
    static  void spiralTraversal(int [][]ar){
        int minCol = 0,maxCol = ar[0].length-1;
        int minRow = 0,maxRow = ar.length-1;

        while (minCol<=maxCol && minRow<=maxRow){
            // -------->
            for(int i=minCol; i<=maxCol;i++){
                System.out.print(ar[minRow][i] + "  ");
            }
            minRow++;
            /**
             *      |
             *      |
             *      |
             */
            for (int i=minRow;i<=maxRow;i++){
                System.out.print(ar[i][maxCol] + "  ");
            }
            maxCol--;
            //<---------
            for (int i=maxCol;i>=minCol;i--){
                System.out.print(ar[maxRow][i] + "  ");
            }
            maxRow--;
            /**
             *      ^
             *      |
             *      |
             */

            for (int i = maxRow;i>=minRow ; i--){
                System.out.print(ar[i][minCol] + "  ");
            }
            minCol++;
        }
    }


    /**
     *  1   2   3   4   111
     *  5   6   7   8   112
     *  9   10  11  12  113
     *  13  14  15  16  114
     *  17  18  19  20  21
     *
     *
     * @param ar
     */
    static  void spiralTraversalAntiClockWise(int [][]ar){
        int minCol = 0,maxCol = ar[0].length-1;
        int minRow = 0,maxRow = ar.length-1;

        while (minCol<=maxCol && minRow<=maxRow){

            /**
             *      |
             *      |
             *      |
             *      \/
             */
            for (int i=minRow;i<=maxRow;i++){
                System.out.print(ar[i][minCol] + "  ");
            }
            minCol++;

            // -------->
            for(int i=minCol; i<=maxCol;i++){
                System.out.print(ar[maxRow][i] + "  ");
            }
            maxRow--;

            /**
             *      ^
             *      |
             *      |
             */

            for (int i = maxRow;i>=minRow ; i--){
                System.out.print(ar[i][maxCol] + "  ");
            }
            maxCol--;

            //<---------
            for (int i=maxCol;i>=minCol;i--){
                System.out.print(ar[minRow][i] + "  ");
            }
            minRow++;

        }
    }

}
