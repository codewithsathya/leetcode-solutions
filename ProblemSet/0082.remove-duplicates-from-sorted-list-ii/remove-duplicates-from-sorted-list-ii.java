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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode start = head, end = head;
        while(end != null && end.next != null){
            while(end != null && end.next != null && end.next.val == start.val){
                end = end.next;
            }
            if(start == end){
                prev = start;
                start = start.next;
                end = end.next;
                continue;
            }
            if(prev == null){
                head = end.next;
                start = end.next;
            }else{
                prev.next = end.next;
                start = end.next;
            }
        }
        return head;
    }
}