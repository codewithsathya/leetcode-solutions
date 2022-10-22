/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            sizeA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            sizeB++;
        }

        int n = sizeA - sizeB;
        if(n > 0){
            for(int i = 0; i < n; i++){
                headA = headA.next;
            }
        }else if(n < 0){
            for(int i = 0; i < -n; i++){
                headB = headB.next;
            }
        }
        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}