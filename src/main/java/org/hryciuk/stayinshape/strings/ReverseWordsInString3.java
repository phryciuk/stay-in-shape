package org.hryciuk.stayinshape.strings;

/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 *
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note: In the string, each word is separated by single space and
 * there will not be any extra space in the string.
 */
public class ReverseWordsInString3 {
    public String reverseWords(String s) {
        // 1. Split the sentence into words
        String[] words = s.split(" ");

        // 2. for each word, reverse letters and save it back to words array
        for (int k = 0; k < words.length; ++k) {
            char[] letters = words[k].toCharArray();
            for (int i = 0, j = letters.length - 1; i < j; ++i, --j) {
                char tmp = letters[i];
                letters[i] = letters[j];
                letters[j] = tmp;
            }
            words[k] = new String(letters);
        }

        // 3. build resultant string
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            stringBuilder.append(words[i]);
            if (i != words.length - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
