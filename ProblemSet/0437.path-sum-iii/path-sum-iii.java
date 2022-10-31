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
    public int hasSum(TreeNode root, long targetSum){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                return 1;
            }else{
                return 0;
            }
        }
        int count = root.val == targetSum ? 1 : 0;
        if(root.left != null)
            count += hasSum(root.left, targetSum - root.val);
        if(root.right != null)
            count += hasSum(root.right, targetSum - root.val);
        return count;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int count = hasSum(root, targetSum);
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        return count;
    }
}