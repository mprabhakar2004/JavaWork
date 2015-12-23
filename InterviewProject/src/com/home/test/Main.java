package com.home.test;

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

        boolean b= true;
        System.out.println(b);


    }

    private static int findSolution(long input) {
        int result;
        for (int i = 1; ; i++) {
            BigInteger res = BigInteger.valueOf(input).multiply(BigInteger.valueOf(i));
            String multiple = res.toString();
            if (multiple.matches("^4+0*")) {
                int a = multiple.replaceAll("[^4]", "").length();
                int b = multiple.replaceAll("[^0]", "").length();
                result = 2 * a + b;
                break;
            }
        }
        return result;
    }
}
