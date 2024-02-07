class Solution {

    void partition(int low, int high, int[] nums) {
        if (low == high) return;

        int mid = (low + high) / 2;
        partition(low, mid, nums);
        partition(mid + 1, high, nums);
        merge(low, high, nums);
    }

    void merge(int low, int high, int[] nums) {
        int n = nums.length;
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }
        int mid = (low + high) / 2;
        int i = low, j = mid + 1, k = low;

        while (i <= mid && j <=high) {
            if (temp[i] < temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            nums[k++] = temp[i++];
        }

        while (j <= high) {
            nums[k++] = temp[j++];
        }
    }

    void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] nums) {
        /**
            * Approach - 1: sorting: Merge sort
            TC : O(nlogn), SC : O(n)
         */
        // int n = nums.length;
        // partition(0, n - 1, nums);

        /**
            * Approach -2 : Counting occurrances
            * TC: O(n) + O(n)
        */
        // int cnt0 = 0;
        // int cnt1 = 0;
        // int cnt2 = 0;
        // for (int i : nums) {
        //     if (i == 0) cnt0++;
        //     else if (i == 1) cnt1++;
        //     else cnt2++;
        // }
        // for (int i = 0; i < cnt0; i++) nums[i] = 0;
        // for (int i = cnt0; i < cnt0 + cnt1; i++) nums[i] = 1;
        // for (int i = cnt0 + cnt1; i < cnt0 + cnt1 + cnt2; i++) nums[i] = 2;


        /**
            * Approach - 3: Dutch National flag algorithm
            TC: O(n), SC: O(1)
         */
        int n = nums.length;
        int low = 0, high = n - 1, mid = 0;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { //mid == 2
                swap(mid, high, nums);
                high--;
            }
        }
    }
}
