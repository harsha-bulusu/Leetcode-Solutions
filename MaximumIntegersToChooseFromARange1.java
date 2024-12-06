class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] hash = new boolean[100001];
        for (int i : banned) {
            hash[i] = true;
        }
        
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!hash[i]) {
                sum += i;
                if (sum > maxSum) break;
                cnt++;
            }
        }

        return cnt;
    }
}
