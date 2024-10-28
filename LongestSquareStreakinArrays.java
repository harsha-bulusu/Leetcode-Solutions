class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxElement = 0;
        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }
        int maxSquarable = (int)Math.sqrt(Integer.MAX_VALUE);

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int longest = -1;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            int num = nums[i];

            while (num <=maxElement && num <= maxSquarable && set.contains(num * num)) {
                num *= num;
                cnt++;
            }

            if (cnt > 1) {
                longest = Math.max(longest, cnt);
            }
        }

        return longest;
    }
}
