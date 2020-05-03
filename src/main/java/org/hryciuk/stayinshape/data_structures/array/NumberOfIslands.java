package org.hryciuk.stayinshape.data_structures.array;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    islands++;
                    countIslands(i, j, grid);
                }
            }
        }
        return islands;
    }

    void countIslands(int column, int row, char[][] grid) {
        if (column >= grid.length || row >= grid[0].length || column < 0 || row < 0 || grid[column][row] == '0') {
            return;
        }
        grid[column][row] = '0';
        countIslands(column - 1, row, grid);
        countIslands(column + 1, row, grid);
        countIslands(column, row + 1, grid);
        countIslands(column, row - 1, grid);
    }
}
