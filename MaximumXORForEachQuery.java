class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        /**Brute force: TLE */
        // int n = nums.length;
        // int answer[] = new int[n];

        // for (int i = 0; i < n; i++) {
        //     int maxK = 0;
        //     int maxXor = 0;
        //     for (int k = 0; k < Math.pow(2, maximumBit);k++) {
        //         int xor = k;
        //         for (int j = 0; j < n - i; j++) {
        //             xor ^= nums[j];
        //         }

        //         if (xor > maxXor) {
        //             maxK = k;
        //             maxXor = xor;
        //         }
        //     }
        //     answer[i] = maxK;
        // }

        // return answer;

        /**
            * Prefix sum
         */
        int n = nums.length;
        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        int[] answers = new int[n];
        int maxBitValue = (int)Math.pow(2, maximumBit) - 1;
        // Find answers for n queries
        for (int i = 0; i < n; i++) {
            // Each query should have a maximized K as answer
            if ((n - i) < n) {
                // Excluding the last element from the XOR
                xor ^= nums[n - i];
            }

            answers[i] = xor ^ maxBitValue;
        }

        return answers;
    }
}
