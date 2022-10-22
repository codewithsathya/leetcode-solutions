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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return helper(root, targetSum);
    }

    public boolean helper(TreeNode root, int targetSum){
        if(root.left == null && root.right == null){
            return targetSum == root.val ? true : false;
        }
        boolean result = false;
        if(root.left != null){
            result = result || helper(root.left, targetSum - root.val);
            if(result) return true;
        }
        if(root.right != null){
            result = result || helper(root.right, targetSum - root.val);
            if(result) return true;
        }
        return result;
    }
}