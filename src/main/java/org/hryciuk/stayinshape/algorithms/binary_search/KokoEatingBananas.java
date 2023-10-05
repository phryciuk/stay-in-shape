package org.hryciuk.stayinshape.algorithms.binary_search;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles)
            maxPile = Math.max(maxPile, pile);

        int lo = 1;
        int hi = maxPile;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int sumOfHours = 0;
            for (int pile : piles) {
                sumOfHours += Math.ceil((double) pile / mid);
            }

            if (sumOfHours > h) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
