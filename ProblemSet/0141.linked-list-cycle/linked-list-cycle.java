/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
		slow = fast = head;
		while(slow != null && fast != null){
			if(fast.next == null) return false;
			if(fast.next.next == null) return false;
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
    }
}