package org.example.array;

import java.util.Arrays;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * *
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].*
 * * * */
public class CloseToOrigin {
    /**
     * III. The last solution is based on quick sort, we can also call it quick select. In the quick sort, we will always choose a
     * * pivot to compare with other elements. After one iteration, we will get an array that all elements smaller
     * * than the pivot are on the left side of the pivot and all elements greater than the pivot are on the right
     * * side of the pviot (assuming we sort the array in ascending order). So, inspired from this, each iteration,
     * * we choose a pivot and then find the position p the pivot should be. Then we compare p with the K, if the p
     * * is smaller than the K, meaning the all element on the left of the pivot are all proper candidates but it is
     * * not adequate, we have to do the same thing on right side, and vice versa. If the p is exactly equal to the K,
     * * meaning that we've found the K-th position. Therefore, we just return the first K elements, since they are not
     * * greater than the pivot.
     *
     * Theoretically, the average time complexity is O(N) , but just like quick sort, in the worst case, this solution
     * * would be degenerated to O(N^2), and pratically, the real time it takes on leetcode is 15ms.
     *
     * The advantage of this solution is it is very efficient.
     * The disadvatage of this solution are it is neither an online solution nor a stable one. And the K elements
     * * closest are not sorted in ascending order.
     * * * */
    public int[][] kClosest(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}
