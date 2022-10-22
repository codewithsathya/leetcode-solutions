/**
 * Definition for singly-linked list.
 *  public class ListNode {
 *      int val;
 *      ListNode next;
 *      ListNode() {}
 *      ListNode(int val) { this.val = val; }
 *      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *  }
 */
class Solution {
    static class MyNode{
        ListNode pointer;
        int val;
        int index;
        MyNode(ListNode pointer, int val, int index){
            this.pointer = pointer;
            this.val = val;
            this.index = index;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<MyNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null)
                pq.add(new MyNode(lists[i], lists[i].val, i));
        }
        if(pq.isEmpty()) return null;
        MyNode myRoot = pq.remove();
        ListNode root = myRoot.pointer;
        ListNode writer = root;
        lists[myRoot.index] = lists[myRoot.index].next;
        if(lists[myRoot.index] != null)
            pq.add(new MyNode(lists[myRoot.index], lists[myRoot.index].val, myRoot.index));

        while(!pq.isEmpty()){
            MyNode readNode = pq.remove();
            writer.next = readNode.pointer;
            writer = writer.next;
            lists[readNode.index] = lists[readNode.index].next;
            if(lists[readNode.index] != null){
                pq.add(new MyNode(lists[readNode.index], lists[readNode.index].val, readNode.index));
            }
        }
        return root;
    }
}