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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = helper(root, targetSum);
        for(List<Integer> list: result){
            Collections.reverse(list);
        }
        return result;
    }

    public List<List<Integer>> helper(TreeNode root, int targetSum) {
        if(root == null){
            return new LinkedList<>();
        }
        if(root.left == null && root.right == null){
            List<List<Integer>> result = new LinkedList<>();
            if(root.val == targetSum){
                List<Integer> list = new LinkedList<>();
                list.add(root.val);
                result.add(list);
            }
            return result;
        }

        List<List<Integer>> left = helper(root.left, targetSum - root.val);
        for(List<Integer> list: left){
            list.add(root.val);
        }
        List<List<Integer>> right = helper(root.right, targetSum - root.val);
        for(List<Integer> list: right){
            list.add(root.val);
            left.add(list);
        }
        return left;
    }
}