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
	public boolean isBalanced(TreeNode root) {
		int res = dfs(root);
		return !(res == -1);
	}
	private int dfs(TreeNode current){
		if(current == null) return 0;
		int left = 1 + dfs(current.left);
		if(left == 0) return -1;
		int right = 1 + dfs(current.right);
		if(right == 0) return -1;
		int diff = Math.abs(left - right);
		if(diff != 0 && diff != 1) return -1;
		return Math.max(left, right);
	}
}