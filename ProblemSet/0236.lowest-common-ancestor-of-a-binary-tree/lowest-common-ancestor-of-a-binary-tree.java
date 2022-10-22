/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lcaNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return lcaNode;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        int count = 0;
        if(p == root || q == root){
            count++;
        }
        if(helper(root.left, p, q)) count++;
        if(helper(root.right, p, q)) count++;
        if(count == 2){
            lcaNode = root;
        }
        return count > 0;
    }
}