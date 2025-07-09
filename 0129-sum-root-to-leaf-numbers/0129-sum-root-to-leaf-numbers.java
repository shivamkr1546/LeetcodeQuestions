class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int currentNumber) {
        if (node == null) return 0;

        currentNumber = currentNumber * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        int leftSum = helper(node.left, currentNumber);
        int rightSum = helper(node.right, currentNumber);

        return leftSum + rightSum;
    }
}
