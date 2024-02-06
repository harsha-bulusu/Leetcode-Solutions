class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
            * Brute force : Compare elements from both arrays and store them sorted in an array, copy them to nums1 at end
            * TC : O(n + m) + O (n + m); SC : O(n + m)
         */
        //  int []res = new int[m + n];
        //  int c1 = 0, c2 = 0, c3 = 0;
        //  while (c1 < m && c2 < n) {
        //      if (nums1[c1] < nums2[c2]) {
        //          res[c3] = nums1[c1];
        //          c1++;
        //          c3++;
        //      } else {
        //          res[c3] = nums2[c2];
        //          c2++;
        //          c3++;
        //      }
        //  }

        //  //copy remaining elements
        //  while (c1 < m) {
        //      res[c3] = nums1[c1];
        //      c1++;
        //      c3++;
        //  }

        //  while (c2 < n) {
        //      res[c3] = nums2[c2];
        //      c2++;
        //      c3++;
        //  }

        //  //copy res to nums1 array
        //  for (int i = 0; i < res.length; i++) {
        //      nums1[i] = res[i];
        //  }

         //Optimal solution - Using two pointers and with no additional space
         // TC : O(m + n); SC : O(1)
         int i = m - 1, j = n - 1, k = m + n - 1;

         while (i >= 0 && j >= 0) {
             if (nums1[i] > nums2[j]) {
                 nums1[k] = nums1[i];
                 i--;
                 k--;
             } else {
                 nums1[k] = nums2[j];
                 j--;
                 k--;
             }
         } 

         while (i >= 0) {
             nums1[k] = nums1[i];
             i--;
             k--;
         }

         while (j >= 0) {
             nums1[k] = nums2[j];
             j--;
             k--;
         }
    }
}
