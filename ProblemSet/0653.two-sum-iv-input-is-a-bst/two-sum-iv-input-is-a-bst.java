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
    boolean find(TreeNode root, int num){
        if(root == null) return false;
        if(root.val == num){
            return true;
        }else if(root.val > num){
            return find(root.left, num);
        }else{
            return find(root.right, num);
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k, root);
    }

    public boolean dfs(TreeNode root, int k, TreeNode mainRoot){
        if(root == null){
            return false;
        }
        if(2 * root.val != k){
            if(find(mainRoot, k - root.val)) return true;
        }
        return dfs(root.left, k, mainRoot) || dfs(root.right, k, mainRoot);
    }
}