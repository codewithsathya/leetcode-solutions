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
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Double> result = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            Queue<TreeNode> temp = new ArrayDeque<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }
            }
            double mean = sum / size;
            result.add(mean);
            queue = temp;
        }
        return result;
    }
}