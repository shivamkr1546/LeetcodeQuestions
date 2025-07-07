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
    static int sum = 0;
    public void calSum(TreeNode root) {
        if(root == null) return;
        
        if(root.left!=null && root.left.left == null && root.left.right == null){
            sum+=root.left.val;
        }
        calSum(root.left);
        calSum(root.right);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        calSum(root);
        return sum;
    }
}