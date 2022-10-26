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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        ListNode last = head;
        int count = 1;
        while(last.next != null){
            count++;
            last = last.next;
        }

        ListNode current = head;
        for(int i = 0; i < count / 2; i++){
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = null;
            last.next = temp;
            last = last.next;
            current = current.next;
        }
        return head;
    }
}