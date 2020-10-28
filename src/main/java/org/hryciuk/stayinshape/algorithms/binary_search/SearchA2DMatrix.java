package org.hryciuk.stayinshape.algorithms.binary_search;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        return binarySearch(matrix, target);
    }

    private boolean binarySearch(int[][] nums, int target) {
        int rows = nums.length;
        int columns = nums[0].length;
        int lo = 0;
        int hi = rows * columns - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > nums[mid / columns][mid % columns]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo / columns][lo % columns] == target;
    }
}
