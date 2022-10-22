
// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> neighbors;
//     public Node() {
//         val = 0;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val) {
//         val = _val;
//         neighbors = new ArrayList<Node>();
//     }
//     public Node(int _val, ArrayList<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }


class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        queue.add(node);
        visited.add(node);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            List<Integer> list = new ArrayList<>();
            for(Node neighbour: curr.neighbors){
                list.add(neighbour.val);
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
            map.put(curr.val, list);
        }

        Map<Integer, Node> nodeMap = new HashMap<>();
        for(int key: map.keySet()){
            Node from;
            if(nodeMap.containsKey(key)){
                from = nodeMap.get(key);
            }else{
                from = new Node(key);
                nodeMap.put(key, from);
            }
            for(int neighbour: map.get(key)){
                Node to;
                if(nodeMap.containsKey(neighbour)){
                    to = nodeMap.get(neighbour);
                }else{
                    to = new Node(neighbour);
                    nodeMap.put(neighbour, to);
                }
                from.neighbors.add(to);
            }
        }
        return nodeMap.get(node.val);
    }
}