class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length();
        int count = 0;
        while (j < n) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == 3) {
                count += 1 + (n - j -1);
                char tar = s.charAt(i);
                int updatedFreq = map.get(tar) - 1;
                if (updatedFreq == 0) map.remove(tar);
                else map.put(tar, updatedFreq);
                i++; 
            }
            j++;
        }

        return count;
        
    }
}
