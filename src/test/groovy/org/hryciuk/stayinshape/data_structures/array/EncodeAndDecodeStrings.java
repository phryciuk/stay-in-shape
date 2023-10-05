package org.hryciuk.stayinshape.data_structures.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Please implement encode and decode
 *
 * Only $39.9 for the "Twitter Comment System Project Practice" within a limited time of 7 days!
 *
 * WeChat Notes Twitter for more information（WeChat ID jiuzhang104）
 * Example
 *
 * Example1
 *
 * Input: ["lint","code","love","you"]
 *
 * Output: ["lint","code","love","you"]
 *
 * Explanation:
 *
 * One possible encode method is: "lint:;code:;love:;you"
 *
 * Example2
 *
 * Input: ["we", "say", ":", "yes"]
 *
 * Output: ["we", "say", ":", "yes"]
 *
 * Explanation:
 *
 * One possible encode method is: "we:;say:;:::;yes"
 */
public class EncodeAndDecodeStrings {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        char[] arr = str.toCharArray();
        int i = 0;

        List<String> result = new ArrayList<>();
        while (i < arr.length) {
            int j = i;
            while (arr[j] != '#') {
                j++;
            }
            int noOfChars = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + noOfChars + 1));
            i = j + noOfChars + 1;
        }
        return result;
    }
}
