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
    public ListNode removeNodes(ListNode head) {
    if (head == null || head.next == null) return head;

    head = reverseList(head);

    ListNode dummy = new ListNode(0);
    ListNode temp = dummy;
    ListNode curr = head;
    int max = curr.val;

    while (curr != null) {
        if (curr.val >= max) {
            max = curr.val;
            temp.next = curr;
            temp = temp.next;
        }
        curr = curr.next;
    }

    // Important: cut off extra nodes
    temp.next = null;

    return reverseList(dummy.next);
}

private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}

}