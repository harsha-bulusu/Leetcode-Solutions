class Solution {

    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = j;
        nums[j] = temp;
    }

    public int[] sortArrayByParityII(int[] nums) {
        // Brute force : Copy elements into odd and even arrays and put them in res
        // TC : O(n) + O(n) SC : O(n) + O(n)
        // int n = nums.length;
        // int[] even = new int[n / 2];
        // int[] odd = new int[n / 2];
        // int i = 0, j = 0;
        // for (int num : nums) {
        //     if (num % 2 == 0) {
        //         even[i] = num;
        //         i++;
        //     }
        //     else {
        //         odd[j] = num;
        //         j++;
        //     }
        // }

        // int[] res = new int[n];
        // i = j = 0;
        // for (int k = 0; k < n; k += 2) {
        //     res[k] = even[i];
        //     res[k + 1] = odd[j];
        //     i++;
        //     j++;
        // }
        // return res;

        // Better : TC : O(n) SC : O(n)
        int n = nums.length;
        int[] res = new int[n];
        int e = 0, o = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                res[e]  = nums[i];
                e += 2;
            } else {
                res[o] = nums[i];
                o += 2;
            }
        }
        return res;

    }
}
