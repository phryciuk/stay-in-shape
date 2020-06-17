package org.hryciuk.stayinshape.strings;

public class ToLowerCase {

    public String toLowerCase(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); ++i) {
            char current = str.charAt(i);
            // capital letters are [65;90]
            // lower case letters are [97;122]
            if (current >= 65 && current <= 90) {
                char lowerCased = (char) (current + 32);
                result.append(lowerCased);
            } else {
                result.append(current);
            }
        }
        return result.toString();
    }

}
