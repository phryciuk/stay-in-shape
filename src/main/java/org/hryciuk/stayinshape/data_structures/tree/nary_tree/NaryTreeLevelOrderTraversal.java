package org.hryciuk.stayinshape.data_structures.tree.nary_tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subresult = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node current = q.poll();
                if (current.children != null && !current.children.isEmpty()) {
                    for (int j = 0; j < current.children.size(); ++j) {
                        q.offer(current.children.get(j));
                    }
                }
                subresult.add(current.val);
            }
            result.add(subresult);
        }
        return result;
    }
}
