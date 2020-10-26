package org.hryciuk.stayinshape.sachs;

import java.util.*;

public class Interview {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
        Integer[] first = new Integer[3];
        Integer[] second = new Integer[4];
        Integer[] third = new Integer[5];

        instantiateArray(first);
        instantiateArray(second);
        instantiateArray(third);

        LinkedList<Integer[]> list = new LinkedList<>();
        list.add(first);
        list.add(second);
        list.add(third);

        int[] result = mergeNArrays(list);
        System.out.println("Result: " + Arrays.toString(result));
    }



    // BST. based on n we want to return possible binary search trees
    // 1 -> 1
    // 2 -> 2
    // 3 -> 5
    // keep track of previously visited nodes
    // [1,2,3,4,5]
    //
    //     current [1] ; remainder[2,3,4,5]
    //
    // choose (2) || choose(3) || *choose (4)* || choose(5)
    //
    //     currentBst[1,4] //
    //       current [4] ; remainder[2,3,5]

    // Time: O(n) + O(n) ==> O(n)
    // Space: O(n) + O(n) ==> O(n)
    // n = array1.length + array2.length + ...
    private static int[] mergeNArrays(List<Integer[]> arrays) {
        if (arrays == null || arrays.size() == 0) {
            return new int[0];
        }
        // O(n) linear space
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // adding elemensts from each array to the heap

        // O(n) linear in time

        // O(n * log(n))
        for (Integer[] arr : arrays) { // O(n)
            for (int i = 0; i < arr.length; ++i) {
                int current = arr[i];
                heap.add(current); // log(n)
            }
        }

        int size = heap.size();
        // O(n)
        int[] result = new int[size];
        int i = 0;
        // O(n) linear in time
        while(!heap.isEmpty()) {
            int top = heap.poll();
            result[i] = top;
            i++;
        }
        return result;
    }

    private static void instantiateArray(Integer[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = i;
        }
    }


}

