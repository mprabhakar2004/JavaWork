package com.manish.interview.hackerearth.playgame24by7;

import java.util.HashSet;
import java.util.Set;

public class q2 {
    static int getMinimumUniqueSum(int[] arr){
        int sum = 0;
        Set<Integer> elementSet = new HashSet<>();
        for(int element : arr){
            boolean elementExists = elementSet.add(element);
            if(!elementExists){
                while(elementSet.contains(++element)){
                }
                elementSet.add(element);
            }
        }
        for(int i : elementSet){
            sum += i;
        }
        return sum;
    }
}
