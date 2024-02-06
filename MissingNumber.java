class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        /*1. Brute force : Linear search
            *TC: O(n * w); SC: O(1)
        */
        // for (int i = 0; i <= n; i++) {
        //     boolean found = false;
        //     for (int j = 0; j < n; j++) {
        //         if (nums[j] == i) {
        //             found = true;
        //             break;
        //         }
        //     }
        //     if (!found) return i;
        // }

        // return -1;

        /*2. Better : Using Hashing
        * TC : O(n) + O(n)
        * SC : O(n)
        */
        // int hash[] = new int[n + 1];
        // for (int i : nums) {
        //     hash[i] = 1;
        // }

        // for (int i = 0; i < hash.length; i++) {
        //     if (hash[i] == 0) return i;
        // }

        // return -1;

        /** 3. Optimal : Using sum
            * TC: O(n); SC: O(1)
         */
        //  int s1 = (n* (n + 1)) /2;
        //  int s2 = 0;
        //  for (int num : nums) s2 += num;
        //  return s1 - s2;

        /** 4. Optimal : Using Xor
            * TC: ; SC: 
         */
        
        int xor1 = 0; // xor of all numbers from 0..n
        int xor2 = 0; // xor of all numbers in numbers array
        for (int i = 0; i < n; i++) {
            xor1 ^= nums[i];
            xor2 ^= i + 1;
        }
        return xor1 ^ xor2;
    }
}
