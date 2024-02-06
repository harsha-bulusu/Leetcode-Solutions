class Solution {
    public void moveZeroes(int[] nums) {
        /**
            * Brute force : TC : O(n) + O(x) + O(n - x), SC : O(x)
         */
        // List<Integer> list = new ArrayList<>(); // store all non zero elements
        // for (int num : nums) { // O(n)
        //     if (num != 0) {
        //         list.add(num);
        //     }
        // }

        // int cursor = 0;
        // for (int num : list) { // O(n - z) z - zero elements
        //     nums[cursor++] = num;
        // }

        // for (int i = cursor; i < nums.length; i++) { // O(n - x) x - non zero elements
        //     nums[i] = 0;
        // }

        /**
            * Optimal Solution : Two Pointer approach
         */
        int n = nums.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return;

        for (int i = j + 1; i < n; i++) {
            if (nums[j] == 0 && nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

    }
}
