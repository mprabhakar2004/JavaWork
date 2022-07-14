package com.manish.interview.hackerearth.adobe;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try(Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
                sb.append("\n");
            }
        }
        String code = sb.toString();

        Matcher matcher = Pattern.compile("(//[^\\n]*)|(/\\*.*?\\*/)", Pattern.MULTILINE | Pattern.DOTALL).matcher(code);
        while (matcher.find()) {
            String comment = matcher.group();
            printComment(comment);
        }
    }

    static void printComment(String comment) {
        try(Scanner sc = new Scanner(comment)) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine().trim());
            }
        }
    }
}
