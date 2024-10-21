class Solution {

    int dfs(String s, int i, Set<String> currSet) {
        if (i == s.length()) return 0;

        int res = 0;
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (currSet.contains(sub)) {
                continue;
            }
            currSet.add(sub);
            res = Math.max(res, 1 + dfs(s, j + 1, currSet));
            currSet.remove(sub);
        }
        return res; 
    }

    public int maxUniqueSplit(String s) {
        return dfs(s, 0, new HashSet<>());
    }
}
