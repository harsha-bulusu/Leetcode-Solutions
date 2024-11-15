class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left + 1 < n && arr[left] <= arr[left + 1]) left++;
        while (right - 1 >= 0 && arr[right] >= arr[right - 1]) right--;

        if(left == n -1) return 0;

        int l = 0;
        int len = right, r = right;
        while (l <= left) {
            while (r < n && arr[r] < arr[l]) r++;
            len = Math.min(len, r - l -1);
            l++;
        }

        return len;
    }
}
