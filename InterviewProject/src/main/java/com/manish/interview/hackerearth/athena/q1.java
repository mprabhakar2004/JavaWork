package com.manish.interview.hackerearth.athena;

import java.util.*;

/**
 * Created by manishkumar on 06-01-2017.
 */
public class q1 {
    public static void main(String[] args) {

        String [] strings = {"{{}}","{(})","{{()}}"};
        System.out.println(Arrays.toString(braces(strings)));

        int []a = {1234,567};
        int []m = {2245, 156};
        System.out.println(minStepsRequired(a,m));

    }

    private static int maxMoney(int n, int k) {
        long collectedSum = 0;
        boolean flag = false;
        int moduloConst = 1000000000;
        moduloConst +=7;
        for (int index = 1; index <= n; index++) {
            collectedSum += index;
            if (collectedSum == k) {
                flag = true;
                break;
            }
        }
        if (flag) {
            collectedSum = ((long) n * (long) n + n) / 2;
            collectedSum --;
        }
        return (int) (collectedSum % moduloConst);
    }

    private static String firstRepeatedWord1(String s) {
        Map<String, Integer> strFreq = new HashMap<>();
        String[] strArr = s.split("(,)|(:)|(;)|(-)|(\\.)|(\\s+)|(\t)");
        for (String str : strArr) {

            if (strFreq.containsKey(str)) {
                strFreq.put(str, strFreq.get(str) + 1);
            } else {
                strFreq.put(str, 1);
            }
        }
        for (String str : strArr) {
            if (strFreq.get(str) > 1) {
                return str;
            }
        }
        return null;
    }


    private static String firstRepeatedWord(String s) {
        Map<String, Integer> strFreq = new HashMap<>();

        StringTokenizer st = new StringTokenizer(s, ",:;-.\t ");
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (strFreq.containsKey(str)) {
                strFreq.put(str, strFreq.get(str) + 1);
            } else {
                strFreq.put(str, 1);
            }
        }
        st = new StringTokenizer(s, ",:;-.\t ");
        while (st.hasMoreTokens()) {
            String str = st.nextToken();
            if (strFreq.get(str) > 1) {
                return str;
            }
        }
        return null;
    }


    static String[] braces(String[] values) {
        String []res = new String[values.length];
        for(int i=0;i<values.length;i++){
            if(isBalanced(values[i])){
                res[i] = "YES";
            }else{
                res[i] = "NO";
            }
        }
        return res;
    }

    static Map<Character,Character> charMap = new HashMap<>();
        static {
            charMap.put('{', '}');
            charMap.put('[', ']');
            charMap.put('(', ')');
        }
    static boolean isBalanced(String str){


        char []strArr = str.toCharArray();
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<strArr.length;i++){
            if(charMap.containsValue(strArr[i])){
                if(!stack.isEmpty()){
                    char ch = stack.pop();
                    if(ch!= strArr[i])
                        return false;
                }else return false;
            }else{
                stack.push(charMap.get(strArr[i]));
            }
        }
        return stack.isEmpty();
    }


    /**
     * Minimum steps required to convert a to m where any two operation required on each digit (increment or decrement by 1
     *
     * e.g.
     * a =      {1234, 567}
     * m =      {3435 , 478}
     *
     * res =     2+2+0+1  + 1+1+1 = 8
     *
     */
    static int minStepsRequired(int []a,int []m){

        int res = 0;
        for(int i=0;i<a.length;i++){
            char [] currA = String.valueOf(a[i]).toCharArray();
            char [] currM = String.valueOf(m[i]).toCharArray();
            for (int j=0;j<currA.length ;j++){
                res += Math.abs(currA[j]- currM[j]);
            }
        }
        return res;
    }

}
