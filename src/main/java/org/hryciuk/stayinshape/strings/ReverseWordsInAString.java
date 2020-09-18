package org.hryciuk.stayinshape.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int startOfWord = 0;
        int endOfWord = 0;
        Stack<String> words = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (arr[i] != ' ') {
                while (i < s.length() && arr[i] != ' ') {
                    endOfWord++;
                    i++;
                }
                words.push(s.substring(startOfWord, endOfWord));
            }
            if (i < s.length() && arr[i] == ' ') {
                while(i < s.length() && arr[i] == ' ') {
                    ++i;
                }
            }
            startOfWord = i;
            endOfWord = i;
            i--;
        }

        StringBuilder sb = new StringBuilder();
        while (!words.isEmpty()) {
            sb.append(words.pop());
            if (!words.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
