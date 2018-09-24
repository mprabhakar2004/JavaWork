package com.manish.interview.hackerearth.atlassian;

public class q1 {
    public static void main(String[] args) {
        //System.out.println(convert(7792875));
        System.out.println(convertBin(15));
    }



    static char []symbol = {'0','a','t','l','s','i','n'};

    static String convert(long input){
        StringBuilder res=new StringBuilder();
        while (input>0){
            int rem = (int)input %7;
            input/=7;
            res.append(symbol[rem]);
        }
        return res.reverse().toString();
    }


    static String convertBin(long input){
        StringBuilder res=new StringBuilder();
        while (input>0){
            int rem = (int)input %2;
            input/=2;
            res.append(rem);
        }
        return res.reverse().toString();
    }
}
