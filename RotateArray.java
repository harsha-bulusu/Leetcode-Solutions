class Solution {

    void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        if (k > n) return;
        // int temp[] = new int[k];
        // //copy the elements into a temp array
        // for (int i = n - k; i < n; i++) {
        //     temp[i - n + k] = nums[i];
        // }
        // //move the elements for k positions
        // for (int i = n - k - 1; i >= 0; i--) {
        //     nums[k + i] = nums[i];
        // }
        // //copy the elements from temp arr
        // for (int i = 0; i < k; i++) {
        //     nums[i] = temp[i];
        // }

        reverse(0, n - k - 1, nums);
        reverse(n - k, n - 1, nums);
        reverse(0, n - 1, nums);
    }
}
