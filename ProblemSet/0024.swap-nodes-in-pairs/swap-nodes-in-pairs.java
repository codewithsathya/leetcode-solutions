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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null){
            return head;
        }
        ListNode root = head.next;
        ListNode current = head;
        ListNode prev = null;

        while(current != null && current.next != null){
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = current;
            if(prev != null){
                prev.next = temp;
            }
            prev = current;
            current = current.next;
        }
        return root;
    }
}