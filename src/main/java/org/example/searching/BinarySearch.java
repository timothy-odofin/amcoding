package org.example.searching;
/**
 * Given an array of integers nums which is sorted in ascending order,
 * * and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 * * * */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start<=end) {
            int mid = start + (end - start)/2;
            if(target<nums[mid]) {
                end = mid - 1;
            }
            else if (target>nums[mid]) {
                start = mid + 1;
            }
            else  if(nums[start] == target) {
                return start;
            }
            else if(nums[end] == target) {
                return end;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
