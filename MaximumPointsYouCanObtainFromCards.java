class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // int n = cardPoints.length;
        // int max = 0;
        // for (int i = 0; i <= k; i++) {
        //     //left sum
        //     int points = 0;
        //     for (int l = 0; l < i; l++) {
        //         points += cardPoints[l];
        //     }   

        //     //right sum
        //     int picksRemaining = k - i;
        //     int j = n - 1;
        //     while (picksRemaining-- != 0) {
        //         points += cardPoints[j--];
        //     }

        //     max = Math.max(max, points);
        // }

        // return max;

        int n = cardPoints.length;
        int l = 0, r = n - k - 1;
        int points = 0, maxPoints = 0;
        for (int j = n - 1; j > r; j--) {
            points += cardPoints[j];
        }
        maxPoints = Math.max(maxPoints, points);

        for (int i = 0; i < k; i++) {
            points += cardPoints[i] - cardPoints[n - k + i];
            maxPoints = Math.max(maxPoints, points);
        }

        return maxPoints;
    }
}
