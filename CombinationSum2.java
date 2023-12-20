class Solution {

    void solve(int[] arr, int index, int target, List<Integer> ds, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) continue;
            ds.add(arr[i]);
            solve(arr, i + 1, target - arr[i], ds, res);
            ds.remove(Integer.valueOf(arr[i]));
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }
}
