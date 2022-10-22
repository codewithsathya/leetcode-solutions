class Node{
    String str;
    int count;
    Node(String str, int count){
        this.str = str;
        this.count = count;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(String word: words){
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if(a.count == b.count){
                return a.str.compareTo(b.str);
            }
            return b.count - a.count;
        });
        for(String word: countMap.keySet()){
            pq.add(new Node(word, countMap.get((word))));
        }
        int count = 0;
        while(!pq.isEmpty() && count != k){
            Node node = pq.poll();
            result.add(node.str);
            count++;
        }
        return result;
    }
}