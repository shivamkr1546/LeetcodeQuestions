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
    public ListNode mergeTwo(ListNode list1, ListNode list2) {
        
        ListNode c = new ListNode(0);
        ListNode temp = c;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        if(list1==null) temp.next = list2;
        else temp.next = list1;
        return c.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        while(lists.length>1){
            ArrayList<ListNode> arr = new ArrayList<>();
            for(int i=0; i<lists.length; i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = null;
                if(i+1 < lists.length){
                    l2 = lists[i+1];
                }
                arr.add(mergeTwo(l1,l2));
            }
             lists = arr.toArray(new ListNode[0]);
        }

        return lists[0];
    }
}