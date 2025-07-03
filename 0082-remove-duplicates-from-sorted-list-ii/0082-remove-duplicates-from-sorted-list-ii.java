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
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        ListNode temp = head;

        while(temp != null){
            if(temp.next != null && temp.val == temp.next.val){
                int dupVal = temp.val;
                while(temp != null && temp.val == dupVal){
                    temp = temp.next;
                }
            }else{
                ptr.next = temp;
                temp = temp.next;
                ptr = ptr.next;
                ptr.next = null;
            }
            
        }

        return dummy.next;
    }
}