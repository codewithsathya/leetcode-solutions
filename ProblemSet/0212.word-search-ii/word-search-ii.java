class Node{
    char value;
    boolean isEnd;
    Map<Character, Node> map;

    Node(char value){
        this.value = value;
        this.map = new HashMap<>();
    }
}
class Trie{
    Node root;
    Trie(){
        root = new Node(' ');
    }

    void insert(String str){
        int len = str.length();
        Node curr = root;
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);;
            if(!curr.map.containsKey(ch)){
                curr.map.put(ch, new Node(ch));
            }
            curr = curr.map.get(ch);
        }
        curr.isEnd = true;
    }

    boolean search(String str){
        int len = str.length();
        Node curr = root;
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(!curr.map.containsKey(ch))
                return false;
            curr = curr.map.get(ch);
        }
        return curr.isEnd;
    }

    boolean startsWith(String str){
        int len = str.length();
        Node curr = root;
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(curr.map == null || !curr.map.containsKey(ch))
                return false;
            curr = curr.map.get(ch);
        }
        return true;
    }

    void remove(String str){
        int len = str.length();
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(!curr.map.containsKey(ch)){
                return;
            }
            curr = curr.map.get(ch);
            stack.add(curr);
        }
        if(curr.map.size() == 0){
            Node prev = stack.pop();
            while(!stack.isEmpty()){
                Node temp = stack.pop();
                if(temp.map.size() > 1 || temp.isEnd){
                    temp.map.remove(prev.value);
                    return;
                }else{
                    prev = temp;
                }
            }
        }
    }
}
class Solution {
    int[] x = {0, 0, 1, -1};
    int[] y = {1, -1, 0, 0};
    public List<String> findWords(char[][] board, String[] words) {
        if(board.length == 0) return new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
        Set<String> list = new HashSet<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                String str = "";
                dfs(i, j, board, trie, visited, str, list);
            }
        }
        return new ArrayList<>(list);
    }

    public void dfs(int row, int col, char[][] board, Trie trie, boolean[][] visited, String str, Set<String> list){
        str += board[row][col];
        if(!trie.startsWith(str)) return;
        if(trie.search(str)){
            list.add(str);
            trie.remove(str);
        }
        visited[row][col] = true;
        for(int i = 0; i < 4; i++){
            int rr = row + y[i];
            int cc = col + x[i];
            if(rr < 0 || rr >= board.length || cc < 0 || cc >= board[0].length || visited[rr][cc]){
                continue;
            }
            dfs(rr, cc, board, trie, visited, str, list);
        }
        visited[row][col] = false;
    }
}