class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            nums.add(i);
            fact *= i;
        }
        nums.add(n);
        k = k -1;
        String res = "";
        while (true) {
            int block = k / fact;
            res += nums.get(block);
            nums.remove(block);
            if (nums.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / nums.size();
        }
        return res;
    }
}
