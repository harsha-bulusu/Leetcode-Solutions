/**
Approach -1 : Recursion + Memoization

* Space complexity : O(n) * O(n * 4) => Recursion stack space + DP array for memoization
* Time complexity : O(n * 4) * 3 => n * 4 states for every day and checking 3 tasks on each day

/*import java.util.Arrays;

public class Solution {

  static int f(int points[][], int day, int lastDayTask, int dp[][]) {
        if (dp[day][lastDayTask] != -1) return dp[day][lastDayTask];
        int maxPoints = Integer.MIN_VALUE;
        if (day == 0) {
            for (int task = 0; task <= 2; task++) {
                if (task != lastDayTask) {
                    maxPoints = Math.max(maxPoints, points[day][task]);
                }
            }
            return dp[day][lastDayTask] = maxPoints;
        }
        
        maxPoints = Integer.MIN_VALUE;
        for (int task = 0; task <= 2; task++) {
            if (task != lastDayTask) {
                int currPoints = points[day][task] + f(points, day - 1, task, dp);
                maxPoints = Math.max(currPoints, maxPoints);
            }
        } 
        return dp[day][lastDayTask] = maxPoints;
    }
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int dp[][] = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(points, n - 1, 3, dp);
    }

}*/

