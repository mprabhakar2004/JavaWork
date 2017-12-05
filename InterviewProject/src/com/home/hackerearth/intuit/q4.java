package com.home.hackerearth.intuit;

import java.util.regex.Pattern;

public class q4 {
    public static void main(String[] args) {
        // /^([^,]*,){21}[^,]*$/      ([^0])*[0]){2}[^0]*
        //1010 true 11000 false  0101 false 1111 false
        System.out.println(matched("11000","^(1)+([^0]*0){2}([^0])*$"));
    }

    static boolean matched(String string, String pattern ){

        boolean res = Pattern.compile(pattern).matcher(string).matches();
        return res;
    }
}
