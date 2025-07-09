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
    boolean found = false;
    public void dfs(TreeNode root, int currSum,  int targetSum){
        if(root==null) return;

        currSum = currSum + root.val;

        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                found = true;
                return;
            }
        }

        dfs(root.left, currSum, targetSum);
        dfs(root.right, currSum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return found;
    }
}