package org.hryciuk.stayinshape.dynamic_programming;

import java.util.*;

public class KnightDialer {
    private final static int MOD = 1000000000 + 7;

    public int knightDialer(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 10;
        }
        // From which numbers can we reach that number
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Arrays.asList(4, 6));
        map.put(1, Arrays.asList(8, 6));
        map.put(2, Arrays.asList(7, 9));
        map.put(3, Arrays.asList(8, 4));
        map.put(4, Arrays.asList(3, 9, 0));
        map.put(5, new ArrayList<>());
        map.put(6, Arrays.asList(1, 7, 0));
        map.put(7, Arrays.asList(2, 6));
        map.put(8, Arrays.asList(1, 3));
        map.put(9, Arrays.asList(4, 2));

        int[][] dp = new int[n + 1][10];
        // we create dp array; for 0 moves it's 0; for 1 moves it's always 1;
        for (int i = 0; i < 10; ++i) {
            dp[0][i] = 0;
            dp[1][i] = 1;
        }

        // now let's see how does it look for two moves;
        for (int j = 2; j <= n; ++j) {
            for (int i = 0; i < 10; ++i) {
                List<Integer> list = map.get(i);
                for (Integer number : list) {
                    dp[j][i] += dp[j - 1][number];
                    dp[j][i] = dp[j][i] % MOD;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 10; ++i) {
            result += dp[n][i];
            result = result % MOD;
        }

        return result;
    }
}
