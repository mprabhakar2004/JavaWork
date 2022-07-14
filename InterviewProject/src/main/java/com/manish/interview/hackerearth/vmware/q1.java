package com.manish.interview.hackerearth.vmware;

import java.util.Arrays;

public class q1 {

    public static void main(String[] args) {

        String[] s1 = {"a", "jk", "abb", "mn", "abc"};
        String[] s2 = {"bb", "kj", "bbc", "op", "def"};
        System.out.println(Arrays.toString(getMinimumDifference(s1, s2)));
    }

    static int[] getMinimumDifference(String[] a, String[] b) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = findDifference(a[i], b[i]);
        }

        return res;
    }

    private static int findDifference(String str1, String str2) {
        int res = -1;

        if (str1.length() == str2.length()) {
            res=0;
            char[] str1Arr = str1.toCharArray();
            char[] str2Arr = str2.toCharArray();
            Arrays.sort(str1Arr);
            Arrays.sort(str2Arr);

            for (int i = 0; i < str1Arr.length; i++) {

                if (str1Arr[i] != str2Arr[i]) {
                    res++;
                }
            }

        }
        return res;
    }



    static void textQueries(String[] sentences, String[] queries) {


    }

}
