package com.manish.interview.hackerearth.intuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class q2 {
    public static void main(String[] args) {
        String[] operations={"push","push","push","pop"};
        int []x = {1,2,3,1};
        System.out.println(Arrays.toString(maxMin(operations,x)));
    }

    private static long [] maxMin(String[] operations, int[] x) {
        long []res = new long[operations.length];
        ArrayList<Integer> arrayList = new ArrayList<>(operations.length);
        long max,min;
        for (int i=0;i<operations.length;i++){
            switch (operations[i]){
                case "push":
                    arrayList.add(x[i]);
                    break;
                case "pop":
                    arrayList.remove(Integer.valueOf(x[i]));
                    break;
            }
            max = Collections.max(arrayList);
            min = Collections.min(arrayList);
            res[i] = max*min;
        }

        return res;
    }
}
