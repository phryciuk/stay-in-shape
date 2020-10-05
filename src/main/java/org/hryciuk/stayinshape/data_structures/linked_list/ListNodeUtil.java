package org.hryciuk.stayinshape.data_structures.linked_list;

public class ListNodeUtil {

    public static ListNode createListNode(int[] arr) {
        ListNode prev = new ListNode();
        ListNode start = prev;
        for (int i = 0; i < arr.length; ++i) {
            int val = arr[i];
            ListNode current = new ListNode(val);
            prev.next = current;
            prev = current;
        }
        return start.next;
    }

    public static ListNode[] createArrayOfLists(int[][] lists) {
        ListNode[] result = new ListNode[lists.length];
        for (int i = 0; i < lists.length; ++i) {
            int[] currentList = lists[i];
            if (currentList == null || currentList.length == 0) {
                continue;
            } else {
                ListNode listNode = createListNode(currentList);
                result[i] = listNode;
            }
        }
        return result;
    }

    public static boolean equal(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return true;
        }
        if (l1 == null || l2 == null) {
            return false;
        } else {
            ListNode first = l1;
            ListNode second = l2;
            while (first != null && second != null) {
                if (first.val != second.val) {
                    return false;
                }
                first = first.next;
                second = second.next;
            }
            return first == null && second == null;
        }
     }
}
