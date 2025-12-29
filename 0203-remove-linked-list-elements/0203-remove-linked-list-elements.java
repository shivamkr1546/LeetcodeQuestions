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
    public ListNode removeElements(ListNode head, int val) {
        //Iterative Approach

        // if(head == null) return null;
        // if(head.next == null && head.val == val) return null;

        // ListNode dummy = new ListNode();
        // dummy.next = head;
        // ListNode prev = dummy;
        // ListNode curr = head;

        // while(curr!=null){
        //     if(curr.val==val){
        //         prev.next = prev.next.next;
        //     }else{
        //         prev = curr;
        //     }
        //     curr = curr.next;
        // }

        // return dummy.next;

        //recursive approach
        if(head == null){
            return null;
        }

        head.next = removeElements(head.next, val);

        if(head.val == val){
            return head.next;
        }
        return head;
    }
}