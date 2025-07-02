/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // Merge two sorted linked lists
    public ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;

        while (l1 != null && l2 != null) {
            // Attach smaller node to merged list
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining nodes
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // Merge k sorted linked lists using pairwise merging
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Keep merging pairs until one list remains
        while (lists.length > 1) {
            List<ListNode> merged = new ArrayList<>();

            // Merge lists in pairs
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i + 1] : null;
                merged.add(mergeTwo(l1, l2));
            }

            // Convert back to array for next iteration
            lists = merged.toArray(new ListNode[0]);
        }

        return lists[0];
    }
}
