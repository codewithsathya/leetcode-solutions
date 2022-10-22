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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int low, int high){
        if(low < 0 || low >= nums.length || high < 0 || high >= nums.length || low > high){
            return null;
        }
        int max = low;
        for(int i = low + 1; i <= high; i++){
            if(nums[max] < nums[i]){
                max = i;
            }
        }
        TreeNode curr = new TreeNode(nums[max]);
        curr.left = construct(nums, low, max - 1);
        curr.right = construct(nums, max + 1, high);
        return curr;
    }
}