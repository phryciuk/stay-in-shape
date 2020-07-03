package org.hryciuk.stayinshape.data_structures.array;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int val = numbers[i];
            int toFind = target - val;
            int index = bstIndexOfPartner(numbers, i + 1, toFind);
            if (index != -1) {
                int[] result = new int[2];
                result[0] = i + 1;
                result[1] = index + 1;
                return result;
            }
        }
        return null;
    }

    int bstIndexOfPartner(int[] numbers, int lo, int toFind) {
        int hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (numbers[mid] > toFind) {
                hi = mid - 1;
            } else if (numbers[mid] < toFind) {
                lo = mid;
            } else {
                return mid;
            }
        }
        return numbers[lo] == toFind ? lo : -1;
    }
}
