package org.hryciuk.stayinshape.data_structures.array;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix.length == 1) {
            return;
        }

        for (int i = 0; i < matrix.length; ++i) {
            int[] row = matrix[i];
            reverseRow(row);
        }

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length - i; ++j) {
                swapCells(matrix, i, j);
            }
        }
    }

    private void swapCells(int[][] matrix, int i, int j) {
        int firstCell = matrix[i][j];
        int secondCell = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
        int tmp = firstCell;
        matrix[i][j] = secondCell;
        matrix[matrix.length - 1 - j][matrix.length - 1 - i] = tmp;
    }

    private void reverseRow(int[] row) {
        int lo = 0;
        int hi = row.length - 1;
        while (lo < hi) {
            int tmp = row[lo];
            row[lo] = row[hi];
            row[hi] = tmp;
            lo++;
            hi--;
        }
    }
}
