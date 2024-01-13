class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> jewelFreq = new HashMap<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelFreq.put(jewels.charAt(i), i);
        } 
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (jewelFreq.containsKey(ch)) count++;
        }
        return count;
    }
}
