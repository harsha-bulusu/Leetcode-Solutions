class Node {
    Node[] nodes;
    boolean flag;

    public Node() {
        nodes = new Node[26];
    }

    boolean contains(char ch) {
        return nodes[ch - 'a'] != null;
    }

    void put(char ch) {
        nodes[ch - 'a'] = new Node();
    }

    Node get(char ch) {
        return nodes[ch - 'a'];
    }

    void setFlag() {
        this.flag = true;
    }
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cursor = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cursor.contains(ch)) {
                cursor.put(ch);
            }
            cursor = cursor.get(ch);
        }
        cursor.setFlag();
    }
    
    public boolean search(String word) {
        Node cursor = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cursor.contains(ch)) return false;
            cursor = cursor.get(ch);
        }
        return cursor.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node cursor = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!cursor.contains(ch)) return false;
            cursor = cursor.get(ch);
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
