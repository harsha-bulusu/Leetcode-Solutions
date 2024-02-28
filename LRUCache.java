class LRUCache {

    class Node {
        int key, val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head, tail;
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);  
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            update(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            delete(map.get(key));
        } else if (capacity == map.size()) {
            delete(tail.prev);
        }
        addAtBeginning(key, value);
    }

    void update(Node node) {
        int key = node.key;
        int val = node.val;
        delete(node);
        addAtBeginning(key, val);
    }

    void addAtBeginning(int key, int val) {
        Node newNode = new Node(key, val);
        Node temp = head.next;
        temp.prev = newNode;
        head.next = newNode;
        newNode.next = temp;
        newNode.prev = head;
        map.put(key, newNode);
    }

    void delete(Node node) {
        map.remove(node.key);
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
