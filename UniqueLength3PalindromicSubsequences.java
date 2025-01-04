class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> res = new HashSet<>();
        Set<Character> left = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        int n = s.length();

        for (char ch : s.toCharArray()) {
            right.put(ch,
                right.getOrDefault(ch, 0) + 1
            );
        }

        for (char mid : s.toCharArray()) { 
            right.put(mid, right.get(mid) - 1);
            for (char ch : left) {
                if (right.get(ch) > 0) {
                    res.add(mid + " " + ch);
                }
            }

            left.add(mid);
        }

        return res.size();
    }
}
