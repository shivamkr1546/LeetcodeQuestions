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
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        ListNode temp = head;
        int total = 0, carry = 0;
        while(temp!=null || carry!=0){
            total = carry;
            if(temp!=null){
                total += temp.val*2;
                temp = temp.next;
            }

            int num = total % 10;
            carry = total / 10;
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return reverse(dummyHead.next);
    }
}