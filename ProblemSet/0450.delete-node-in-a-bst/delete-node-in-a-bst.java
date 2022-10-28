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
    TreeNode getLeft(TreeNode root){
        if(root == null) return null;
        if(root.left == null) return root;
        return getLeft(root.left);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            TreeNode leftPart = root.left;
            TreeNode temp = getLeft(root.right);
            if(temp == null){
                root = root.left;
                return root;
            }
            temp.left = leftPart;
            root = root.right;
            return root;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
}