package org.hryciuk.stayinshape.sorting.bit;

public class BitManipulations {

    boolean isPowerOf2(int x) {
        if (x == 1) {
            return true;
        }
        x = x & (x - 1);                  // remove lowest bit set to one
        return x == 0;      // it should be 0.
    }

    // Swap i and j bits on a long number
    public static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) { // sprawdzamy czy sa inne wartosci na bitach
            long bitMask = 1L << i | 1L << j; // jak sa to ustawiamy maske
            x ^= bitMask; // XOR ; czyli zamiana wartosci wlasciwa
        }
        return x;
    }

    public static int numberComplement(int x) {
//        String s = Integer.
//        Integer.pars
        return 0;
    }
}
