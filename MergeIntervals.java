package com.algorithms.qartks;

import java.util.*;

/**
 * Created by qartks on 2/16/17.
 */
public class MergeIntervals {


    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    public static void main(String[] args) {

        List<Interval> arr = new ArrayList<>();

    }

    public class Solution {
        public List<Interval> merge(List<Interval> intervals) {
//            Collections.sort(intervals, new Comparator<Interval>() {
//                @Override
//                public int compare(Interval o1, Interval o2) {
//                    return o1.start - o2.start;
//                }
//            });

            Collections.sort(intervals, (i1 , i2) -> i1.start - i2.start);

            List<Interval> result = new LinkedList<>();

            int start = intervals.get(0).start;
            int end = intervals.get(0).end;

            for (Interval interval : intervals) {
                if (interval.start <= end) {
                    end = Math.max(interval.end, end);
                } else {
                    result.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }

            result.add(new Interval(start, end));
            return result;
        }
    }
}
