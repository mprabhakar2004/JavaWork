package com.manish.interview.hackerearth.inotix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class q1 {
    public static void main(String[] args) {

        LinkedHashMap<String, String> strMap = new LinkedHashMap<>();
        /*strMap.put("12","1");
        strMap.put("1","1");

        strMap.put("2","1");

        strMap.put("3","1");

        strMap.put("0","1");

        strMap.put("11","1");
        strMap.put("4","1");*/


        strMap.put("a", "1");
        strMap.put("1", "1");

        strMap.put("2", "1");

        strMap.put("3", "1");

        strMap.put("0", "1");

        strMap.put("A", "1");
        strMap.put("4", "1");


        strMap = codeTheSolution(strMap);
        System.out.println(strMap.values());


    }

    public static LinkedHashMap<String, String> codeTheSolution(LinkedHashMap<String, String> inputLinkHashMap) {
        int[] strArray = new int[inputLinkHashMap.keySet().size()];
        int i = 0;

        for (String str : inputLinkHashMap.keySet()) {
            if (str.length() == 1 && ((str.charAt(0) >= 65 && str.charAt(0) <= 90) || (str.charAt(0) >= 97 && str.charAt(0) <= 122)))
                strArray[i++] = str.charAt(0);
            else
                strArray[i++] = Integer.parseInt(str);
        }

        int[] res = countRight(strArray);
        i = 0;
        for (String key : inputLinkHashMap.keySet()) {
            inputLinkHashMap.put(key, String.valueOf(res[i++]));
        }

        return inputLinkHashMap;

    }

    static int[] countRight(int[] ar) {
        int[] res = new int[ar.length];
        for (int i = 0; i < ar.length; i++)
            res[i] = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if (ar[j] < ar[i])
                    res[i]++;
            }
        }

        return res;
    }
}
