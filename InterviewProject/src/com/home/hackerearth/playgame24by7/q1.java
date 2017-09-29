package com.home.hackerearth.playgame24by7;

import java.util.Stack;

public class q1 {
    public static void main(String[] args) {
        String[] stringsToValidate = {"{}[]()", "{[}]"};
        for (String s : braces(stringsToValidate)) {
            System.out.println(s);
        }
    }

    private static boolean isOpeningParanthesis(char c){
        switch (c) {
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }

    private static boolean isClosingParanthesis(char c){
        switch (c) {
            case ')':
            case '}':
            case ']':
                return true;
            default:
                return false;
        }
    }

    public static String[] braces(String[] stringsToValidate){
        String[] result = null;
        if(stringsToValidate != null && stringsToValidate.length > 0){
            Stack<Character> stack = new Stack<>();
            String str;
            char temp;
            boolean balanced = true;
            result = new String[stringsToValidate.length];
            for(int i=0; i<stringsToValidate.length; i++){
                balanced = true;
                stack.clear();
                str = stringsToValidate[i];
                for(char c : str.toCharArray()){
                    if(isOpeningParanthesis(c)){
                        stack.push(c);
                    }else if(isClosingParanthesis(c)){
                        if(stack.isEmpty()){
                            balanced = false;
                            break;
                        }
                        temp = stack.pop();
                        if((temp == '{' && c != '}') || (temp == '[' && c != ']') || (temp == '(' && c != ')')){
                            balanced = false;
                            break;
                        }
                    }
                }
                if(balanced && stack.isEmpty()){
                    result[i] = "YES";
                }else{
                    result[i] = "NO";
                }
            }
        }

        return result;
    }
}
