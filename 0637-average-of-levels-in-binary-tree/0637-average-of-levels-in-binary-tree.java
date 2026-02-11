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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode root, List<Double> res){
        if(root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;

            for(int i=0; i<size; i++){
                TreeNode currNode = q.remove();
                
                sum += currNode.val;

                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
            double avg = sum/(double)size;
            res.add(avg);
        }
    }
}