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
    public void leafNode(TreeNode root, List<Integer> arr){
        if(root == null) return;

        if(root.left==null && root.right==null){
            arr.add(root.val);
        }
        leafNode(root.left,arr);
        leafNode(root.right,arr);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        leafNode(root1,arr1);
        leafNode(root2,arr2);

        return arr1.equals(arr2);
    }
}