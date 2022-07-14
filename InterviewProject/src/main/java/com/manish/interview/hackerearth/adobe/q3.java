package com.manish.interview.hackerearth.adobe;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Parser {
    Map<Character, Character> map = new HashMap<>();
    public Parser() {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    public boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isOpenning(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty())
                    return false;
                char temp = stack.pop();
                if (!isMatching(ch, temp)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isMatching(char ch, char temp) {
        return (map.get(temp).equals(ch));
    }

    private boolean isOpenning(char ch) {
        return map.containsKey(ch);
    }
}

public class q3 {
    public static void main(String[] args) {
        System.out.println(new Parser().isBalanced("{{()()}}"));
    }

}
