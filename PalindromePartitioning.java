class Solution {

    void helper(int index, String s, List<String> path, List<List<String>> res, int n) {
        if (n == index) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < n; i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                helper(i + 1, s, path, res, n);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        helper(0, s, new ArrayList<>(), res, n);
        return res;
    }
}
