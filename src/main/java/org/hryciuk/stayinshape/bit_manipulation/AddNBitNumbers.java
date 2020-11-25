package org.hryciuk.stayinshape.bit_manipulation;

public class AddNBitNumbers {

    // O(n); a + b to jest tak naprawde XOR (exclusive OR ); carry to jest tak naprawde AND
    // https://www.cs.uaf.edu/2000/fall/cs301/notes/node54.html
    public int[] addNBitNumbers(int[] A, int[] B) {
        if (A.length != B.length) {
            throw new IllegalStateException("Should be of same size!");
        }
        int initialLength = A.length;
        int[] C = new int[initialLength + 1];

        boolean carry = false;
        for (int i = initialLength - 1; i >= 0; i--) {
            if (A[i] == 1 && B[i] == 1) {
                if (carry) {
                    C[i + 1] = 1;
                } else {
                    C[i + 1] = 0;
                    carry = true;
                }
            } else {
                if (!carry) {
                    C[i + 1] = A[i] + B[i];
                } else {
                    if (A[i] == 0 && B[i] == 0) {
                        C[i + 1] = 1;
                        carry = false;
                    } else {
                        C[i + 1] = 0;
                    }
                }
            }
        }
        C[0] = carry ? 1 : 0;
        return C;
    }

    public int[] addNBitNumbersMoreIntelligently(int[] A, int[] B) {
        if (A.length != B.length) {
            throw new IllegalStateException("Should be of same size!");
        }
        int initialLength = A.length;
        int[] C = new int[initialLength + 1];

        int carry = 0;
        for (int i = initialLength - 1; i >= 0; i--) {
            C[i + 1] = (A[i] + B[i] + carry) % 2;
            carry = (A[i] + B[i] + carry) / 2;
        }
        C[0] = carry;
        return C;
    }

    public int addNBitNumbersEvenMoreIntelligently(int x, int y) {
        // Iterate till there is no carry
        while (y != 0) {
            // carry now contains common set bits of x and y
            int carry = x & y;
            // Sum of bits of x and y where at least one of the bits is not set
            x = x ^ y;
            // we shift left carry by one so that adding it to x gives required sum
            y = carry << 1;
        }
        return x;
    }

}
