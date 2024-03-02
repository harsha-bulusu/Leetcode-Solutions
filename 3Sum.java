class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Set<List<Integer>> set = new HashSet<>();

        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             if (nums[i] + nums[j] + nums[k] == 0) {
        //                 List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(list);
        //                 set.add(list);
        //             }
        //         }
        //     }
        // }

        // List<List<Integer>> res = set.stream().collect(Collectors.toList());
        // return res;


        /**
            * Better
         */
        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     Set<Integer> range = new HashSet<>();
        //     for (int j = i + 1; j < n; j++) {
        //         int k = - (nums[i] + nums[j]);
        //         if (range.contains(k)) {
        //             List<Integer> list = Arrays.asList(nums[i], nums[j], k);
        //             Collections.sort(list);
        //             set.add(list);
        //         }
        //         range.add(nums[j]);
        //     }
        //     range.clear();
        // }

        // return set.stream().collect(Collectors.toList());

        /**
            * Optimal :  Using three pointers
         */

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i !=0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    // consider triplet
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return res;
    }
}
