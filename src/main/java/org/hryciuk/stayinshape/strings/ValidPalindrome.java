package org.hryciuk.stayinshape.strings;

/**
 * 125. Valid Palindrome
 * Easy
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            char front = arr[lo];
            char back = arr[hi];
            if (!Character.isLetterOrDigit(front)) {
                lo++;
                continue;
            }
            if (!Character.isLetterOrDigit(back)) {
                hi--;
                continue;
            }
            if (front != back) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
