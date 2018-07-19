package com.manish.interview.hackerearth.redmart;

import java.util.*;

/**
 * Write a program that works as a simple calculator that supports five operations: addition, subtraction, multiplication, division and modulo.
 Input

 There is an unknown number of tests. Each HackerTest consists of one-character symbol which corresponds to specific operation (+ addition, - subtraction,
 * multiplication, / division and % modulo) and two following integers. Each HackerTest will be separated by spaces and followed by a newline.
 * Number of tests doesn't exceed 100 and the result is less than 231. You can assume that there is no situation in which you would have to divide by 0.

 Output

 For each HackerTest you should print a single number being the result of each operation.
 Example

 Input:

 + 7 9
 - 0 4
 * 5 6
 / 8 3
 % 5 2

 Output:

 16
 -4
 30
 2
 1

 */
public class q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line= null;
        List<Integer> res = new ArrayList<>();
        do {
            line = in.nextLine();

            if (line.trim().length()>0) {
                res.add(calcRes(line));
            }
        }while (line.trim().length()>0);

        for (int item:res){
            System.out.println(item);
        }
    }

    private static int calcRes(String line) {
        String []strArr = line.split(" ");
        switch (strArr[0]){
            case "+":
                return Integer.parseInt(strArr[1]) + Integer.parseInt(strArr[2]);
            case "-":
                return Integer.parseInt(strArr[1]) - Integer.parseInt(strArr[2]);
            case "/":
                return Integer.parseInt(strArr[1]) / Integer.parseInt(strArr[2]);
            case "*":
                return Integer.parseInt(strArr[1]) * Integer.parseInt(strArr[2]);
            case "%":
                return Integer.parseInt(strArr[1]) % Integer.parseInt(strArr[2]);
        }
        return 0;
    }

}
