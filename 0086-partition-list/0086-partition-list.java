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
    public ListNode partition(ListNode head, int x) {
        
        ListNode low = new ListNode(0);
        ListNode high = new ListNode(0);

        ListNode templow = low;
        ListNode temphigh = high;

        ListNode temp = head;

        while(temp != null){
            if(temp.val < x){
                templow.next = temp;
                temp = temp.next;
                templow = templow.next;
            }else{
                temphigh.next = temp;
                temp = temp.next;
                temphigh = temphigh.next;
            }
        }

        templow.next = high.next;
        temphigh.next = null;

        return low.next;
    }
}