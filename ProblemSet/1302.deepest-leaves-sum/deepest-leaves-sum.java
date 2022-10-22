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
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        int height = getHeight(root);
        addLeaves(root, height);
        return sum;
    }

    int getHeight(TreeNode curr){
        if(curr == null) return 0;
        return 1 + Math.max(getHeight(curr.left), getHeight(curr.right));
    }

    void addLeaves(TreeNode curr, int height){
        if(curr == null) return;
        if(height == 1){
            sum += curr.val;
        }
        addLeaves(curr.left, height - 1);
        addLeaves(curr.right, height - 1);
    }
}