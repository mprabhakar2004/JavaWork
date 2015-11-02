package com.hom.test;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String pattern = "4+0*";
        String str = "44444";

        System.out.println(str.matches(pattern));

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] inputArr = new long[t];

        for (int i = 0; i < t; i++) {
            inputArr[i] = in.nextInt();
        }
        for (int i = 0; i < t; i++) {
            System.out.println(findSolution(inputArr[i]));
        }

    }

    private static int findSolution(long input) {
        int result = 0;
        for (int i = 1; ; i++) {
            String multiple = (i * input) + "";
            if (multiple.matches("^4+0*")) {
                int a = multiple.replaceAll("[^4]", "").length();
                int b = multiple.replaceAll("[^0]", "").length();
                result = 2 * a + b;
                result = 2 * a + b;
                break;
            }
        }
        return result;
    }
    private  static int countDigit(String str,char ch){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==ch) {
                int j = i;
                while (j<str.length() && str.charAt(j++) == ch)
                    count++;
                return count;
            }
        }
        return count;
    }
}
