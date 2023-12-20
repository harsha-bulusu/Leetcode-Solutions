class Solution {

    void solve(int[] arr, int index, int n, int target, List<Integer> ds, List<List<Integer>> res) {
        
        if (index == n) {
           if (target == 0) {
                res.add(new ArrayList<>(ds)); 
            }
            return;
        }

        
        if (target - arr[index] >= 0){
            ds.add(arr[index]);
            solve(arr, index, n, target - arr[index], ds, res);
            ds.remove(Integer.valueOf(arr[index]));
        }
        
        solve(arr, index + 1, n, target, ds, res);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        solve(candidates, 0, candidates.length, target, new ArrayList<>(), res);
        return res;
    }
}
