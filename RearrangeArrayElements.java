class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Brute force : TC: O(n) + O(n) SC : O(n)
        // int n = nums.length;
        // int pos[] = new int[n / 2];
        // int neg[] = new int[n / 2];
        // int res[] = new int[n];
        // int c1 = 0, c2 = 0;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] > 0) pos[c1++] = nums[i];
        //     else neg[c2++] = nums[i];
        // }
        // c1 = 0;
        // c2 = 0;
        // for (int i = 0; i < n; i+=2) {
        //     res[i] = pos[c1++];
        //     res[i + 1] = neg[c2++];
        // }
        // return res;

        // optimal TC: O(n) SC : O(n)
        int n = nums.length;
        int res[] = new int[n];
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[posIndex] = nums[i];
                posIndex += 2;
            }
            else {
                res[negIndex] = nums[i];
                negIndex += 2;
            }
        }
        return res;
    }
}
