/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxi = 0;
    public void solve(TreeNode root, int h){
        if(root==null) return;
        
        maxi = Math.max(maxi,h);
        solve(root.left, h + 1);
        solve(root.right, h + 1);
    }
    public int maxDepth(TreeNode root) {
        // if(root==null) return 0;
        solve(root,1);

        return maxi;
        // int left = maxDepth(root.left);
        // int right = maxDepth(root.right);
        // return Math.max(left, right) + 1;
    }
}