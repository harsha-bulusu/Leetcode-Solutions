class Solution {
    public int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            map.put((char)(48 + i), new HashSet<>());
        }
        
        for (int i = 0; i < rings.length(); i+=2) {
            char color = rings.charAt(i);
            char rod = rings.charAt(i + 1);
            map.get(rod).add(color);
        }
        int count = 0;
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().size() == 3) count++;
        }
        return count;
    }
}
