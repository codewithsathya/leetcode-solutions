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
    static class Pair{
        TreeNode node;
        int position;
        Pair(TreeNode node, int position){
            this.node = node;
            this.position = position;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        int count = 1;
        while(!queue.isEmpty()){
            Pair head = queue.peek();
            Pair tail = head;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                tail = queue.poll();
                if(tail.node.left != null){
                    queue.add(new Pair(tail.node.left, 2 * tail.position));
                }
                if(tail.node.right != null){
                    queue.add(new Pair(tail.node.right, 2 * tail.position + 1));
                }

            }
            count = Math.max(count, tail.position - head.position + 1);
        }
        return count;
    }
}