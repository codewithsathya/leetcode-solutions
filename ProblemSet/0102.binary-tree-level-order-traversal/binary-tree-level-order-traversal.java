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
    public List<List<Integer>> levelOrder(TreeNode root) {
        int height = height(root);
        height++;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < height; i++){
            result.add(new ArrayList<>());
        }
        dfs(root, 0, result, height);
        return result;
    }

    public void dfs(TreeNode root, int index, List<List<Integer>> result, int height){
        if(root == null || index >= height) return;
        result.get(index).add(root.val);
        dfs(root.left, index + 1, result, height);
        dfs(root.right, index + 1, result, height);
    }

    public int height(TreeNode root){
        if(root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}