class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int n = height.length;

        // // comparing two different lines TC O(n ^ 2) SC: O(1)
        // for (int i = 0; i < n; i++) {
        //     for (int j = 1; j < n; j++) {
        //         maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
        //     }
        // }


        //TC: O(n) SC: O(1)
        int l = 0, r = n - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxArea;
    }
}
