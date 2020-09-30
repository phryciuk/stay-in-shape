package org.hryciuk.stayinshape.strings;

public class RansomNote {

    public boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
        if (magazine == null || magazine.length() == 0) {
            return false;
        }
        char[] magazineChars = magazine.toCharArray();

        int[] occurrences = new int[26];
        for (int i = 0; i < magazineChars.length; ++i) {
            occurrences[magazineChars[i] - 'a']++;
        }

        char[] ransomNoteChars = ransomNote.toCharArray();
        for (int i = 0; i < ransomNoteChars.length; ++i) {
            if (--occurrences[ransomNoteChars[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
        if (magazine == null || magazine.length() == 0) {
            return false;
        }
        char[] charArr = magazine.toCharArray();
        int[] occurrences = new int[26];
        for (int i = 0; i < charArr.length; ++i) {
            occurrences[charArr[i] - 'a']++;
        }

        char[] ransomChars = ransomNote.toCharArray();
        for (int i = 0; i < ransomChars.length; ++i) {
            occurrences[ransomChars[i] - 'a']--;
        }
        return couldBeConstructed(occurrences);
    }

    private boolean couldBeConstructed(int[] occurrences) {
        for (int i = 0; i < occurrences.length; ++i) {
            if (occurrences[i] < 0) {
                return false;
            }
        }
        return true;
    }

}
