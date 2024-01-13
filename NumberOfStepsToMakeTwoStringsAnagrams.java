class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (freqMap.containsKey(ch)) {
                int newFreq = freqMap.get(ch) - 1;
                if (newFreq == 0) {
                    freqMap.remove(ch);
                } else {
                    freqMap.put(ch, newFreq);
                } 
            } else {
                count++;
            }
        }
        return count;
    }
}
