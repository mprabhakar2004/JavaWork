package com.manish.interview.hackerearth.directi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by manish_kumar9 on 23/12/15.
 */
public class Solution {
    public static void main(String[] args) {
       String y ="abcdefghij";
//        String z ="";
//        Scanner in = new Scanner(System.in);
//        y=in.next();
//        z=in.next();
        Set<String> permutationOf1stString = getAllPermutations(y);
//        Set<String> permutationOf2ndString = getAllPermutations(z);
//
//        if(isResultPossible(permutationOf1stString, permutationOf2ndString)){
//            System.out.println("true");
//        }else {
//            System.out.println("false");
//        }
        System.out.println(permutationOf1stString);
    }

    private static boolean isResultPossible(Set<String> permutationOf1stString, Set<String> permutationOf2ndString) {
        if(doesOneCanBeatAnother(permutationOf1stString, permutationOf2ndString)){
            return true;
        }else if(doesOneCanBeatAnother( permutationOf2ndString,permutationOf1stString)){
            return true;
        }

        return false;
    }

    private static boolean doesOneCanBeatAnother(Set<String> permutationOf1stString, Set<String> permutationOf2ndString) {
        for(String item:permutationOf1stString){
            if(doesAbeatB(item,permutationOf2ndString)){
                return true;
            }
        }
        return false;
    }

    private static boolean doesAbeatB(String aStr, Set<String> permutationOf2ndString) {
        for (String bStr:permutationOf2ndString){
            if(isString1BeatString2(aStr,bStr))
                return true;
        }
        return false;
    }



    private static boolean isString1BeatString2(String y, String z) {
        for(int i=0;i<y.length();i++){
            if(y.charAt(i) < z.charAt(i)){
                return false;
            }
        }
        return true;
    }


    public static Set<String> getAllPermutations(String str) {
        Set<String> perm = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = getAllPermutations(rem);
        for (String strNew : words) {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        }
        return perm;
    }

    private static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
}
