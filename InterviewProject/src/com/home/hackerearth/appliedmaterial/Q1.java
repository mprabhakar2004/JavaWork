package com.home.hackerearth.appliedmaterial;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        int n,k;
        Scanner in = new Scanner(System.in);
        k= in.nextInt();
        n = in.nextInt();
        int []arr = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }

        System.out.println(isPossibleToMakePrime(arr,k)?1:0);
    }

    private static boolean isPossibleToMakePrime(int[] arr, int k) {
        for (int i=0;i<arr.length-k;i++){
            int first = arr[i];
            int second = arr[i+k];

            int temp1 = first;
            int temp2= second;
            while (first>1 && !(prime(first) && prime(second))){
                first --;
                second ++;
            }

            if (prime(first) && prime(second)){
                arr[i] = first;
                arr[i+k] = second;

            }else {

                first = temp1;
                second = temp2;
                while (second > 1 && !(prime(first) && prime(second))) {
                    first++;
                    second--;
                }
                if (prime(first) && prime(second)) {
                    arr[i] = first;
                    arr[i + k] = second;
                }
            }
        }

        for (int i=0;i<arr.length;i++){
            if(!prime(arr[i]))
                return false;
        }
        return true;
    }

    private static boolean prime(int first) {
        if(first<2) return false;
        for(int i=2;i<=first/2;i++){
            if(first%i ==0)
                return false;
        }
        return true;
    }
}
