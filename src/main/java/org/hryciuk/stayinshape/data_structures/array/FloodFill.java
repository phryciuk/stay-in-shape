package org.hryciuk.stayinshape.data_structures.array;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int currentCol = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        helper(image, currentCol, sr, sc, newColor, visited);
        return image;
    }

    void helper(int[][] image, int currentColor, int row, int col, int newColor, boolean[][] visited) {
        if (row < 0 || row >= image.length || col >= image[0].length || col < 0) {
            return;
        }
        image[row][col] = newColor;
        visited[row][col] = true;
        if (row - 1 >= 0 && !visited[row - 1][col] && image[row - 1][col] == currentColor) {
            helper(image, currentColor, row - 1, col, newColor, visited);
        }
        if (col + 1 < image[0].length && !visited[row][col + 1] && image[row][col + 1] == currentColor) {
            helper(image, currentColor, row, col + 1, newColor, visited);
        }
        if (row + 1 < image.length && !visited[row + 1][col] && image[row + 1][col] == currentColor) {
            helper(image, currentColor, row + 1, col, newColor, visited);
        }
        if (col - 1 >= 0 && !visited[row][col - 1] && image[row][col - 1] == currentColor) {
            helper(image, currentColor, row, col - 1, newColor, visited);
        }
    }
}
