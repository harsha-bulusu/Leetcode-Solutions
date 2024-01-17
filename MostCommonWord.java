class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned) bannedWords.add(word);

        paragraph = paragraph.replaceAll("[!?,';.]", " ").toLowerCase();
        paragraph = paragraph.replaceAll("  ", " ");
        String[] words = paragraph.split(" ");
        Map<String, Integer> freqMap = new HashMap<>();
        String res = "";
        int maxFreq = Integer.MIN_VALUE;
        for (String word : words) {
            if (bannedWords.contains(word)) continue;
            if (freqMap.containsKey(word)) {
                freqMap.put(word, freqMap.get(word) + 1);
            } else {
                freqMap.put(word, 1);
            }
            if (freqMap.get(word) > maxFreq) {
                res = word;
                maxFreq = freqMap.get(word);
            }
        }
        return res;
    }
}
