package com.home.hackerearth.greytrip;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        Set<String> sourceStrings = new HashSet<>();
		/*sourceStrings.add("bkllkbblb");
		List<String> wordsToRemove = new ArrayList<>();
		wordsToRemove.add("kl");
		wordsToRemove.add("bl");
		wordsToRemove.add("b");*/

        sourceStrings.add("aaabccd");
        List<String> wordsToRemove = new ArrayList<>();
        wordsToRemove.add("aaa");
        wordsToRemove.add("ac");
        wordsToRemove.add("abc");

        System.out.println(findLengthOfFinalString(sourceStrings, wordsToRemove));
    }

    private static int findLengthOfFinalString(Set<String> sourceStrings, List<String> wordsToRemove) {

        if(sourceStrings.size() == 0 ){
            return 0;
        }

        Set<String> inputSourceStrings = new HashSet<>(sourceStrings);
        sourceStrings.clear();

        for(String string : inputSourceStrings){
            for(String word : wordsToRemove){
                if(string.contains(word)){
                    sourceStrings.add(string.replaceFirst(word, ""));
                }
            }
        }

        if(sourceStrings.size() == 0 ){
            int min = inputSourceStrings.iterator().next().length();
            for(String str : sourceStrings){
                if(str.length() < min)
                    min = str.length();
            }
            return min;
        }
        return findLengthOfFinalString(sourceStrings, wordsToRemove);
    }

}
