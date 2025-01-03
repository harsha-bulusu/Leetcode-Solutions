class Solution {
    public int waysToSplitArray(int[] nums) {
        long leftSum = nums[0];
        long rightSum = 0;
        int cnt = 0;

        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }

        if (leftSum >= rightSum) cnt++;

        for (int i = 1; i < nums.length - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];

            if (leftSum >= rightSum) cnt++;
        }

        return cnt;

        // int cnt = 0;
        // int n = nums.length;
        // int[] prefix = new int[n];

        // for (int i = 0; i < n; i++) {
        //     prefix[i] = nums[i] + (i > 0 ? prefix[i - 1] : 0);
        // }

        // for (int i = 0; i < n - 1; i++) {
        //     System.out.println(i + " " + (prefix[i] >= (prefix[n - 1] - prefix[i])) + " " + prefix[i] + " " + (prefix[n-1] - prefix[i]));
        //     if (prefix[i] >= (prefix[n - 1] - prefix[i])) cnt++;
        // }

        // return cnt;
    }
}
