package org.hryciuk.stayinshape.data_structures.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/discuss/interview-question/645247/Toptal-or-OA-2020-or-Biggest-Integer-in-a-Matrix
 *
 * You are given a board of N rows and M columns. Each field of the board contains a single digit (0−9).
 *
 * You want to find a path consisting of four neighboring fields. Two fields are neighboring if they share a common side. Also, the fields in your path should be distinct (you can't visit the same field twice).
 *
 * The four digits of your path, in the order in which you visit them, create an integer. What is the biggest integer that you can achieve in this way?
 *
 * Write a function
 *
 * class Solution { public int solution(int[][] Board); }
 *
 * that, given the board represented as a matrix of integers consisting of N rows and M columns, returns the biggest integer that you can achieve when concatenating the values in a path of length four.
 *
 * Examples:
 *
 *     Given the following board (N=3, M=5):
 *
 *     the function should return 9121. You can choose either of the following paths (the first field is denoted by red):
 *
 * online assessmentTopTal
 */
public class BiggestIntegerInMatrix {

    private int largestDigit = -1;
    private Map<Integer, List<Point>> map = new HashMap<>();
    private int max = -1;

    public int solution(int[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        findLargestElement(0,0, board, visited);
        List<Point> points = map.get(largestDigit);
        for (Point point : points) {
            visited = new boolean[board.length][board[0].length];
            dfs(point.i, point.j, board, visited, 1, "" + board[point.i][point.j]);
        }
        return max;
    }

    private void findLargestElement(int i, int j, int[][] board, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        if (!visited[i][j] && board[i][j] > largestDigit) {
            largestDigit = board[i][j];
            map.clear();
            ArrayList<Point> list = new ArrayList<>();
            Point point = new Point(i, j);
            list.add(point);
            map.put(largestDigit, map.getOrDefault(largestDigit, list));
        } else if (board[i][j] == largestDigit) {
            List<Point> points = map.get(largestDigit);
            points.add(new Point(i, j));
        }
        visited[i][j] = true;
        findLargestElement(i - 1, j, board, visited);
        findLargestElement(i, j + 1, board, visited);
        findLargestElement(i + 1, j, board, visited);
        findLargestElement(i, j - 1, board, visited);
    }

    private void dfs(int i, int j, int[][] board, boolean[][] visited, int count, String current) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (count == 4) {
            max = Math.max(max, Integer.parseInt(current));
            visited[i][j] = false; // we need to clear this off when returning
            return;
        }
        // down
        if (i - 1 >= 0) {
            dfs(i - 1, j, board, visited, count + 1, current + board[i - 1][j]);
        }
        // right
        if (j + 1 < board[0].length) {
            dfs(i, j + 1, board, visited, count + 1, current + board[i][j + 1]);
        }
        // up
        if (i + 1 < board.length) {
            dfs(i + 1, j, board, visited, count + 1, current + board[i + 1][j]);
        }
        // left
        if (j - 1 >= 0) {
            dfs(i, j - 1, board, visited, count + 1, current + board[i][j - 1]);
        }
        visited[i][j] = false; // we need to clear this off when returning
    }
}

class Point {

    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    int i;
    int j;
}
