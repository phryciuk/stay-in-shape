package org.hryciuk.stayinshape.data_structures.array;

public class MergeSortedArray {
    // We start off from ends of both arrays, and we put the biggest element at the end of the array
    public void merge(int[] nums1, int[] nums2, int m, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int finished = m + n - 1;

        // this will also work if nums2 is empty; then nums1 is resultant array
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished] = nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--];
            finished--;
        }

        // if nums1 is empty, we need to copy nums2 to nums1
        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }
}
