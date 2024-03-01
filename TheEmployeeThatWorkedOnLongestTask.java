class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int max = Integer.MIN_VALUE;
        int prev_end = 0;
        int len = logs.length;
        int resEmp = -1;
        for (int i = 0; i < len; i++) {
            int emp = logs[i][0];
            int endTime = logs[i][1];

            int taskCompletionTime = endTime - prev_end;
            prev_end = endTime;
            if (taskCompletionTime >= max) {
                if (taskCompletionTime == max) {
                    resEmp = Math.min(resEmp, emp);
                } else {
                    resEmp = emp;
                }
                max = taskCompletionTime;
            } 
        }

        return resEmp;
    }
}
