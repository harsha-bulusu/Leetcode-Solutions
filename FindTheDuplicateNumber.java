class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        // using xor operator
        // for (int i = 1; i < nums.length; i++) {
        //     if ((nums[i] ^ nums[i - 1]) == 0) return nums[i];
        // }
        // return -1;

        //using two pointers approach
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            if (nums[low] == nums[low + 1]) return nums[low];
            if (nums[high] == nums[high - 1]) return nums[high];

            low++;
            high--;
        }

        return -1;
    }
}
