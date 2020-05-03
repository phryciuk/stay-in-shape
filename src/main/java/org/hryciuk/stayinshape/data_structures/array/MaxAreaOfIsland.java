package org.hryciuk.stayinshape.data_structures.array;

/**
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * <p>
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * <p>
 * Example 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * <p>
 * Given the above grid, return 0.
 * <p>
 * Note: The length of each dimension in the given grid does not exceed 50.
 */
class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                // pierwszy element wyspy
                if (grid[i][j] == 1) {
                    int localMax = area(i, j, grid);
                    maxArea = Math.max(localMax, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int area(int column, int row, int[][] grid) {
        // ważne żeby dobrze zabezpieczyć sprawdzanie elementów poza zasięgiem
        if (column < 0 || row < 0 || column >= grid.length || row >= grid[0].length || grid[column][row] == 0) {
            return 0;
        }
        grid[column][row] = 0;
        return 1 + area(column - 1, row, grid)
                + area(column + 1, row, grid)
                + area(column, row - 1, grid)
                + area(column, row + 1, grid);
    }

}
