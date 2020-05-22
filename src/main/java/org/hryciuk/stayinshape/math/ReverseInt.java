package org.hryciuk.stayinshape.math;

/**
 * 7. Reverse Integer
 * Easy
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInt {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        String numberAsString = "" + x;
        char[] numberArray = x > 0 ? reverseString(numberAsString) : reverseString("" + (x * -1));

        try {
            int parsedInt = Integer.parseInt(new String(numberArray));
            return x > 0 ? parsedInt : parsedInt * -1;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private char[] reverseString(String numberAsString) {
        char[] numberArray = numberAsString.toCharArray();
        for (int i = 0; i < numberAsString.length() / 2; ++i) {
            char tmp = numberArray[numberArray.length - 1 - i];
            numberArray[numberArray.length - 1 - i] = numberArray[i];
            numberArray[i] = tmp;
        }
        return numberArray;
    }
}
