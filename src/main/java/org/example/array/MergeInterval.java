package org.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
    //Time O(nlogn)
    //Space O(n)
    /**
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * * * */
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));//to avoid integer subtraction overflow
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= end) {
                end = Math.max(intervals[i + 1][1], end);
                i++;
            }
            list.add(new int[]{start, end});
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        List<int[]> arrays = new ArrayList<>();
        arrays.add(new int[]{1,2,3,4});
        arrays.add(new int[]{4,5,3,4});
        arrays.add(new int[]{1,2,3,4});
        arrays.get(0)[1]=30;
        for(int result: arrays.get(0)) {
            System.out.println(result);
        }
    }
}
