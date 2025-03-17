class Solution {
    public boolean divideArray(int[] nums) {
        int[] arr = new int[501];

        for (int num : nums) {
            if (arr[num] %2 == 0) arr[num]++;
            else arr[num]--;
        }

        for (int ele : arr) {
            if (ele != 0) return false;
        }

        return true;
    }
}
