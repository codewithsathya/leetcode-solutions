class Solution {
    static class Node {
        char ch;
        int count;

        Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String reorganizeString(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        int[] arr = new int[26];
        Arrays.fill(arr, 0);
        for (char ch : s.toCharArray()) {
            arr[ch - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.add(new Node((char) (i + 97), arr[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node node1 = pq.poll();
            char ch1 = node1.ch;
            sb.append(ch1);
            node1.count--;
            if(pq.isEmpty() && node1.count > 0){
                return "";
            }
            if(pq.isEmpty()){
                return sb.toString();
            }

            Node node2 = pq.poll();
            char ch2 = node2.ch;
            sb.append(ch2);
            node2.count--;
            if(node1.count > 0){
                pq.add(node1);
            }
            if(node2.count > 0){
                pq.add(node2);
            }
        }
        return sb.toString();
    }
}