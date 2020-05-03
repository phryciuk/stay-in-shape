package org.hryciuk.stayinshape.data_structures.array;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * <p>
 * Explanation:
 * 1234
 * 5123
 * 9512
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * <p>
 * <p>
 * Note:
 * matrix will be a 2D array of integers.
 * matrix will have a number of rows and columns in range [1, 20].
 * matrix[i][j] will be integers in range [0, 99].
 */
class ToeplitzMatrix {

  public boolean isToeplitzMatrix(int[][] matrix) {
    int columns = matrix.length;
    int rows = matrix[0].length;

    for (int i = 0; i < columns; ++i) {
      for (int j = 0; j < rows; ++j) {
        int val = matrix[i][j];
        // sprawdzamy czy wartość w następnym elemencie przekątnej jest właściwa
        if (i + 1 < columns && j + 1 < rows && val != matrix[i + 1][j + 1]) {
          return false;
        }
      }
    }
    return true;
  }
}
