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
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            st.push(curr);
            curr = curr.next;
        }
        int len = st.size();
        curr = head;
        for(int i = 0; i < (len - 1) / 2; i++){
            ListNode temp = curr.next;
            curr.next = st.pop();
            curr.next.next = temp;
            st.peek().next = null;
            curr = temp;
        }
    }
}