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

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode head = new ListNode();
        ListNode curr = head;
        int total = 0;
        int carry = 0;

        while(l1!=null || l2!=null || carry != 0){
            total = carry;
            if(l1!=null){
                total += l1.val;
                l1 = l1.next;
            }

            if(l2!=null){
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total/10;
            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return reverse(head.next);
    }
}