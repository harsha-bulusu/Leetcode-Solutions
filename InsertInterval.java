class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();

        int n = intervals.length;
        int i = 0;
        //add non overlapping intervals into the res
        for (i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (end >= newInterval[0]) {
                break;
            }
            res.add(Arrays.asList(start, end));
        }

        //merge overlapping intervals
        for (i = i;  i< n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start > newInterval[1]) {
                break;
            }
            newInterval[0] = Math.min(start, newInterval[0]);
            newInterval[1] = Math.max(end, newInterval[1]);
        }
        res.add(Arrays.asList(newInterval[0], newInterval[1]));

        // add remaining intervals to the res

        for (i = i; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            res.add(Arrays.asList(start, end));
        }

        int rows = res.size();
        int[][] ans = new int[rows][2];

        for (i = 0; i < rows; i++) {
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }

        return ans;
    }
}
