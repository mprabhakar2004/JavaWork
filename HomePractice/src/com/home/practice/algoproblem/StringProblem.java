package com.home.practice.algoproblem;

/**
 * Created by Manishkumar on 02-02-2017.
 */
public class StringProblem {
    int robinKarp(String string, String search){
        int hashForSearchString = hash(search,0,' ');
        for (int i=0;i<string.length() - search.length()-1;i++){
            String tempStr= string.substring(i,search.length());
            if(hashForSearchString == hash(tempStr,0,' ')){

            }else {
                continue;
            }
        }
        return -1;
    }

    private int hash(String search, int lastHash, char lastChar) {
        int result=0;
        int prime = 101;
        int multiplier = 1;
        if (lastChar=='\0') {
            for (int i = 0; i < search.length(); i++) {
                result += search.charAt(i) * prime * multiplier;
                multiplier *= search.length();
            }
        }else {
            lastHash -=lastChar;
            result = lastHash + search.charAt(search.length()-1) * prime *pow(search.length(),search.length()-1);
        }
        return result;
    }

    private int pow(int base, int index) {
        int p=1;
        for (int i=0;i<index;i++){
            p*=base;
        }
        return p;
    }
}
