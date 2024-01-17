class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] currFreq = new int[26];

            for (char ch : word.toCharArray()) {
                currFreq[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], currFreq[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (minFreq[i] != 0) {
                res.add(String.valueOf((char)(i + 'a')));
                minFreq[i]--;
            }
        }
        return res;
    }
}
