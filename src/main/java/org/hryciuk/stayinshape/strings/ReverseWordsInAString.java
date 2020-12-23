package org.hryciuk.stayinshape.strings;

import java.util.Arrays;
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

    public String reverseWordsInAString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        reverse2(arr, 0, arr.length - 1);
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            while (i < arr.length && arr[i] == ' ') {
                i++;
            }
            int start = i;
            while (i < arr.length && arr[i] != ' ') {
                i++;
            }
            i = i - 1;
            int end = i;
            reverse2(arr, start, end);
        }
        int resultIndex = 0;
        int index = 0;
        // remove entry spaces
        while (index < arr.length && arr[index] == ' ') {
            index++;
        }
        // now index is at first char of a word
        while (index < arr.length) {
            int start = index;
            while(index < arr.length && arr[index] != ' ') {
                result[resultIndex++] = arr[index];
                index++;
            }
            // now the index is right after the last word, and it is on space
            // remove spaces in between words
            while (index < arr.length && arr[index] == ' ') {
                result[resultIndex] = ' ';
                index++;
            }
            resultIndex++;
        }

        return new String(Arrays.copyOfRange(result, 0, resultIndex - 1));
    }


    private void reverse2(char[] arr, int lo, int hi) {
        while (lo < hi) {
            char tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            lo++;
            hi--;
        }
    }
}
