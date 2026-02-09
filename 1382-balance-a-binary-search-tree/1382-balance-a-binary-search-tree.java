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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        TreeNode newRoot = constructTree(arr, 0, arr.size() - 1);
        return newRoot;
    }

    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return;

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
    }

    public TreeNode constructTree(ArrayList<Integer> arr, int st, int end){
        if(st > end){
            return null;
        }

        int mid = (st+end)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = constructTree(arr, st, mid - 1);
        root.right = constructTree(arr, mid + 1, end);

        return root;
    }
}