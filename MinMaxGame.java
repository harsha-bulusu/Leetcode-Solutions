class Solution {
    public int minMaxGame(int[] nums) {
        int n = nums.length;
        int[] values = new int[n];
        for (int i = 0; i < n; i++) values[i] = nums[i];
        while (n != 1) {
            n = n /2;
            int arr[] = new int[n]; 
            for (int i = 0; i < arr.length; i++) {
                int val = 0;
                if (i % 2 == 0) {
                    val = Math.min(values[2 * i], values[2 * i + 1]);
                } else {
                    val = Math.max(values[2 * i], values[2 * i + 1]);
                }
                arr[i] = val;
            }
            values = arr;            
        }
        return values[0];
    }
}
