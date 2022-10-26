/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode curr = head;
        int size = 0;
        while(curr != null){
            ++size;
            curr = curr.next;
        }
        ListNode left = head;
        ListNode right = head;
        for(int i = 0; i < (size - 1) / 2 - 1; ++i){
            right = right.next;
        }
        ListNode temp = right;
        right = right.next;
        TreeNode root = new TreeNode(right.val);
        right = right.next;
        temp.next = null;

        TreeNode leftTree = sortedListToBST(left);
        TreeNode rightTree = sortedListToBST(right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}