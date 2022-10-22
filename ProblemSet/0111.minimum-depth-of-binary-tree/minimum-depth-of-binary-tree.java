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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 1;
        while(!queue.isEmpty()){
            Queue<TreeNode> temp = new ArrayDeque<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null){
                    return count;
                }
                if(node.left != null){
                    temp.add(node.left);
                }
                if(node.right != null){
                    temp.add(node.right);
                }
            }
            count++;
            queue = temp;
        }
        return count;
    }
}