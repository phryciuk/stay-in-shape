package org.hryciuk.stayinshape.data_structures.array;

public class TwoSumIIInputArrayIsSorted {

    public int[] twoSumSimpler(int[] numbers, int target) {
        int hi = numbers.length - 1;
        int lo = 0;
        int sum = numbers[lo] + numbers[hi];
        while (sum != target) {
            if (sum > target) {
                hi--;
            } else {
                lo++;
            }
            sum = numbers[lo] + numbers[hi];
        }
        return new int[] {lo + 1, hi + 1};
    }

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
