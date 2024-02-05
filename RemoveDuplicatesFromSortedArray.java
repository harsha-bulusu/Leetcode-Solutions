class Solution {
    public int removeDuplicates(int[] nums) {
        //Hashing - Brute force T.C. : O(n) * logn + O(n) ; S.C: O(n)
        
        // Set<Integer> set = new TreeSet<>();
        // for (int num : nums) set.add(num);

        // int cursor = 0;
        // for (int num : set) {
        //     nums[cursor] = num;
        //     cursor++;
        // }
        // return cursor;

        // Two pointer
        // int i = 0;
        // int j = 1;
        // int n = nums.length;
        // int count = 1;
        // while (j < n) {
        //     if (nums[i] != nums[j]) {
        //         nums[i + 1] = nums[j];
        //         count++;  
        //         i += 1;
        //     }
        //     j += 1;
        // }
        // return count;

        // Two pointer using a for loop
        int i = 0;
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
