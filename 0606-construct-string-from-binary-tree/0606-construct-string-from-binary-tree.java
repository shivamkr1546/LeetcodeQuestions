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
    public String tree2str(TreeNode root) {
        return traverse(root);
    }

    public String traverse(TreeNode root){
        if(root == null) return "";


        String res = Integer.toString(root.val);
        
        String left = traverse(root.left);
        String right = traverse(root.right);

        if(root.left == null && root.right == null) return res;

        if(root.right == null) return res + "(" + left + ")";

        if(root.left == null) return res + "()" + "(" + right + ")";

        return res + "(" + left + ")" + "(" + right + ")";
    }
}