package org.example.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int key = target-nums[i];
            if(map.containsKey(key)){
                return new int[]{map.get(key),i};
            }else{
                map.put(nums[i],i); // put the index and number intomap
            }
        }
        return new int[]{-1,-1}; // no record found;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

    //dfs Depth-first search
    void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j, m, n); //up
        dfs(grid, i, j + 1, m, n); //down
        dfs(grid, i - 1, j, m, n); // left
        dfs(grid, i, j - 1, m, n); // right
    }

}
