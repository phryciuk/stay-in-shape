package org.hryciuk.stayinshape.algorithms.binary_search;

public class FirstBadVersion {

    private boolean[] state;

    public void entry(int n, int bad) {
        this.state = new boolean[n];
        for (int i = 0; i < bad - 1; ++i) {
            state[i] = true;
        }
    }

    public int firstBadVersion(int n) {
        int[] lowestBad = new int[]{Integer.MAX_VALUE};
        helper(n, lowestBad);
        return lowestBad[0];
    }

    private void helper(int n, int[] lowestBad) {
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                lowestBad[0] = Math.min(lowestBad[0], mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
    }

    private boolean isBadVersion(int index) {
        return !state[index - 1];
    }
}
