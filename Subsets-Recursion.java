class Solution {

    void subsets(int[] arr, int index, int n, List<List<Integer>> res, List<Integer> ds) {
        if (index == n) {
            res.add(new ArrayList<>(ds));
            return;
        }

        ds.add(arr[index]);
        subsets(arr, index + 1, n, res, ds);
        ds.remove(Integer.valueOf(arr[index]));
        subsets(arr, index + 1, n, res, ds);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, nums.length, res, new ArrayList<>());
        return res;
    }
}
