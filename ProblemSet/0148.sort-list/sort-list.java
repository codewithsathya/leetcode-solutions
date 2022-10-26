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
    ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null && head2 == null) return null;
        else if(head1 == null) return head2;
        else if(head2 == null) return head1;

        ListNode writer  = head1;
        ListNode p1 = head1;
        ListNode p2 = head2;
        if(head2.val < writer.val){
            writer = head2;
            p2 = p2.next;
        }else{
            p1 = p1.next;
        }
        ListNode result = writer;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                writer.next = p1;
                writer = p1;
                p1 = p1.next;
            }else{
                writer.next = p2;
                writer = p2;
                p2 = p2.next;
            }
        }
        while(p1 != null){
            writer.next = p1;
            writer = p1;
            p1 = p1.next;
        }
        while(p2 != null){
            writer.next = p2;
            writer = p2;
            p2 = p2.next;
        }
        return result;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return merge(head, count);
    }

    public ListNode merge(ListNode head, int size){
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        for(int i = 0; i < size / 2 - 1; i++){
            right = right.next;
        }
        ListNode temp = right;
        right = right.next;
        temp.next = null;
        int leftSize = size / 2;
        int rightSize = (size + 1) / 2;
        ListNode sortedLeft = merge(left, leftSize);
        ListNode sortedRight = merge(right, rightSize);
        return merge(sortedLeft, sortedRight);
    }
}