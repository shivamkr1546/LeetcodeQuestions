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
    public void dfs(TreeNode root, int currSum, int targetSum, List<List<Integer>> res, List<Integer> path){
        if(root == null) return;

        currSum = currSum + root.val;
        path.add(root.val);

        if(root.left == null && root.right == null && targetSum == currSum){
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, currSum, targetSum, res, path);
        dfs(root.right, currSum, targetSum, res, path);

        path.remove(path.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, 0, targetSum, res, path);
        return res;
    }
}