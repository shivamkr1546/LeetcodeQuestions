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
    public void treePaths(TreeNode node, String path, List<String> res){
        if(node==null) return;

        path += node.val;

        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        path += "->";

        treePaths(node.left,path, res);
        treePaths(node.right,path, res);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        
        treePaths(root, "", res);
        return res;
    }
}