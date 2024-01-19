class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(arr[i] - arr[i + 1]);
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i + 1]);
            if (diff < minDiff) {
                res = new ArrayList<>();
                minDiff = diff;
            }
            if (diff == minDiff)
                res.add(list);
        }
        return res;
    }
}
