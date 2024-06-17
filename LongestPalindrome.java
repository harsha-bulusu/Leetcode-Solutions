import java.util.Map.Entry;
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int updatedFreq = freqMap.getOrDefault(ch, 0) + 1;
            freqMap.put(ch, updatedFreq);
        }

        int even = 0;
        int odd = 0;
        for (Entry<Character, Integer> entry : freqMap.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 0) {
                even += value;
            } else {
                odd += 1;
                even += (value - 1);
            }
        }

        if (odd >= 1) {
            return even + 1;
        }
        return even;
    }
}
