package org.hryciuk.stayinshape.strings;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int result = 0;
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        for (int i = 0; i < first.length; ++i) {
            result ^= first[i];
        }

        for (int i = 0; i < second.length; ++i) {
            result ^= second[i];
        }

        return (char) result;
    }
}


