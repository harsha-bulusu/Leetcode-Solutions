class Solution {

    private int[] buildPrefix(String[] words) {
        int[] prefix = new int[words.length];

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int cursor = 0;
        for (String word : words) {
            if (vowels.contains(word.charAt(0)) && 
                vowels.contains(word.charAt(word.length() - 1))) {
                prefix[cursor] = cursor == 0 ? 1 : prefix[cursor - 1] + 1;
            } else {
                prefix[cursor] = cursor == 0 ? 0 : prefix[cursor - 1];
            }
            cursor++;
        }

        return prefix;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = buildPrefix(words);
        int[] res = new int[queries.length];

        int cursor = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            res[cursor] = l == 0 ? prefix[r] : prefix[r] - prefix[l - 1];
            cursor++; 
        }   


        return res;
    }
}

// queries -> ans

// queries [m * 2] => query [l, r] // range && inclusive

// {1, 1, 2, 3, 4}
