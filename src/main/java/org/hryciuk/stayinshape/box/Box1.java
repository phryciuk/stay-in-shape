package org.hryciuk.stayinshape.box;

public class Box1 {

    public int programmerStrings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int oneWordLength = "programmer".length();
        int endOfFirstWindow = s.length() - 1;
        int startOfSecondWindow = 0;

        int[] programmerChars = createProgrammerArray();
        for (int i = 0; i < s.length(); ++i) {
            char current = s.charAt(i);
            programmerChars[current - 'a']--;
            if (i >= oneWordLength - 1) {
                boolean oneWordCompleted = allLettersUsed(programmerChars);
                if (oneWordCompleted) {
                    endOfFirstWindow = i;
                    break;
                }
            }
        }
        // now from the end
        programmerChars = createProgrammerArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            char current = s.charAt(i);
            programmerChars[current - 'a']--;
            if (i <= s.length() - oneWordLength) {
                boolean allLettersUsed = allLettersUsed(programmerChars);
                if (allLettersUsed) {
                    startOfSecondWindow = i;
                    break;
                }
            }

        }
        return startOfSecondWindow - endOfFirstWindow - 1;
    }

    private boolean allLettersUsed(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private int[] createProgrammerArray() {
        int[] occurrences = new int[26];
        char[] programmerArray = "programmer".toCharArray();
        for (int i = 0; i < programmerArray.length; ++i) {
            occurrences[programmerArray[i] - 'a']++;
        }
        return occurrences;
    }

}
