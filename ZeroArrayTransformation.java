class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            /**
                * Adding a marker at starting index to specify you need to decrement from here
             */ 
            diff[l] += 1;
            /**
                * Adding a marker at ending + 1 to say you can ignore decrementing from here
             */
            diff[r + 1] -= 1;
        }

        /**
            * Doing a prefix sum of the differences
         */
        for (int i = 1; i < n; i++) {
            if (diff[i] == 0) diff[i] = diff[i - 1];
            else diff[i] += diff[i - 1];
        }


        for (int i = 0; i < n; i++) {
            if (nums[i] - diff[i] > 0) return false;
        }

        return true;
    }
}
