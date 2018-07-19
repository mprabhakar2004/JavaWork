package com.manish.interview.practice.java8;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by manishkumar on 16-11-2016.
 */
public class Main {
    public static void main(String[] args) {

       int []rod = {26,103,59};


        System.out.println(maxProfit(1,10,rod));
    }

    static int maxProfit(int cost_per_cut, int metal_price, int lengths[]){
        int max= findMax(lengths);
        int maxProffit =0;
        for(int i=max;i>1;i--){
            int noc =0;
            for (int j=0;j<lengths.length;j++){
                noc += (lengths[j]/i);
            }
            int proffit= (noc * metal_price* i) - noc*cost_per_cut;
            if(maxProffit < proffit){
                maxProffit = proffit;
            }
        }
        return maxProffit;
    }
    static int findMax(int []arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }



    static float interpolate(int n, int quantity[], float []price){

        int index = Arrays.binarySearch(quantity,n);
        if(index >0){
            return price[index];
        }
        int closesetIndex [] = findCLosesetIndex(quantity,n);

        float linearInterpolate= price[closesetIndex[0]] - price[closesetIndex[1]];
        int quantityDiff = quantity[closesetIndex[1]]- quantity[closesetIndex[0]];

        float res = price[closesetIndex[1]] - linearInterpolate * ((float)(n-quantity[closesetIndex[1]])/(quantityDiff));
        if(res == 0.00f){
            for (int i=0;i< price.length ;i++){
                if(price[i]>0.0f){
                    res = price[i];
                    break;
                }
            }
        }
        return Math.round(res *100.0f)/100.0f;
    }

    private static int[] findCLosesetIndex(int[] quantity, int n) {

        int resArr[]=new int[2];
        int len= quantity.length;
        if (quantity[0] > n){
            resArr[0] = 0;
            resArr[1] = 1;
        }else if( quantity[len-1]<n){
            resArr[0] = len-2;
            resArr[1] = len-1;
        }
        return resArr;
    }


    static int moves(int a[]){
        int moves=0;
        int left = 0, right = a.length-1;
        while (left < right) {
            while (a[left]%2 == 0 && left < right) left++;
            while (a[right]%2 == 1 && left < right) right--;
            if (left < right) {
                moves++;
                swap(a, left, right);
                left++;
                right--;
            }
        }
        return moves;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int noOfMove(String []grid){

        char [][]gridArray = new char[grid.length][];
        for(int i=0;i<grid.length;i++){
            gridArray[i] = grid[i].toCharArray();
        }

        for(int i=0;i<3;i++){
            for (int j=0; j<4;j++){

            }
        }

        return 1;
    }

    static int Group(String []grid){

        char [][]gridArray = new char[grid.length][];
        for(int i=0;i<grid.length;i++){
            gridArray[i] = grid[i].toCharArray();
        }

        int totalFields = countFields(gridArray);
        return powerTwo(totalFields-1);
    }

    static public int powerTwo(int n) {
        int result=1;
        for(int i=0;i<n;i++) {
            result *= 2;
        }
        return result;
    }
    public static int countFields(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int count = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 'Y') {
                    count++;
                    process(matrix, i, j);
                }
            }
        }
        return count;
    }
    public static void process(char[][] matrix, int row, int col) {
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] == 'N') {
            return;
        }
        matrix[row][col] = 'N';
        int rowDir[] = {-1,0,1,0};
        int colDir[] = {0,1,0,-1};
        for (int i=0; i<rowDir.length; i++) {
            process(matrix, row + rowDir[i], col + colDir[i]);
        }
    }

}
