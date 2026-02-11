class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean seenNull = false;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                seenNull = true;   // null mila
            } else {
                if (seenNull) return false;  // null ke baad node mila → invalid

                q.offer(node.left);
                q.offer(node.right);
            }
        }

        return true;
    }
}
