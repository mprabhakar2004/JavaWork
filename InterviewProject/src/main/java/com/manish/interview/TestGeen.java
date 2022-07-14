package com.manish.interview;

import java.util.ArrayList;
import java.util.List;

public class TestGeen {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            nums.add(i);
        }

        System.out.println((long) nums.size());
        System.out.println(nums.stream().count());
        System.out.println();


    }
}
