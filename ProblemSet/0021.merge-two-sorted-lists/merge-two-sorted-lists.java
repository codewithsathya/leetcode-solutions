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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
			return null;
		}else if(list1 == null){
			return list2;
		}else if(list2 == null){
			return list1;
		}
		ListNode p1 = list1;
		ListNode p2 = list2;
		ListNode result = null;
		if(p1.val < p2.val){
			result = p1;
			p1 = p1.next;
		}else{
			result = p2;
			p2 = p2.next;
		}
		ListNode w = result;
		while(p1 != null && p2 != null){
			if(p1.val < p2.val){
				w.next = p1;
				w = p1;
				p1 = p1.next;
			}else{
				w.next = p2;
				w = p2;
				p2 = p2.next;
			}
		}
		while(p1 != null){
			w.next = p1;
			w = p1;
			p1 = p1.next;
		}
		while(p2 != null){
			w.next = p2;
			w = p2;
			p2 = p2.next;
		}
		return result;
    }
}