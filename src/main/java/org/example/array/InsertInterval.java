package org.example.array;

import org.example.model.Interval;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 *  
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * * * */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<Interval>();
        boolean inserted = false;
        for (Interval inter:intervals) {
            if (inserted) {
                result.add(inter);
            }
            else if (newInterval.getStart() > inter.getEnd()) {
                //no overlap
                result.add(inter);
            }
            else if (newInterval.getEnd() < inter.getStart()) {
                inserted = true;
                result.add(newInterval);
                result.add(inter);
            }
            else {
                newInterval.setStart(Math.min(newInterval.getStart(), inter.getStart()));
                newInterval.setEnd(Math.max(newInterval.getEnd(), inter.getEnd()));
            }
        }
        if (!inserted) {
            result.add(newInterval);
        }

        return result;
    }
/**
 * After that, I sorted 1d arrays inside 2d array by their first value.
 *
 * Then I loop thru 1d arrays and find overlaps: if start of the second interval is less than or
 * * equal to the end, then I assign max end between two numbers. If start is greater than there is
 * * no overlap and we need to record this to temporary 2d array.
 *
 * In the end just create 2d array with resulting size and copy arrays from temporary 2d array.
 * * * */
    public int[][] insertV2(int[][] ints, int[] newInterval) {
        int[][] intervals = new int[ints.length + 1][2];
        for (int i = 0; i < ints.length; i++) {
            intervals[i][0] = ints[i][0];
            intervals[i][1] = ints[i][1];
        }
        intervals[intervals.length - 1][0] = newInterval[0];
        intervals[intervals.length - 1][1] = newInterval[1];

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int count = 0, start = intervals[0][0], end = intervals[0][1];
        int[][] resTemp = new int[intervals.length][2];
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s <= end) {
                end = Math.max(e, end);
            } else {
                resTemp[count][0] = start;
                resTemp[count++][1] = end;
                start = s;
                end = e;
            }
        }
        resTemp[count][0] = start;
        resTemp[count++][1] = end;

        int[][] res = new int[count][2];
        for (int i = 0; i < count; i++) {
            res[i] = resTemp[i];
        }
        return res;
    }

    public int[][] insertFinal(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }

        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            // we could mutate newInterval here also
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // add the union of intervals we got
        result.add(newInterval);

        // add all the rest
        while (i < intervals.length){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
