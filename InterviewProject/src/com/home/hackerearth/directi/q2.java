package com.home.hackerearth.directi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Manishkumar on 23-12-2016.
 */
public class q2 {
    public static void main(String[] args) {


        Stack<Integer> st = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int opNumber = Integer.parseInt(n);
        String[] stArr = new String[opNumber];
        int m = 0;
        for (int i = 0; i < opNumber; i++) {
            String action = sc.nextLine();
            String[] actionArr = action.split(" ");
            switch (actionArr[0]) {
                case "push":
                    st.push(Integer.parseInt(actionArr[1]));
                    stArr[m++] = String.valueOf(st.peek());
                    break;
                case "pop":
                    st.pop();
                    if (st.empty()) {
                        stArr[m++] = "EMPTY";
                    } else {
                        stArr[m++] = String.valueOf(st.peek());
                    }
                    break;
                case "inc":
                    int pos = Integer.parseInt(actionArr[1]);
                    int num = Integer.parseInt(actionArr[2]);
                    int size = st.size();
                    for (int j = 0; j < pos; j++) {
                        st.set(j, st.get(j) + num);
                    }
                    stArr[m++] = String.valueOf(st.peek());
                    break;
                default:
                    break;
            }
        }
        for(int i=0;i<stArr.length;i++) {
            System.out.println(stArr[i]);
        }

    }
}
