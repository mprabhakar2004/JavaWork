package com.manish.interview.hackerearth.intuit;

public class q1 {
    public static void main(String[] args) {

        System.out.println( mergeStrings("ab","zsd"));
    }

    private static String mergeStrings(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder(a.length() + b.length());
        int i=0,j=0;
        while (i<a.length() && j<b.length()){
            stringBuilder.append(a.charAt(i)).append(b.charAt(j));
            i++;
            j++;
        }
        if(i<a.length()){
            stringBuilder.append(a.substring(i));
        }
        if(i<b.length()){
            stringBuilder.append(b.substring(j));
        }

        return stringBuilder.toString();
    }
}
