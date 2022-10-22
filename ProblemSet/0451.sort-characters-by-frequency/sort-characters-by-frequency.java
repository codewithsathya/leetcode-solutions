class Solution {
    static class Node{
        char ch;
        int count;
        Node(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        List<Node> list = new ArrayList<>();
        for(char ch: map.keySet()){
            list.add(new Node(ch, map.get(ch)));
        }
        Collections.sort(list, (a, b) -> b.count - a.count);
        StringBuilder sb = new StringBuilder();
        for(Node node: list){
            for(int i = 0; i < node.count; i++){
                sb.append(node.ch);
            }
        }
        return sb.toString();
    }
}