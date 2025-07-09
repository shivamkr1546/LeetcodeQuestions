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
    String smallest = null;

    public void dfs(TreeNode root, StringBuilder path){
        if(root==null) return;

        path.insert(0, (char) ('a' + root.val));

        if(root.left == null && root.right == null){
            String curr = path.toString();
            if(smallest == null || curr.compareTo(smallest) < 0){
                smallest = curr;
            }
        }

        dfs(root.left, path);
        dfs(root.right, path);

        path.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }
}