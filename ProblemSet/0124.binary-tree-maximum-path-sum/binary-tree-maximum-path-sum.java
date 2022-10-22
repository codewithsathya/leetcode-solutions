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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    public int helper(TreeNode node){
        if(node == null) return 0;
        int leftSum = helper(node.left);
        if(leftSum < 0) leftSum = 0;
        int rightSum = helper(node.right);
        if(rightSum < 0) rightSum = 0;
        maxSum = Math.max(maxSum , node.val + leftSum + rightSum);
        return node.val + Math.max(leftSum, rightSum);
    }
}