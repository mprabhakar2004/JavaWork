package com.manish.interview.hackerearth.inotix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceChecker {

    public static void main(String[] args) {
        String[] strings = {"{{()(}" , "{{()}}"};
        System.out.println(Arrays.toString(braces(strings)));
    }
    static Map<Character,Character> map = new HashMap<>();
    static {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

    }
    static String[] braces(String[] values) {
        String[] res = new String[values.length];
        int i=0;
        for (String str:values){
            if(isBalaced(str)){
                res[i++] = "YES";
            }else {
                res[i++] = "NO";
            }
        }

        return res;
    }

    private static boolean isBalaced(String str) {

        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(isOpenning(ch)){
                stack.push(ch);
            }else {
                if(stack.isEmpty() )
                    return false;
                char temp = stack.pop();
                if(!isMatching(ch,temp)){
                    return false;
                }
            }
        }

        return (stack.isEmpty());
    }

    private static boolean isMatching(char ch, char temp) {
        return (map.get(temp).equals(ch));
    }

    private static boolean isOpenning(char ch) {
        return map.containsKey(ch);
    }

}
