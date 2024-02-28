class Node {
    int key, val, freq;
    Node prev, next;

    public Node(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
    }
}

class DoublyLinkedList {

    Node head, tail;
    int size;

    public DoublyLinkedList() {
        head = new Node(0, 0, 0);
        tail = new Node(0, 0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node newNode) {
        Node next = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = next;
        next.prev = newNode;
        size++;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
    }

}
class LFUCache {

    int capacity;
    Map<Integer, DoublyLinkedList> freqMap;
    Map<Integer, Node> refMap;
    int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        freqMap = new HashMap<>();
        refMap = new HashMap<>();
        minFrequency = 0;
    }
    
    public int get(int key) {
        if (refMap.containsKey(key)) {
            Node node = refMap.get(key);
            update(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (refMap.containsKey(key)) {
            Node node = refMap.get(key);
            node.val = value;
            update(node);
        } else {
            Node newNode = new Node(key, value, 1);
            if (capacity == refMap.size()) {
                DoublyLinkedList cache = freqMap.get(minFrequency);
                Node lru = cache.tail.prev;
                cache.remove(lru);
                refMap.remove(lru.key);
            }
            minFrequency = 1;
            DoublyLinkedList targetCache = freqMap.getOrDefault(1, new DoublyLinkedList());
            targetCache.add(newNode);
            freqMap.put(1, targetCache);
            refMap.put(key, newNode);
        }
    }

    void update(Node node) {
        int currFrequency = node.freq;
        int updatedFrequency = currFrequency + 1;
        DoublyLinkedList cache = freqMap.get(currFrequency);
        cache.remove(node);
        if (currFrequency == minFrequency && cache.size == 0) {
            minFrequency++;
        }
        Node newNode = new Node(node.key, node.val, updatedFrequency);
        DoublyLinkedList targetCache = null;
        if (freqMap.containsKey(updatedFrequency)) {
            targetCache = freqMap.get(updatedFrequency);
        } else {
            targetCache = new DoublyLinkedList();
        }
        targetCache.add(newNode);
        freqMap.put(updatedFrequency, targetCache);
        refMap.put(node.key, newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
