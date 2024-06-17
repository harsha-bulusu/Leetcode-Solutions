class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0;
        Queue<Integer> costs = new LinkedList<>();
        int len = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            cost += Math.abs(s.charAt(i) - t.charAt(i));
            costs.add(Math.abs(s.charAt(i) - t.charAt(i)));
            len++;
            while (cost > maxCost) {
                len--;
                cost -= costs.remove();
            }
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }
}
