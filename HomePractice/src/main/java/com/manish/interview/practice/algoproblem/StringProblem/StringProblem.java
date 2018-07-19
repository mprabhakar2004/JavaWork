package com.manish.interview.practice.algoproblem.StringProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Manishkumar on 02-02-2017.
 */
class WordBreak{
    static Set<String> strDict = new HashSet<>(Arrays.asList("Ideserve","learn","learning","platform"));
    public static void wordBreak(String string){
        String result="";
        wordBreakUtil(string,result);
    }

    private static void wordBreakUtil(String string, String result) {
        for (int i=1;i<=string.length();i++){
            String prefix = string.substring(0,i);
            if (strDict.contains(prefix)){
                if (i==string.length()){
                    result +=prefix;
                    System.out.println(result);
                    return;
                }
                wordBreakUtil(string.substring(i), result+prefix + " ");
            }
        }
    }

    public static boolean isWordBreakableRec(String string){
        if (string.length() ==0){
            return true;
        }

        for (int i=1;i<=string.length();i++){
            if (strDict.contains(string.substring(0,i)) && isWordBreakableRec(string.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static boolean isWordBreakableDynamic(String string){
        if (string.length() ==0){
            return true;
        }
        boolean []words = new boolean[string.length()+1];
        for (int i=1;i<=string.length();i++){
            if (!words[i] && strDict.contains(string.substring(0,i))){
                words[i]= true;
                if (i==string.length()){
                    return true;
                }
                for (int j= i+1;j<=string.length();j++){
                    if (!words[j] && strDict.contains(string.substring(i))){
                        words[j]= true;
                    }
                    if (j==string.length() && words[j]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
public class StringProblem {
    static void isPanagram(String s){
        boolean []panagram = new boolean[26];
        char []sarr = s.toUpperCase().toCharArray();
        for(char ch:sarr){
            if(ch>=65 && ch<=90)
                panagram[ch-65] = true;
        }
        boolean p=true;
        for (boolean b : panagram) {
            p &=b;
        }
        if(p)
            System.out.println("pangram");
        else System.out.println("not pangram");
    }

    static String removeDuplicateChars(String userKeyword){

        int charLength = userKeyword.length();
        String modifiedKeyword="";
        for(int i=0;i<charLength;i++)
        {
            if(!modifiedKeyword.contains(userKeyword.charAt(i)+""))
                modifiedKeyword+=userKeyword.charAt(i);
        }
        return modifiedKeyword;
    }

    public  static String shortestPalindrome(String s)
    {
        String rev_s = new StringBuilder(s).reverse().toString();
        //use special character to avoid overlap
        String l = s + "#" + rev_s;

        int[] p = new int[l.length()];

        //build KMP table.
        //i -> suffix boundary
        //j -> prefix boundary


        for(int i=1; i<l.length(); i++)
        {
            //update prefix boundary to previous match position
            int j = p[i-1];

            //move to the last prefix boundary match
            while(j>0 && l.charAt(i)!=l.charAt(j))
                j = p[j-1];

            //if prefix boundary matches suffix boundary,
            //increase prefix length
            if(l.charAt(i) == l.charAt(j)) p[i] = j + 1;
        }

        return rev_s.substring(0, s.length() - p[l.length() - 1]) + s;
    }

    public static void main(String[] args) {
        System.out.println(WordBreak.isWordBreakableDynamic("Ideservelearning"));
    }
}
