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
    ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode temp = null;
        ListNode prev = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(right == left){
            return head;
        }
        ListNode leftEnd = head, rightStart = head;
        ListNode partStart, partEnd;
        for(int i = 0; i < left - 2; i++){
            leftEnd = leftEnd.next;
        }
        if(left > 1)
            partStart = leftEnd.next;
        else
            partStart = head;
        
        for(int i = 0; i < right - 1; i++){
            rightStart = rightStart.next;
        }
        partEnd = rightStart;
        rightStart = rightStart.next;
        partEnd.next = null;
        ListNode reversed = reverse(partStart);
        leftEnd.next = reversed;
        partStart.next = rightStart;
        if(left == 1){
            return partEnd;
        }else{
            return head;
        }
    }
}