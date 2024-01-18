class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int count = 0;
        int sum = 0;
        int operations = 0;
        for (int i = 1; i <= k; i++) sum += i;
        Set<Integer> set = new HashSet<>();

        for (int i = nums.size() - 1; i >= 0; i--) {
            if (sum == 0) break;
            int num = nums.get(i);
            if (num <= k && set.add(num)) sum -= num;
            operations++;
        }

        return operations;
    }
}
