class Node{
    int key;
    Node next = null;
    Node prev = null;

    Node(int key, Node prev){
        this.key = key;
        this.prev = prev;
    }

    Node(int key){
        this(key, null);
    }
}

class MyLinkedList{
    Node root = null;
    Node current = null;
    int size = 0;

    Node addNode(int key){
        if(root == null){
            root = new Node(key);
            current = root;
        }else{
            current.next = new Node(key, current);
            current = current.next;
        }
        size++;
        return current;
    }

    Node getLastNode(){
        return current;
    }

    Node removeFirstNode(){
        if(root == null) return null;
        Node first = root;
        root = root.next;
        if(root != null)
            root.prev = null;
        size--;
        return first;
    }
}

class LRUCache {
    Map<Integer, Integer> map;
    int size = 0;
    int capacity;
    MyLinkedList list;
    Map<Integer, Node> keyNodeMap;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.list = new MyLinkedList();
        this.capacity = capacity;
        this.keyNodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = keyNodeMap.get(key);
            if(node.next == null){
                return map.get(key);
            }
            if(node.prev != null){
                node.prev.next = node.next;
            }else{
                list.root = list.root.next;
            }
            if(node.next != null){
                node.next.prev = node.prev;
            }
            node.next = null;
            node.prev = list.current;
            list.current.next = node;
            list.current = list.current.next;
            return map.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            get(key);
            map.put(key, value);
            return;
        }
        if(size < capacity){
            size++;
        }else{
            Node first = list.removeFirstNode();
            map.remove(first.key);
            keyNodeMap.remove(first.key);
        }
        Node currentNode = list.addNode(key);
        map.put(key, value);
        keyNodeMap.put(key, currentNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */