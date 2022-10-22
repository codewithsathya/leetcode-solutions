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
    int result = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return result;
    }

    void traverse(TreeNode curr){
        if(curr == null) return;
        if(curr.val % 2 == 0){
            if(curr.left != null){
                if(curr.left.left != null){
                    result += curr.left.left.val;
                }
                if(curr.left.right != null){
                    result += curr.left.right.val;
                }
            }
            if(curr.right != null){
                if(curr.right.left != null){
                    result += curr.right.left.val;
                }
                if(curr.right.right != null){
                    result += curr.right.right.val;
                }
            }
        }
        traverse(curr.left);
        traverse(curr.right);
    }
}