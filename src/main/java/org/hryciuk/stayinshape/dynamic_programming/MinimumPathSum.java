package org.hryciuk.stayinshape.dynamic_programming;

/**
 * 64. Minimum Path Sum
 * Medium
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * Accepted
 * 425,706
 * Submissions
 * 785,452
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0 ) {
            return 0;
        }
        int[][] minPaths = new int[grid.length][grid[0].length];
        // minimum path to an element is the value of current cell + min([row - 1, col] which is 'up', [row,col - 1] which is 'left')

        // first cell path is always the first cell value
        minPaths[0][0] = grid[0][0];

        // first row paths; only 'right' moves
        for (int i = 1; i < grid[0].length; ++i) {
            minPaths[0][i] = minPaths[0][i - 1] + grid[0][i];
        }

        // first column paths; only 'down' moves
        for (int i = 1; i < grid.length; ++i) {
            minPaths[i][0] = minPaths[i - 1][0] + grid[i][0];
        }

        // now we need to fill the rest of the array, so every column and row apart from the first row and first column
        for (int i = 1; i < grid.length; ++i) {
            for (int j = 1; j < grid[0].length; ++j) {
                minPaths[i][j] = grid[i][j] + Math.min(minPaths[i - 1][j], minPaths[i][j - 1]);
            }
        }
        return minPaths[grid.length - 1][grid[0].length - 1];
    }
}
