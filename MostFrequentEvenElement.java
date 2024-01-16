class Solution {
    public int mostFrequentEven(int[] nums) {
        int len = ((int)1e5) / 2;
        int[] freq = new int[len + 1];
        int n = nums.length;
        int maxFreq = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) { //calculating frequency of only even numbers
                int index = nums[i] / 2;
                freq[index]++;
                maxFreq = Math.max(maxFreq, freq[index]);
            }
        }

        System.out.println(maxFreq);
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == maxFreq) {
                return i * 2;
            }
        }
        return -1;
    }
}
