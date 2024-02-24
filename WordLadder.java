class Pair {
    String word;
    int len;

    public Pair(String word, int len) {
        this.word = word;
        this.len = len;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = wordList.stream().collect(Collectors.toSet());

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));


        while (!queue.isEmpty()) {
            Pair data = queue.remove();
            String word = data.word;
            int len = data.len;

            for (int i = 0; i < word.length(); i++) {
                char chars[] = word.toCharArray();
                for (int j = 0; j < 26; j++) {
                    chars[i] = (char) (97 + j);
                    String tWord = new String(chars);
                    
                    if (words.contains(tWord)) {
                        if (tWord.equals(endWord)) return len + 1;
                        queue.add(new Pair(tWord, len + 1));
                        words.remove(tWord);
                    }

                }
            }
        }

        return 0;

    }
}
