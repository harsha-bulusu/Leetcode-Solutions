class Solution {

    // DP
    private boolean jump(int index, String s, int minJump, int maxJump, int n, Boolean[] dp) {
        if (index == n - 1) return true;
        if (dp[index] != null) return dp[index];

        for (int i = minJump; i <= maxJump; i++) {
            int newIndex = index + i;
            if (newIndex < n && s.charAt(newIndex) == '0'){
                if (jump(newIndex, s, minJump, maxJump, n, dp)) return dp[index] = true;
            }
        }

        return dp[index] = false;
    }

    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        // Boolean dp[] = new Boolean[n];

        // return jump(0, s, minJump, maxJump, n, dp);
        
        /**
            * BFS
         */
        // Queue<Integer> queue = new LinkedList<>();
        // queue.add(0);
        // int farthest = 0;

        // while (!queue.isEmpty()) {
        //     int index = queue.remove();

        //     int start = Math.max(index + minJump, farthest + 1);
        //     int end = Math.min(index + maxJump, n - 1);
        //     for (int i = start; i <= end; i++) {
        //         if (s.charAt(i) == '0'){ 
        //             queue.add(i);
        //             if (i == n - 1) return true;
        //         }
        //     }

        //     farthest = (index + maxJump);
        // }

        // return false;

        // sliding window
        boolean dp[] = new boolean[n];
        dp[0] = true;
        int reachable = 0;

        for (int i = 1; i < n; i++) {
            // increment reachable if this index is reachable from another index
            if (i >= minJump) reachable += dp[i - minJump] ? 1 : 0;
            // decrement reachable if this index is reachable from another index i.e., removing reachables from out of the window range
            if (i > maxJump) reachable -= dp[i - maxJump - 1] ? 1 : 0;

            // Are you reachable from any index??? The reachable indexes will be the sliding window range
            dp[i] = reachable > 0 && s.charAt(i) == '0';
        }

        return dp[n - 1];
    }
}
