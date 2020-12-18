package org.hryciuk.stayinshape.dynamic_programming;

public class UniquePaths {

     public int uniquePathsNaive(int m, int n) {
           if (m == 1 && n == 1) {
             return 1;
           } else if (m == 0 || n == 0) {
             return 0;
           }
           return uniquePathsNaive(m - 1, n) + uniquePathsNaive(m, n - 1);
     }

    public int uniquePathsMemoization(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        } else if (m == 0 || n == 0) {
            return 0;
        }
        Integer[][] memo = new Integer[m + 1][n + 1];
        return helper(m, n, memo);
    }

    private int helper(int m, int n, Integer[][] memo) {
        if (m == 1 && n == 1) {
            return 1;
        } else if (m == 0 || n == 0) {
            return 0;
        }
        if (memo[m][n] != null) {
            return memo[m][n];
        }
        memo[m][n] = helper(m - 1, n, memo) + helper(m, n - 1, memo);
        return memo[m][n];
    }

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
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
