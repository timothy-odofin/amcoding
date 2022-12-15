package org.example;
/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * * * **/
public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] tab = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    tab[i][j] = 1;
                }
                else{
                    tab[i][j] = tab[i-1][j]+tab[i][j-1];
                }
            }
        }

        return tab[m-1][n-1];
    }
}
/**
 * The assumptions are
 *
 *     When (n==0||m==0) the function always returns 1 since the robot
 *     can't go left or up.
 *     For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
 *
 * Therefore I populated the edges with 1 first and use DP to get the full 2-D array.
 *
 * Please give any suggestions on improving the code.
 * * * **/
