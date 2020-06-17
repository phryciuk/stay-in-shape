package org.hryciuk.stayinshape.strings;

import java.util.Stack;

/**
 * 917. Reverse Only Letters
 * Easy
 *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 *
 *
 *
 * Example 1:
 *
 * Input: "ab-cd"
 * Output: "dc-ba"
 *
 * Example 2:
 *
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Example 3:
 *
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 */
public class ReverseOnlyLetters {
    // Time: O(n)
    // Space: O(n)
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        // we iterate with 2 pointers, one at start, one at end
        for (int i = 0, j = chars.length - 1; i < j; ++i, --j) {
            // we move the left pointer so that it points to the letter
            // and both pointers haven't crossed their paths
            while (!Character.isLetter(chars[i]) && i < j) {
                i++;
            }
            // we move the right pointer so that it points to the letter
            // and both pointers haven't crossed their paths
            while (!Character.isLetter(chars[j]) && i < j) {
                j--;
            }
            if (Character.isLetter(chars[i]) && Character.isLetter(chars[j])) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
            }
        }
        return new String(chars);
    }

    // Time: O(n)
    // Space: O(n)
    public String reverseOnlyLettersUsingStack(String S) {
        // push the letters on the stack so we can easily revert them later on
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; ++i) {
            if (Character.isLetter(chars[i])) {
                stack.push(chars[i]);
            }
        }

        // another iteration; if element is not a letter we leave it as it is,
        // if it is a letter then we replace it with the peek of a stack
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; ++i) {
            char current = chars[i];
            if (!Character.isLetter(current)) {
                stringBuilder.append(current);
            } else {
                stringBuilder.append(stack.pop());
            }
        }
        return stringBuilder.toString();
    }

}
