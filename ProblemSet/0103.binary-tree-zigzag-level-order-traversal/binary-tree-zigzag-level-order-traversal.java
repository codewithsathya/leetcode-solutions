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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int len = depth(root);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            list.add(new ArrayList<>());
        }
        dfs(root, 0, list);
        for(int i = 1; i < len; i = i + 2){
            Collections.reverse(list.get(i));
        }
        return list;
    }

    public void dfs(TreeNode root, int depth, List<List<Integer>> result){
        if(root == null) return;
        dfs(root.left, depth + 1, result);
        if(result.get(depth) == null){
            result.set(depth, new ArrayList<>());
        }
        result.get(depth).add(root.val);
        dfs(root.right, depth + 1, result);
    }

    public int depth(TreeNode root){
        return root == null ? 0 : 1 + Math.max(depth(root.left), depth(root.right));
    }
}