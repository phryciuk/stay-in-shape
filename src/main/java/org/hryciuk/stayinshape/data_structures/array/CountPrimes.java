package org.hryciuk.stayinshape.data_structures.array;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                count++;
                if ((n / i) != i) {
                    count++;
                }
            }
        }
        return count == 2;
    }
}
