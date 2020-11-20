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
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean isBadVersion(int index) {
        return !state[index - 1];
    }
}
