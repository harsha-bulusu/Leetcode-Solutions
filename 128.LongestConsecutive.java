class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).map(ele -> ele).boxed().collect(Collectors.toSet());
        int longest = 0;
        for(Integer i : set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int ele = i + 1;
                while(set.contains(ele)) { 
                    count++;
                    ele++;
                }
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
