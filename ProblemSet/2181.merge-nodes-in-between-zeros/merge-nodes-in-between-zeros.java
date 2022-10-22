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
    public ListNode mergeNodes(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode writer = result;
        ListNode reader = head;
        int sum = 0;
        reader = reader.next;
        while(reader != null){
            if(reader.val == 0){
                writer.val = sum;
                if(reader.next != null)
                    writer.next = new ListNode(0);
                writer = writer.next;
                sum = 0;
            }else{
                sum += reader.val;
            }
            reader = reader.next;
        }
        return result;
    }
}