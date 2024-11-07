class Solution {
    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        /** Brute Force: TLE */
        // int maxLength = 0;

        // for (int i = 0; i < Math.pow(2, n); i++) {
        //     int length = 0;
        //     int and = candidates[0]; 
            
        //     for (int j = 0; j < n; j++) {
        //         if ((i & (1 << j)) != 0) {
        //             and &= candidates[j];
        //             length++;
        //         }
        //     }

        //     if (and > 0) {
        //         maxLength = Math.max(maxLength, length);
        //     }
        // }

        // return maxLength;

        /** Storing count for each bit */
        // int count[] = new int[24];

        // for (int i = 0; i < n; i++) {
        //     int candidate = candidates[i];
        //     int pos = 0;
        //     while (candidate > 0) {
        //         // if ((candidate & 1) == 1) count[pos]++;
        //         count[pos] += candidate & 1;
        //         pos++;
        //         candidate >>= 1;
        //     }
        // }

        // int max = 0;
        // for (int i : count) {
        //     max = Math.max(max, i);
        // }

        // return max;

        /**3. Using max variable instead of using a count array */

        int maxCount = 0;
        for (int i = 0; i < 24; i++) {
            int cnt = 0;

            for (int candidate : candidates) {
                if ((candidate & (1 << i)) > 0) {
                    cnt++;
                }
            }
            maxCount = Math.max(maxCount, cnt);
        }

        return maxCount;
    }
}
