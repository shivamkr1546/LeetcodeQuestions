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

        head = reverse(head);

        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        ListNode curr = head;
        int max = curr.val;

        while(curr!=null){
            if(curr.val >= max){
                temp.next = curr;
                temp = temp.next;
                max = curr.val;
            }
            curr = curr.next;
        }
        temp.next = null;

        return reverse(dummy.next);
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

}