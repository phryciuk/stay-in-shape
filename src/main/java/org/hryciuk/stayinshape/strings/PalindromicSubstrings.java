package org.hryciuk.stayinshape.strings;

public class PalindromicSubstrings {

    // TO JEST CHYBA MOJA NAJLEPSZA IMPLEMENTACJA PALINDROMOW
    // palindrome is a palindrome if:
    // - it is a single letter
    // - it is a 2 letter word and last and first characters are the same
    // - it is 3 or more letters word and inner part is palindrome and last and first letter are the same
    public int countSubstrings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        char[] charArray = s.toCharArray();

        // setting up a diagonal (single letter)
        for (int i = 0; i < charArray.length; ++i) {
            isPalindrome[i][i] = true;
        }

        // 2 letter word
        for (int i = 1; i < charArray.length; ++i) {
            if (charArray[i - 1] == charArray[i]) {
                isPalindrome[i - 1][i] = true;
            }
        }

        // 3 letter word
        for (int column = 2; column < s.length(); ++column) {
            for (int row = 0; row < column - 1; ++row) {
                if (charArray[row] == charArray[column] && isPalindrome[row + 1][column - 1]) {
                    isPalindrome[row][column] = true;
                }
            }
        }

        // count trues in isPalindrome
        int palindromes = 0;
        for (int column = 0; column < s.length(); ++column) {
            for (int row = 0; row <= column; ++row) {
                if (isPalindrome[row][column]) {
                    palindromes++;
                }
            }
        }
        return palindromes;
    }
}
