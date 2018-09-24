package com.manish.interview.practice.algoproblem.MiscProblem;

import java.util.HashMap;
import java.util.Map;

class TelephoneNumber {
    private static final int PHONE_NUMBER_LENGTH = 3;
    private final int[] phoneNum;
    private char[] result = new char[PHONE_NUMBER_LENGTH];

    public TelephoneNumber(int[] n) {
        phoneNum = n;
    }

    public void printWords() {
        // Initialize result with first telephone word
        for (int i = 0; i < PHONE_NUMBER_LENGTH; ++i)
            result[i] = getCharKey(phoneNum[i], 1);

        String firstResult = String.valueOf(result);
        do {
            System.out.println(new String(result));
            /* Start at the end and try to increment from right
             * to left.
             */
            for (int i = PHONE_NUMBER_LENGTH - 1; i >-1; --i) {
                // Start with high value, the carry case, so 0 and 1 special cases are dealt with right away

                if (getCharKey(phoneNum[i], 3) == result[i] || phoneNum[i] == 0 || phoneNum[i] == 1) {
                    result[i] = getCharKey(phoneNum[i], 1);
                    // No break, so loop continues to next digit
                } else if (getCharKey(phoneNum[i], 1) == result[i]) {
                    result[i] = getCharKey(phoneNum[i], 2);
                    break;
                } else if (getCharKey(phoneNum[i], 2) == result[i]) {
                    result[i] = getCharKey(phoneNum[i], 3);
                    break;
                }
            }
        } while (!firstResult.equalsIgnoreCase(String.valueOf(result)));

    }

    private char getCharKey(int digit, int index) {
        Map<Integer, String> digitMap = new HashMap<>();
        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqr");
        digitMap.put(8, "stu");
        digitMap.put(9, "vwx");

        return digitMap.get(digit).charAt(index-1);
    }
}

public class MiscProblem {

    public static void main(String[] args) {
        TelephoneNumber telephoneNumber = new TelephoneNumber(new int[]{2, 3, 4});
        telephoneNumber.printWords();
    }


}
