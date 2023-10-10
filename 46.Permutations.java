class Solution {

    void solve(int[] nums, boolean[] ref, List<Integer> list, List<List<Integer>> res) {

        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!ref[i]) {
                list.add(nums[i]);
                ref[i] = true;
                solve(nums, ref, list, res);
                list.remove(list.size() - 1);
                ref[i] = false;
            }
        }

    }


    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] ref = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, ref, list, res);
        return res;
    }
}
