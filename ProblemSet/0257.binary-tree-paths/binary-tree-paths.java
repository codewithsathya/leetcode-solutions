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
    String getString(List<Integer> list){
        if(list == null || list.size() == 0){
            return "";
        }
        int len = list.size();
        String result = "";
        result += String.valueOf(list.get(0));
        for(int i = 1; i < len; i++){
            result += "->";
            result += list.get(i);
        }
        return result;
    }

    List<String> result;
    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        helper(root, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, List<Integer> stack){
        if(root == null){
            return;
        }
        stack.add(root.val);
        if(root.left == null && root.right == null){
            result.add(getString(stack));
        }
        helper(root.left, stack);
        helper(root.right, stack);
        stack.remove(stack.size() - 1);
    }
}