package org.hryciuk.stayinshape.data_structures.array;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroesConstantSpace(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    setRowToZero(matrix, i);
                    setColumnToZero(matrix, j);
                }
            }
        }

    }

    private void setRowToZero(int[][] matrix, int i) {
        for (int j = 0; j < matrix[0].length; ++j) {
            matrix[i][j] = 0;
        }
    }

    private void setColumnToZero(int[][] matrix, int j) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i][j] = 0;
        }
    }

    // time O (m * n)
    // space O(m + n)
    public void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (int row : rows) {
            for (int i = 0; i < matrix[0].length; ++i) {
                matrix[row][i] = 0;
            }
        }
        for (int col : columns) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][col] = 0;
            }
        }
    }
}
