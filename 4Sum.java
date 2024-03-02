class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Set<List<Integer>> set = new HashSet<>();
        // int n = nums.length;    
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         for (int k = j + 1; k < n; k++) {
        //             for (int l = k + 1; l < n; l++) {
        //                 if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
        //                     List<Integer> quadraple = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
        //                     Collections.sort(quadraple);
        //                     set.add(quadraple);
        //                 }
        //             }
        //          }
        //     }
        // }

        // return set.stream().collect(Collectors.toList());


        /**
            * Better
         */
        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         Set<Long> range = new HashSet<>();
        //         for (int k = j + 1; k < n; k++) {
        //             long sum = nums[i] + nums[j];
        //             sum += nums[k];
        //             long l = target - sum;
        //             if (range.contains(l)) {
        //                 // a quadraple exists
        //                 List<Integer> quadraple = Arrays.asList(nums[i], nums[j], nums[k], (int)l);
        //                 Collections.sort(quadraple);
        //                 set.add(quadraple);
        //             }
        //             range.add((long)nums[k]);
        //         }
        //         range.clear();
        //     }
        // }

        // return set.stream().collect(Collectors.toList());

        /**
            * Optimal: 4 pointers 2 fixed, 2 moving
         */

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                // finding the remaining two elements in a range
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {
                        // quadraple found
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        return res;
    }
}
