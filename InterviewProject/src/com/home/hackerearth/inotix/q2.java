package com.home.hackerearth.inotix;

import java.util.HashMap;
import java.util.Map;

public class q2 {

    static String[] findNumberOfCowsAndBulls(Map<String, String> input) {
        String[] result = new String[input.size()];
        int i = 0;
        for (String key : input.keySet()) {
            String value = input.get(key);
            Map<String, Integer> keyMap = new HashMap();
            Map<String, Integer> valueMap = new HashMap();
            populateMap(keyMap, key.toCharArray());
            populateMap(valueMap, value.toCharArray());
            int bulls = 0;
            int cows = 0;
            for (String key1 : keyMap.keySet()) {
                if (valueMap.containsKey(key1) && valueMap.get(key1) == keyMap.get(key1)) {
                    bulls++;
                } else if (valueMap.containsKey(key1)) {
                    cows++;
                }
            }
            result[i] = bulls + "-Bulls," + cows + "-Cows";
            i++;
        }
        return result;
    }

    static void populateMap(Map<String, Integer> map, char[] str) {
        for (int i = 0; i < str.length; i++) {
            map.put(String.valueOf(str[i]), i);
        }
    }

}
