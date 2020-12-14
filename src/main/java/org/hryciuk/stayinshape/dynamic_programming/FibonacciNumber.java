package org.hryciuk.stayinshape.dynamic_programming;

public class FibonacciNumber {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public int fibWithMemoization(int n) {
        int[] memoization = new int[n + 1];
        return helper(n, memoization);
    }

    private int helper(int n, int[] memoization) {
        if (n < 2) {
            return n;
        }
        if (memoization[n] != 0) {
            return memoization[n];
        }
        memoization[n] = helper(n - 2, memoization) + helper(n - 1, memoization);
        return memoization[n];
    }

    public int fibTabulation(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
