class Solution {
    public int[][] merge(int[][] intervals) {
        // Sorting the intervals in ascending order
        Arrays.sort(intervals, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return Integer.compare(e1[0], e2[0]);
            } else {
                return Integer.compare(e1[1], e2[1]);
            }
        });


        // check for overlapping intervals
        /**
            * Optimal TC: O(n)
         */
        List<List<Integer>> res = new ArrayList<>();
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!res.isEmpty() && res.get(res.size() - 1).get(1) >= start) { // overlapping
                int newEnd = Math.max(end, res.get(res.size() - 1).get(1));
                res.get(res.size() - 1).set(1, newEnd);
            } else { //not overlapping
                res.add(Arrays.asList(start, end));
            }
        }

        /**
            * Brute force TC: O(2N) SC: O(res)
         */

        // for (int i = 0; i < n; i++) {
        //     int start = intervals[i][0];
        //     int end = intervals[i][1];

        //     // compare how many can be merged with your interval

        //     if (!res.isEmpty() && res.get(res.size() - 1).get(1) >= end) {
        //         continue;
        //     }

        //     for (int j = i + 1; j < n; j++) {
        //         int currStart = intervals[j][0];

        //         if (currStart <= end) {
        //             end = Math.max(end, intervals[j][1]);
        //         } else {
        //             break;
        //         }
        //     }
        //     res.add(Arrays.asList(start, end));
        // }


        // convert res to 2d array and return
        int rows = res.size();
        int[][] ans = new int[rows][2];
        int cursor = 0;
        for (List<Integer> interval : res) {
            ans[cursor][0] = interval.get(0);
            ans[cursor][1] = interval.get(1);
            cursor++;
        }

        return ans;
    }
}
