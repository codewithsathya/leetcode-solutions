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
    int currSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(TreeNode curr){
        if(curr == null) return;
        traverse(curr.right);
        curr.val += currSum;
        currSum = curr.val;
        traverse(curr.left);
    }
}