package com.home.hackerearth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HackerTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        String[] aRowItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        System.out.format("%.3f\n",123.4);
//        System.out.format("%.3f",123.4);

        System.out.println(arrayManipulation(5,new int[][]{{1,2,100},{2,5,100},{3,4,100}}));
    }

    /**
     * 12 hour format to 24 hour format
     *
     * @param s
     * @return
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String res = "";
        if (s.endsWith("AM")) {
            s = s.substring(0, s.length() - 2);
            int hour = (Integer.parseInt(s.substring(0, s.indexOf(':'))));
            res = (hour == 12 ? "00" : String.format("%02d", hour)) + s.substring(s.indexOf(':'));
        } else if (s.endsWith("PM")) {
            s = s.substring(0, s.length() - 2);
            int hour = (Integer.parseInt(s.substring(0, s.indexOf(':'))));
            hour = hour < 12 ? hour + 12 : hour;

            res = hour + s.substring(s.indexOf(':'));
        }
        return res;
    }

    /**
     * Find max value from Hour glass representation in 2d array
     * <p>
     * 1 2 3 4 5
     * 6 7 8 9 1
     * 3 4 5 6 7
     * 1 2 3 4 5
     * 3 4 5 6 8
     * <p>
     * hour glass representation
     * <p>
     * 1 2 3   2 3 4   3 4 5
     * 7       8       9
     * 3 4 5   4 5 6   5 6 7
     * 6 7 8   7 8 9   8 9 1
     * 4       5       6
     * 1 2 3   2 3 4   3 4 5
     * 3 4 5   4 5 6   5 6 7
     * 2       3       4
     * 3 4 5   4 5 6   5 6 8
     * <p>
     * calculate max sum among them
     *
     * @param arr
     * @return
     */
    static int array2D(int[][] arr) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int sum = (arr[i][j] + arr[i][j + 1] + arr[i][j + 2]) + (arr[i + 1][j + 1]) + (arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]);
                if (sum > res) {
                    res = sum;
                }
            }
        }
        return res;
    }

    /**
     * Rotae array by given times.
     *
     * @param arr
     * @param d
     */
    public static void rotateArray(int[] arr, int d) {
        reverseArray(arr, 0, d);
        reverseArray(arr, d, arr.length);
        reverseArray(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void reverseArray(int[] arr, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    /**
     *
     * @param strings
     * @param queries
     * @return
     */
    static int[] solve(String[] strings, String[] queries) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {

            map.put(strings[i], map.getOrDefault(strings[i],0) + 1);
        }
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {

            res[i] = map.getOrDefault(queries[i],0);

        }
        return res;
    }

    /**
     *
     * @param n
     * @param queries
     * @return
     */
    static long arrayManipulation(int n, int[][] queries) {
        Map<Integer,Long> map = new HashMap<>();
        long res=Long.MIN_VALUE;
        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            long operand = queries[i][2];
            for(int j=start-1;j<end;j++){
                long num = map.getOrDefault(j,0l) + operand;
                map.put(j,num);
                if(res<num)
                    res = num;
            }
        }
        return res;
    }

}
