class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];

        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        int[] res = new int[2];
        for (int i = 1; i <= n; i++) {
            if (hash[i] == 2) res[0] = i;
            if (hash[i] == 0) res[1] = i;
        }

        return res;
    }
}
