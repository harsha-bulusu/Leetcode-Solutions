class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i += 2) {
            int alice = nums[i];
            int bob = nums[i + 1];

            res[i] = bob;
            res[i + 1] = alice;
        }
        return res;
    }
}
