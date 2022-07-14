package com.manish.interview.practice.misc.betterprogrammer;

import com.manish.interview.practice.tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class q1 {

    public static void main(String[] args) throws InterruptedException {

        //System.out.println(minSubArrayLen(6,new int[]{2,3,1,2,4,3}));

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("bye");
            }
        });
        while (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
            executorService.shutdownNow();
        }

        int count=0;
        int n= 6;
        if(n>0){
            count = 1;
            while((n&1) != 1){
                n = n>>1;
                count++;
            }
        }
        System.out.println(count);
    }

    public static int getSumOfNumbers(String s) {
        /*
          Please implement this method to
          return the sum of all integers found in the parameter String. You can assume that
          integers are separated from other parts with one or more spaces (' ' symbol).
          For example, s="12 some text 3  7", result: 22 (12+3+7=22)
         */

        int res = 0;
        String[] strArray = s.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            int num = 0;
            try {
                num = Integer.parseInt(strArray[i]);
            } catch (Exception exp) {
                num = 0;
            }
            res += num;

        }
        return res;
    }

    public static String getBinaryRepresentation(int n) {
        /*
         Please implement this method to
         return a String with the binary representation of any number n, where n >= 0.
         Example: "101" is a binary representation of 5
        */

        StringBuilder sb = new StringBuilder();
        int rem = 0;
        while (n > 0) {
            rem = n % 2;
            sb.append(rem);
            n /= 2;
        }
        return sb.reverse().toString();
    }

    public static int getLevelSum(Node root, int N) {

        // We're at the level we want to sum, return the value assumption is level 1 = root node
        if (N == 1) {
            return root.getData();
        }

        int sum = 0;
        for (Node child : root.getChildren()) {
            sum += getLevelSum(child, N - 1);
        }
        return sum;
    }

    public static List<Integer> getReversalsToSort(int[] a) {
        /*
         You need to sort an array of integers by repeatedly reversing
         the order of the first several elements of it.

         For example, to sort [12,13,11,14], you need to  reverse the order of the first two (2)
         elements and get [13,12,11,14] and then reverse the order of the first three (3)
         elements and get [11,12,13,14]

         The method should return the shortest(!) possible list of integers corresponding to the required reversals.
         For the previous example, given an array [12,13,11,14]
         the method should return a list with Integers 2 and 3.
        */

        List<Integer> res = new ArrayList<>();

        for (int i=2;i<a.length;i++){
            res.add(i);
            for (int j=0,k=i-1; j<k;j++,k--){
                int temp = a[k];
                a[k] = a[j];
                a[j] = temp;
            }

            if(isSorted(a)){
                break;
            }
        }
        return res;
    }

    private static boolean isSorted(int[] a) {
        for (int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1])
                return false;
        }
        return true;
    }


    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==1)
            return 0;
        int result = nums.length;
        int start=0;
        int sum=0;
        int i=0;
        boolean exists = false;
        while(i<=nums.length){
            if(sum>=s){
                exists=true; //mark if there exists such a subarray
                if(start==i-1){
                    return 1;
                }
                result = Math.min(result, i-start);
                sum=sum-nums[start];
                start++;
            }else{
                if(i==nums.length)
                    break;
                sum = sum+nums[i];
                i++;
            }
        }
        if(exists)
            return result;
        else
            return 0;
    }

    public void miscTest(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    }

}
