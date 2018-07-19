package com.manish.interview.hackerearth.tesco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class q3 {

    public static void main(String[] args) {
        int[][] intervals = {
                {4, 5},
                {2, 3},
                {1, 2},
                {7, 9}
        };

        System.out.println(breakTime(intervals.length,intervals));
    }

    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

   static public int breakTime(int input1, int[][] input2) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        for (int i = 0; i < input1; i++) {
            intervals.add(new Interval(input2[i][0], input2[i][1]));
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int res = 0;
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.start == prev.end) {
                prev = current;
                continue;
            } else {
                res += current.start - prev.end;
                prev = current;
            }
        }
        return res;
    }

}

