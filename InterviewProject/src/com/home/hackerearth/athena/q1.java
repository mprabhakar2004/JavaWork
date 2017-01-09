package com.home.hackerearth.athena;

import java.util.*;

/**
 * Created by manishkumar on 06-01-2017.
 */
public class q1 {
    public static void main(String[] args) {

        String s = "manish. kumar; manish, kumar";

        System.out.println(firstRepeatedWord1(s));

    }

    private static int maxMoney(int n, int k) {
        long sum=0;
        boolean isFound = false;
        int moduloConst = 1000000007;
        for(int index=1;index<=n;index++) {
            sum+=index;
            if(sum==k) {
                isFound = true;
                break;
            }
        }
        if(isFound){
            sum = ((long)n* (long)n + n)/2;
            sum--;
        }
        return (int)(sum % moduloConst) ;
    }

    private static String firstRepeatedWord(String s) {
        Map<String,Integer> strFreq = new HashMap<>();
        String [] strArr = s.split("(,)|(:)|(;)|(-)|(\\.)|(\\s+)|(\t)");
        for (String str:strArr){

            if(strFreq.containsKey(str)){
                strFreq.put(str, strFreq.get(str)+1);
            }else {
                strFreq.put(str, 1);
            }
        }
        for (String str:strArr){
            if(strFreq.get(str) >1){
                return str;
            }
        }
        return null;
    }





    private static String firstRepeatedWord1(String s) {
        Map<String,Integer> strFreq = new HashMap<>();

        StringTokenizer st= new StringTokenizer(s,",:;-.\t ");
        while (st.hasMoreTokens()){
            String str= st.nextToken();
            if(strFreq.containsKey(str)){
                strFreq.put(str, strFreq.get(str)+1);
            }else {
                strFreq.put(str, 1);
            }
        }
        st= new StringTokenizer(s,",:;-.\t ");
        while (st.hasMoreTokens()){
            String str= st.nextToken();
            if(strFreq.get(str) >1){
                return str;
            }
        }
        return null;
    }
    public static int [] retArr(int ar[]) {
        return new int[]{ar[0],ar[ar.length-1]};
    }
}
