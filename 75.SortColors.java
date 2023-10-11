class Solution {

    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        
        /** Approach-1

            * Time Complexity : O(N)Log(N) 
            * Space Complexity: O(1)
            int c1 = 0;
            int c2 = 1;

            while (c1 != nums.length - 1) {
                if (c2 == nums.length) {
                    c1++;
                    c2 = c1 + 1;
                    continue;
                }

                if (nums[c1] > nums[c2]) {
                    int temp = nums[c1];
                    nums[c1] = nums[c2];
                    nums[c2] = temp;
                }

                c2++;
        }
         */

        /** Approach-2
            * Time Complexity :O(N) + O(N) - counting N elements + Rearranging N elements
            * Space Complexity: O(1)
            int cnt0 = 0, cnt1 = 0, cnt2 = 1;

            for (Integer num : nums) {
                if (num == 0) cnt0++;
                if (num == 1) cnt1++;
                if (num == 2) cnt2++;
            }

            for (int i = 0; i < cnt0; i++) {
                nums[i] = 0;
            }

            for (int i = cnt0; i < cnt0+cnt1; i++) {
                nums[i] = 1;
            }

            for (int i = cnt0 + cnt1; i < nums.length; i++) {
                nums[i] = 2;
            }
         */

        
        /**
            Approach-3: Dutch Flag Algorithm
            Time complexity: O(N)
            Space complexity: O(1)
         */


        int mid = 0, low =0, high = nums.length - 1;
        while(mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(mid, high, nums);
                high--;
            }
        }

    }
}
