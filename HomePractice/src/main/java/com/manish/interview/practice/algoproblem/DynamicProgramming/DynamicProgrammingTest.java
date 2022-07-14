package com.manish.interview.practice.algoproblem.DynamicProgramming;

public class DynamicProgrammingTest {
    public static void main(String[] args) {
        //System.out.println(numOfRequiredOperationToOneDynamicProgramming(10));
    }


    //region Step to One
    /**
     *  On a positive integer, you can perform any one of the following 3 steps.
     *      1.) Subtract 1 from it. ( n = n - 1 ),
     *      2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  ),
     *      3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
     *  Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
     * @param num
     * @return
     */
    public static int numOfRequiredOperationToOneRec(int num){
        if (num==1)
            return 0;
        int r= 1 + numOfRequiredOperationToOneRec(num-1);
        if (num%2==0){
            r= Math.min(r, 1 +numOfRequiredOperationToOneRec(num/2));
        }
        if (num%3==0){
            r= Math.min(r, 1+ numOfRequiredOperationToOneRec(num/3));
        }
        return r;
    }

    public static int numOfRequiredOperationToOneDynamicProgramming(int num){
        int []memTab = new int[num+1];
        memTab[0] = memTab[1]=0;
        for (int i=2;i<=num;i++){
            memTab[i] = 1+ memTab[i-1];
            if (i%2==0){
                memTab[i] = Math.min(memTab[i],1+ memTab[i/2]);
            }if (i%3==0){
                memTab[i] = Math.min(memTab[i],1+ memTab[i/3]);
            }
        }
        return memTab[num];
    }
    //endregion

    //region Longest increasing sequence

    //endregion
}
