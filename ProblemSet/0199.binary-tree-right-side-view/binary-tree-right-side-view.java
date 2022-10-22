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
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    public void dfs(TreeNode root, int currDepth, List<Integer> result){
        if(root == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(root.val);
        }
        dfs(root.right, currDepth + 1, result);
        dfs(root.left, currDepth + 1, result);
    }
        
}