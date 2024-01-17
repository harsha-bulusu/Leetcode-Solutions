class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int c1 = 0, c2 = 0;
        while (c1 < m && c2 < n) {
            if (nums1[c1] == nums2[c2]) return nums1[c1];
            if (nums1[c1] < nums2[c2]) c1++;
            else if (nums1[c1] > nums2[c2]) c2++;
        }
        return -1;
    }
}
