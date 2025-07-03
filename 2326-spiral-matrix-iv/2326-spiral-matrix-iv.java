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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }
        int minr = 0;
        int maxr = m-1;
        int minc = 0;
        int maxc = n-1;
        int cnt = 1;
        ListNode temp = head;
        while(minr<=maxr && minc<=maxc){
            //right
            for(int j=minc; j<=maxc; j++){
                if(temp == null) break;
                arr[minr][j] = temp.val;
                temp = temp.next;
            }
            minr++;
            if(minr>maxr || minc>maxc) break;

            //down
            for(int j=minr; j<=maxr; j++){
                if(temp == null) break;
                arr[j][maxc] = temp.val;
                temp = temp.next;
            }
            maxc--;
            if(minr>maxr || minc>maxc) break;

            //left
            for(int j=maxc; j>=minc; j--){
                if(temp == null) break;
                arr[maxr][j] = temp.val;
                temp = temp.next;
            }
            maxr--;
            if(minr>maxr || minc>maxc) break;

            //up
            for(int j=maxr; j>=minr; j--){
                if(temp == null) break;
                arr[j][minc] = temp.val;
                temp = temp.next;
            }
            minc++;
            if(minr>maxr || minc>maxc) break;
        }
        return arr;
    }
}