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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode result, current;

        ListNode f = l1;
        ListNode s = l2;
        int fcount = 0, scount = 0;
        while(f != null){
            fcount++;
            f = f.next;
        }
        while(s != null){
            scount++;
            s = s.next;
        }
        if(fcount > scount){
            result = l1;
            current = l1;
        }else{
            result = l2;
            current = l2;
        }
        int carry = 0;
        while(first != null || second != null){
            int sum = carry;
            if(first != null){
                sum += first.val;
            }
            if(second != null){
                sum += second.val;
            }
            if(sum > 9){
                carry = 1;
                sum -= 10;
            }else{
                carry = 0;
            }
            
            current.val = sum;
            current = current.next;
            if(first != null){
                first = first.next;
            }
            if(second != null){
                second = second.next;
            }
        }
        if(carry == 1){
            current = result;
            while(current.next != null){
                current = current.next;
            }
            current.next = new ListNode(1);
        }
        return result;
    }
}