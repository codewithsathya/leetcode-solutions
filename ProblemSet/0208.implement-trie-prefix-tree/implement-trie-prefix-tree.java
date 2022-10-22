class Node{
    char value;
    boolean isEnd;
    Map<Character, Node> map;
    Node(char value, boolean isEnd){
        this.value = value;
        this.isEnd = isEnd;
        this.map = new HashMap<>();
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node(' ', false);
    }
    
    public void insert(String word) {
        Node curr = root;
        int len = word.length();
        for(int i = 0; i < len; i++){
            char ch = word.charAt(i);
            if(!curr.map.containsKey(ch)){
                curr.map.put(ch, new Node(ch, false));
            }
            curr = curr.map.get(ch);
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        int len = word.length();
        Node curr = root;
        for(int i = 0; i < len; i++){
            char ch = word.charAt(i);
            if(curr.map.containsKey(ch)){
                curr = curr.map.get(ch);
            }else{
                return false;
            }
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int len = prefix.length();
        Node curr = root;
        for(int i = 0; i < len; i++){
            char ch = prefix.charAt(i);
            if(curr.map.containsKey(ch)){
                curr = curr.map.get(ch);
            }else{
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */