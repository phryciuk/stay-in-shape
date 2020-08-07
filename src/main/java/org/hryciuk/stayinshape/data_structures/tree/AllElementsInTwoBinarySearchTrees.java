package org.hryciuk.stayinshape.data_structures.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {

    // Time: O(n), where n is the total number of nodes in both trees.
    // Memory: O(n) for the stack - in the worst case, we may need to store the entire tree there.
    public List<Integer> getAllElements2Stacks(TreeNode root1, TreeNode root2) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();

        TreeNode current1 = root1;
        TreeNode current2 = root2;

        while (!stack1.isEmpty() || !stack2.isEmpty() || current1 != null || current2 != null) {
            // go to the left of tree 1
            while (current1 != null) {
                stack1.push(current1);
                current1 = current1.left;
            }

            // go to the left of tree 2
            while (current2 != null) {
                stack2.push(current2);
                current2 = current2.left;
            }

            // if there are elements only in stack1 or in both stacks but peek of stack1 is smaller
            if (stack2.isEmpty() || !stack1.isEmpty() && stack1.peek().val <= stack2.peek().val) {
                current1 = stack1.pop();
                result.add(current1.val);
                current1 = current1.right;
            } else {
                current2 = stack2.pop();
                result.add(current2.val);
                current2 = current2.right;
            }
        }
        return result;
    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> first = dfs(root1);
        List<Integer> second = dfs(root2);
        List<Integer> resultant = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (i < first.size() || j < second.size()) {
            if (i < first.size() && j < second.size()) {
                int firstCurrent = first.get(i);
                int secondCurrent = second.get(j);
                if (firstCurrent < secondCurrent) {
                    resultant.add(firstCurrent);
                    i++;
                } else {
                    resultant.add(secondCurrent);
                    j++;
                }
            } else if (i < first.size()) {
                int firstCurrent = first.get(i);
                resultant.add(firstCurrent);
                i++;
            } else {
                int secondCurrent = second.get(j);
                resultant.add(secondCurrent);
                j++;
            }
        }
        return resultant;
    }

    private List<Integer> dfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> left = dfs(root.left);
        result.addAll(left);
        result.add(root.val);
        List<Integer> right = dfs(root.right);
        result.addAll(right);
        return result;
    }
}
