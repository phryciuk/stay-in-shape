package org.hryciuk.stayinshape.algorithms.binary_search;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we make sure that nums1 is always smaller
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalNumber = nums1.length + nums2.length;

        int lo = 0; // minimum elements we can pick from A1
        int hi = nums1.length; // maximum elements we can pick from A1

        // cut1 - number of elements we are picking from A1

        // (totalNumber + 1) / 2   - length of first half of the total "merged" array.  In case
        // of odd numbers this will always be bigger. That way we know that median will always be max (l1, l2)k
        while (lo <= hi) {
            int cut1 = lo + (hi - lo) / 2; // cut in smaller array; our MID
            int cut2 = (totalNumber + 1) / 2 - cut1; // cut in larger array

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];

            // cut is at correct place
            if (l1 <= r2 && l2 <= r1) {
                 if (totalNumber % 2 == 0) {
                     return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                 }
                 return Math.max(l1 ,l2);
            } else if (l1 > r2) {
                hi = cut1 - 1;
            } else {
                lo = cut1 + 1;
            }
        }
        return 0;
    }
}
