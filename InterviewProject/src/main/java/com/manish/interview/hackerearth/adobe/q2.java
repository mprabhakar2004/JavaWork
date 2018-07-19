package com.manish.interview.hackerearth.adobe;

import java.util.regex.Pattern;

public class q2 {
    public static void main(String[] args) {
        String pattern = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        System.out.println(matched("256.244.255.10",pattern));
    }

    static boolean matched(String string, String pattern ){

        boolean res = Pattern.compile(pattern).matcher(string).matches();
        return res;
    }
}
