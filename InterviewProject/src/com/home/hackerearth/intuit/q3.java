package com.home.hackerearth.intuit;

import java.util.Arrays;

public class q3 {

    public static void main(String[] args) {
        int []a = {7,10,7};
        int []b={2,3,4};
        int []c={2,7,4};
        System.out.println(Arrays.toString(triangleOrNot(a,b,c)));
    }

    private static String [] triangleOrNot(int[] a, int[] b, int[] c) {
        String[] resultArray = new String[a.length];
        int sideA,sideB,sideC;
        for(int i=0; i<a.length; i++){
            sideA = a[i];
            sideB = b[i];
            sideC = c[i];
            if(((sideA + sideB) > sideC) && ((sideB + sideC) > sideA) && ((sideA + sideC) > sideB)){
                resultArray[i] = "YES";
            }else{
                resultArray[i] = "NO";
            }
        }
        return resultArray;
    }


}
