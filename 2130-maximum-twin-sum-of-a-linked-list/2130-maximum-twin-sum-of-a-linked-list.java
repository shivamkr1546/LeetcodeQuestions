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
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int l = 0;
        int r = list.size() - 1;
        int maxSum = Integer.MIN_VALUE;
        while(l<=r){
            int sum = list.get(l) + list.get(r);
            maxSum = Math.max(maxSum, sum);
            l++;
            r--;
        }
        
        return maxSum;
    }
}