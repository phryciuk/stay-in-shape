package org.hryciuk.stayinshape.box;

public class Box2 {
    public static String compressWord(String word, int k) {
        if (word == null || word.length() == 0) {
            return word;
        }
        char[] asArray = word.toCharArray();
        int startOfWindow = 0;
        for (int endOfWindow = 0; endOfWindow < word.length(); ++endOfWindow) {
            if (endOfWindow - startOfWindow + 1 >= k) {
                boolean wordShortened = false;
                while (endOfWindow - startOfWindow + 1 >= k) {
                    if (allLettersMatch(asArray, startOfWindow, endOfWindow)) {
                        word = word.substring(0, startOfWindow) + "" + word.substring(endOfWindow + 1);
                        wordShortened = true;
                        break;
                    } else {
                        startOfWindow++;
                    }
                }
                if (wordShortened) {
                    asArray = word.toCharArray();
                    startOfWindow = 0;
                    endOfWindow = -1;
                }
            }
        }
        return word;
    }

    private static boolean allLettersMatch(char[] wordAsArray, int start, int end) {
        char firstOne = wordAsArray[start];
        for (int i = start; i < end + 1; i++) {
            if (wordAsArray[i] != firstOne) {
                return false;
            }
        }
        return true;
    }
}