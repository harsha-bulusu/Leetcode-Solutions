class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!freqMap.containsKey(ch) || freqMap.get(ch) == 0) return false;
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) - 1);
            }
        }

        return true;
    }
}
