class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c1 = 0, c2 = 0, c3 = 0;
        int res[] = new int[m+n];
                
        while (c1 < m && c2 < n) {
            if (nums1[c1] < nums2[c2]) {
                res[c3] = nums1[c1];
                c1++;
                c3++;
            } else {
                res[c3] = nums2[c2];
                c2++;
                c3++;
            }
        }

        //copying remaining elements
        if (c1 < m) {
            for (int i=c1; i<m; i++) {
                res[c3] = nums1[i];
                c3++;
            }
        }

        if (c2 < n) {
            for (int i=c2; i<n; i++) {
                res[c3] = nums2[i];
                c3++;
            }
        }

        //copying elements from res to nums1
        for (int i=0; i<res.length; i++) {
            nums1[i] = res[i];
        }
    }
}
