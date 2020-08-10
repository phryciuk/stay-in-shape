package org.hryciuk.stayinshape.dynamic_programming;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://app.codility.com/programmers/task/max_path_from_the_left_top_corner/
 *

 You are given a matrix A consisting of N rows and M columns, where each cell contains a digit.
 Your task is to find a continuous sequence of neighbouring cells,
 starting in the top-left corner and ending in the bottom-right corner (going only down and right),
 that creates the biggest possible integer by concatenation of digits on the path.
 By neighbouring cells we mean cells that have exactly one common side.

 Write a function:

 class Solution { public String solution(int[][] A); }

 that, given matrix A consisting of N rows and M columns, returns a string which represents the sequence of cells that we should pick to obtain the biggest possible integer.

 For example, given the following matrix A:

 [9 9 7] [9 7 2] [6 9 5] [9 1 2]

 the function should return "997952", because you can obtain such a sequence by choosing a path as shown below:

 [9 9 *] [* 7 *] [* 9 5] [* * 2]

 Write an efficient algorithm for the following assumptions:

 N and M are integers within the range [1..1,000];
 each element of matrix A is an integer within the range [1..9].
 */
public class MaxPathFromTheLeftTopCorner {

    private Deque<Point> path = new LinkedList<>(); // stack

    String maxPath(int[][] arr) {
        String[][] helper = new String[arr.length][arr[0].length];
        helper[0][0] = String.valueOf(arr[0][0]);

        StringBuilder sb = new StringBuilder();

        // let's fill the first row first
        for (int i = 1; i < arr[0].length; ++i) {
            sb.setLength(0); // clearing out the stringbuffer
            sb.append(helper[0][i - 1]).append(arr[0][i]);
            helper[0][i] = sb.toString();
        }

        // let's fill the first column
        for (int i = 1 ; i < arr.length; ++i) {
            sb.setLength(0);
            sb.append(helper[i - 1][0]).append(arr[i][0]);
            helper[i][0] = sb.toString();
        }

        // let's fill the rest of the columns
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 1; j < arr[0].length; ++j) {
                sb.setLength(0);
                String firstOption = helper[i - 1][j];
                String secondOption = helper[i][j - 1];
                String max = Integer.parseInt(firstOption) > Integer.parseInt(secondOption) ? firstOption : secondOption;
                sb.append(max).append(arr[i][j]);
                helper[i][j] = sb.toString();
            }
       }

        Point point = new Point(arr.length - 1, arr[0].length - 1);
        path.push(point);
        while(point.i != -1 && point.j != -1) {
            point = findLargestPredecessor(point.i, point.j, arr, helper);
        }
        sb.setLength(0);
        while (!path.isEmpty()) {
            Point pop = path.pop();
            sb.append(arr[pop.i][pop.j]);
        }

        return sb.toString();
    }
    Point findLargestPredecessor(int i, int j, int[][] arr, String[][] helper) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || (i == 0 && j == 0)) {
            Point point = new Point(-1, -1);
            return point;
        }
        // look left
        int left =  j - 1 >= 0 ? Integer.parseInt(helper[i][j - 1]) : -1;
        // look up
        int up = i - 1 >= 0 ? Integer.parseInt(helper[i - 1][j]) : -1;

        Point point;
        if (left > up) {
            point = new Point(i, j - 1);
        } else {
            point = new Point(i - 1, j);
        }
        path.push(point);
        return point;
    }

    class Point {
        int i;
        int j;

        Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
