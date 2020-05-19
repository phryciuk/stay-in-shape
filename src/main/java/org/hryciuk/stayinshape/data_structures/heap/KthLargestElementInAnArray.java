package org.hryciuk.stayinshape.data_structures.heap;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * <p>
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {


    public int findKthLargest(int[] nums, int k) {
        heapify(nums);
        heapSort(nums);
        return nums[k - 1];
    }


    private void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            removeRoot(nums, i);
        }
    }

    private void removeRoot(int[] nums, int index) {
        int lastIndexOfArray = nums.length - 1;
        int currentIndex = 0;
        swap(0, lastIndexOfArray - index, nums); // zamieniamy root z ostatnim elementem w stercie. od teraz sterta ma rozmiar o 1 mniejszy
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        int lastIndexOfHeap = lastIndexOfArray - index - 1;
        while (leftChildIndex <= lastIndexOfHeap) {
            if (rightChildIndex <= lastIndexOfHeap && nums[rightChildIndex] < nums[currentIndex] && nums[rightChildIndex] < nums[leftChildIndex]) {
                swap(currentIndex, rightChildIndex, nums);
                currentIndex = rightChildIndex;
            } else if (nums[leftChildIndex] <= nums[currentIndex]) {
                swap(currentIndex, leftChildIndex, nums);
                currentIndex = leftChildIndex;
            } else {
                break;
            }
            leftChildIndex = currentIndex * 2 + 1;
            rightChildIndex = currentIndex * 2 + 2;
        }
    }

    private void swap(int firstIndex, int secondIndex, int[] nums) {
        int nodeValue = nums[firstIndex];
        int tmp = nodeValue;
        int otherValue = nums[secondIndex];
        nums[firstIndex] = otherValue;
        nums[secondIndex] = tmp;
    }

    private void heapify(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int value = nums[i];
            int j = i;
            int parentIndex = (j - 1) / 2;
            while (nums[parentIndex] > value) {
                swap(j, parentIndex, nums);
                j = parentIndex;
                parentIndex = (j - 1) / 2;
            }
        }
    }
}
