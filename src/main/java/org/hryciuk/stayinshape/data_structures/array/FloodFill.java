package org.hryciuk.stayinshape.data_structures.array;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        int currentColor = image[sr][sc];
        dfs(image, sr, sc, newColor, currentColor);
        return image;

    }

    private void dfs(int[][] image, int i, int j, int newColor, int currentColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] == newColor || image[i][j] != currentColor) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i - 1, j, newColor, currentColor);
        dfs(image, i + 1, j, newColor, currentColor);
        dfs(image, i, j - 1, newColor, currentColor);
        dfs(image, i, j + 1, newColor, currentColor);
    }
}
