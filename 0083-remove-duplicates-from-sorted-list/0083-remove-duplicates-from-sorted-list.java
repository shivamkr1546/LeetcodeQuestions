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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null) return head;
        ListNode a = head;
        ListNode b = head.next;
        while(b!=null){
            while(b!=null && b.val==a.val){
                b = b.next;
            }
            a.next = b;
            //for next round update a and b
            a = b;
            if(b!=null) b=b.next;
        }
        return head;
    }
}