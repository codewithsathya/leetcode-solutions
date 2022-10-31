class Solution {
    static class Node{
        char ch;
        int value;
        Node(char ch, int value){
            this.ch = ch;
            this.value = value;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.value - a.value);
        for(char ch: map.keySet()){
            pq.add(new Node(ch, map.get(ch)));
        }
        int times = 0;
        while(!pq.isEmpty()){
            List<Node> temp = new ArrayList<>();
            for(int i = 0; i <= n; i++){
                if(!pq.isEmpty()){
                    if(pq.peek().value > 1){
                        Node curr = pq.poll();
                        temp.add(new Node(curr.ch, curr.value - 1));
                    }else{
                        pq.poll();
                    }
                }
                times++;
                if(pq.isEmpty() && temp.size() == 0){
                    break;
                }
            }
            for(Node node: temp){
                pq.add(node);
            }
        }
        return times;
    }
}