class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Brute force
        // TC : O(n^2); SC: O(2)
        // int[] res = new int[2];
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == j) continue;
        //         int sum = nums[i] + nums[j];
        //         if (sum == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{};

        // Better approach : Hashing
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                return new int[]{i, map.get(rem)};
            }
            map.put(nums[i], i);
        }
        return new int[]{};

        //Optimal approach : Two pointers - Doesn't work with this as we are dealing with indexes and duplicates 
        // int n = nums.length;
        // int i = 0, j = n - 1;
        // Arrays.sort(nums);
        // while (i < j) {
        //     int sum = nums[i] + nums[j];
        //     System.out.println(sum);
        //     if (sum < target) i++;
        //     else if (sum > target) j--;
        //     else return new int[]{i, j};
        // }
        // return new int[]{-1, -1};
    }
}
