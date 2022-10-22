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
class Node{
    int sum;
    int count;
    Node(int sum, int count){
        this.sum = sum;
        this.count = count;
    }
}

class Solution {
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        calculate(root);
        return result;
    }

    Node calculate(TreeNode curr){
        if(curr == null){
            return new Node(0, 0);
        }
        Node left = calculate(curr.left);
        Node right = calculate(curr.right);
        int sum = curr.val + left.sum + right.sum;
        int count = 1 + left.count + right.count;
        if(sum / count == curr.val) this.result++;
        return new Node(sum, count);
    }
}