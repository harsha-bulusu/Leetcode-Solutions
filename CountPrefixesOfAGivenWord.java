class Trie {
    class Node {
        Node chars[] = new Node[26];
        boolean flag;

        public boolean isEnd() {
            return this.flag;
        }

        public void setEnd() {
            this.flag = true;
        }

        public boolean contains(char ch) {
            return chars[ch - 'a'] != null;
        }

        public Node get(char ch) {
            return chars[ch - 'a'];
        }

        public void put(char ch) {
            chars[ch - 'a'] = new Node();
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cursor = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cursor.contains(ch)) cursor.put(ch);
            cursor = cursor.get(ch);
        }
        cursor.setEnd();
    }

    public boolean isPrefix(String searchTerm) {
        Node cursor = root;
        for (int i = 0; i < searchTerm.length(); i++) {
            char ch = searchTerm.charAt(i);
            if (!cursor.contains(ch)) return false;
            cursor = cursor.get(ch);
        }

        return true;
    }
}

class Solution {

    private boolean isPrefix(String prefix, String s) {
        if (prefix.length() > s.length()) return false;
        int i;
        for (i = 0 ; i < prefix.length() && i < s.length(); i++) {
            if (s.charAt(i) != prefix.charAt(i)) return false;
        }

        if (i == prefix.length()) return true;
        return false;
    }

    public int countPrefixes(String[] words, String s) {
        // int cnt = 0;
        // for (String word : words) {
        //     if (isPrefix(word, s)) cnt++;
        // }

        // return cnt;

        Trie trie = new Trie();
        trie.insert(s);

        int cnt = 0;
        for (String word : words) {
            if(trie.isPrefix(word)) cnt++;
        }

        return cnt;
    }
}
