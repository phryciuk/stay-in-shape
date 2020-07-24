package org.hryciuk.stayinshape.dynamic_programming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] uniquePaths = new int[m][n];
        uniquePaths[0][0] = 1;

        // let's consider first row first
        for (int i = 1; i < n; ++i) {
            uniquePaths[0][i] = 1;
        }

        // let's consider first column now
        for (int i = 1; i < m; i++) {
            uniquePaths[i][0] = 1;
        }

        // the rest; rows
        for(int i = 1; i < m; i++) {
            // columns
            for (int j = 1; j < n; j++) {
                uniquePaths[i][j] = uniquePaths[i][j - 1] + uniquePaths[i - 1][j];
            }
        }
        return uniquePaths[m - 1][n - 1];
    }
}
