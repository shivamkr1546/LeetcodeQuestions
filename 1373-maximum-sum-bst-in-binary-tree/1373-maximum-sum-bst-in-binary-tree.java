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
    static class info{
        boolean isBST;
        int sum;
        int min;
        int max;

        public info(boolean isBST, int sum, int min, int max){
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxSum = 0;

    public static info maxSum(TreeNode root){
        if(root==null){
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        info leftinfo = maxSum(root.left);
        info rightinfo = maxSum(root.right);

        int sum = leftinfo.sum + rightinfo.sum + root.val;
        int min = Math.min(root.val, Math.min(leftinfo.min, rightinfo.min));
        int max = Math.max(root.val, Math.max(leftinfo.max, rightinfo.max));

        // if(leftinfo.isBST && rightinfo.isBST && root.val > leftinfo.max && root.val < rightinfo.min){
        //     return new info(true, sum, min, max);
        // }

        if(root.val <= leftinfo.max || root.val >= rightinfo.min){
            return new info(false, sum, min, max);
        }

        if(leftinfo.isBST && rightinfo.isBST){
            maxSum = Math.max(maxSum, sum);
            return new info(true, sum, min, max);
        }

        return new info(false, sum, min, max);
    }
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        maxSum(root);
        return maxSum;
    }
}