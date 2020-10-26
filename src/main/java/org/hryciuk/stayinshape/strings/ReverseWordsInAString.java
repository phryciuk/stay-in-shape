package org.hryciuk.stayinshape.strings;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

    public String reverseWordsConstantSpace(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        char[] arr = s.toCharArray();
        reverse(arr, 0, s.length() - 1);
        for (int i = 0; i < arr.length; ++i) {
            int start = i;
            while (i < arr.length && arr[i] != ' ') {
                i++;
            }
            if (start != i) {
                reverse(arr, start, i - 1);
            }
            while (i < arr.length && arr[i] == ' ') {
                i++;
            }
            i--;
        }
        return cleanSpaces(arr, arr.length);
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    private void reverse(char[] arr, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }

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
