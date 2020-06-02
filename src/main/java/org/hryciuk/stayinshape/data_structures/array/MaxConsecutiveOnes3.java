package org.hryciuk.stayinshape.data_structures.array;

/**
 * 1004. Max Consecutive Ones III
 * Medium
 *
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 *
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 *
 * Example 2:
 *
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation:
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 *
 *
 *
 * Note:
 *
 *     1 <= A.length <= 20000
 *     0 <= K <= A.length
 *     A[i] is 0 or 1
 */
public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] A, int K) {
        int startOfWindow = 0;
        int maxLength = 0;
        int[] occurrences = new int[2];
        for (int endOfWindow = 0; endOfWindow < A.length; ++endOfWindow) {
            int currentNumber = A[endOfWindow];
            occurrences[currentNumber]++;
            while (occurrences[0] > K) {
                occurrences[A[startOfWindow]]--;
                startOfWindow++;
            }
            maxLength = Math.max(maxLength, endOfWindow - startOfWindow + 1);
        }
        return maxLength;
    }
}
