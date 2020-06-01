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
        if (s.isEmpty()) {
            return true;
        }
        char[] charArray = s.toCharArray();
        int head = 0;
        int tail = s.length() - 1;
        while (head <= tail) {
            char headChar = charArray[head];
            char tailChar = charArray[tail];
            if (!Character.isLetterOrDigit(headChar)) {
                head++;
            } else if (!Character.isLetterOrDigit(tailChar)) {
                tail--;
            } else {
                if (Character.toLowerCase(charArray[head]) != Character.toLowerCase(charArray[tail])) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}
