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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
		if(head.next == null) return head;

		ListNode current = head;
		ListNode temp = current;
		ListNode previous = null;
		while(current != null){
			temp = temp.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		return previous;
    }
}