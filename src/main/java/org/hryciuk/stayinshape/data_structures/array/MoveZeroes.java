package org.hryciuk.stayinshape.data_structures.array;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // zliczamy zera
        int zeroes = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                zeroes++;
            }
        }
        int lastPlacedIndex = 0; // indeks ostatnio umieszczonego elementu
        if (zeroes == 0) {
            return;
        }
        // jeśli wartość jest niezerowa to wkładamy ją pod nowym indeksem, możliwie na początku a obecny indeks zastępujemy zerem.
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                // jeszcze sprawdzenie czy ostatni indeks nie jest obecnym. Wtedy nie zastępujemy zerem. Np. dla wejścia [1,0]
                if (i != lastPlacedIndex) {
                    nums[lastPlacedIndex] = nums[i];
                    nums[i] = 0;
                }
                lastPlacedIndex++;
            }
        }
    }
}
