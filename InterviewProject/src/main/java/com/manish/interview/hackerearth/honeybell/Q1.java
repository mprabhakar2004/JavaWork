package com.manish.interview.hackerearth.honeybell;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) throws Exception{
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            long M = s.nextLong();
            long N = s.nextLong();
            long K = s.nextLong();
            long tn = N;
            long res = 0;
            System.out.println(calculateMaxStampedCell(M, N, K));
        }
    }

    private static long calculateMaxStampedCell(long m, long n, long k) {
        long res=0;
        long tn= n;
        while (m * n > k) {
            while (m * n > k) {
                n--;
            }
            if (res < m * n)
                res = m * n;
            n =tn;
            m--;
        }
        if (res==0)
            res = m * n;
        return res;
    }
}
