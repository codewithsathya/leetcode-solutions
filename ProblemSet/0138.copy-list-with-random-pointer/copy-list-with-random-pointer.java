/*
// Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Integer> map = new HashMap<>();
        List<Node> oldNodes = new ArrayList<>();
        Node curr = head;
        int j = 0;
        while(curr != null){
            map.put(curr, j++);
            oldNodes.add(curr);
            curr = curr.next;
        }
        HashMap<Node, Integer> randomIndexMap = new HashMap<>();
        for(Node node: map.keySet()){
            Node randomNode = node.random;
            if(randomNode == null){
                randomIndexMap.put(node, -1);
                continue;
            }
            int randomIndex = map.get(randomNode);
            randomIndexMap.put(node, randomIndex);
        }
        List<Node> list = new ArrayList<>();
        curr = head;
        while(curr != null){
            list.add(new Node(curr.val));
            curr = curr.next;
        }
        for(int i = 0; i < list.size(); i++){
            int randomIndex = randomIndexMap.get(oldNodes.get(i));
            list.get(i).random = randomIndex == -1 ? null : list.get(randomIndex);
        }
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }
}