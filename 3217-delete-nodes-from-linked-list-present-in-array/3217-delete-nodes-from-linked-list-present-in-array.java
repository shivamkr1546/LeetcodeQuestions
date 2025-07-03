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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> toDel = new HashSet<>();
        for(var num: nums){
            toDel.add(num);
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy;

        while(curr != null){
            ListNode nextNode = curr.next;
            if(toDel.contains(curr.val)){
                prev.next = prev.next.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}