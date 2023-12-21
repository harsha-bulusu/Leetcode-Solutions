class Solution {

    void solve(int[] arr, int index, int n, List<List<Integer>> res) {
        if (index == n) {
            List<Integer> ds = new ArrayList<>();
            for (int num : arr) ds.add(num);
            res.add(ds);
            return;
        }

        for (int i = index; i < n; i++) {
            swap(i, index, arr);
            solve(arr, index + 1, n, res);
            swap(i, index, arr);
        }
    }

    void swap(int u, int v, int[] arr) {
        int temp = arr[u];
        arr[u] = arr[v];
        arr[v] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, 0, n, res);
        return res;
    }
}
