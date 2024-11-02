class Solution {
    public int firstMissingPositive(int[] nums) {
        // Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        // int i;
        // for (i = 1; i <= 100000; i++) {
        //     if (!set.contains(i)) return i;
        // }

        // return i;

        int n = nums.length;
        // eliminate negative numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }


        // hash numbers to indexes
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (index >= 0 && index < n) {
                if (nums[index] > 0) nums[index] *= -1;
                else if (nums[index] == 0) nums[index] = Math.abs(nums[i]) * -1;
            }
        }

        // check missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) return i + 1;
        }

        return n + 1;
    }
}
