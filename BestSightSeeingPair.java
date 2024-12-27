class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length; 
        /*
            * Assuming the first value to be the maximum value, as sum of other number with this max maximizes result
            * Removing -1 from it is becuase we exclude distance from the result and we start comparing with the immediate next index
            * The distance b/w curr index and next index is 1, so we are removing -1       
        */
        int max = values[0] - 1; 
        int res = 0;

        for (int i = 1; i < n; i++) {
            /**
                * Original formula to calculate res = values[i] + values[j] - i + j; i.e., adding pair of elements and removing distance
                * we already have a value from the pair with distance removed from it now we will add the other element of the pair
             */
            res = Math.max(res, max + values[i]);

            /**
                * we try finding max of curr_max v/s the curr_value and remove the distance from it to compare with next index
                * since we need a max value to compute max result            
             */
            max = Math.max(max - 1, values[i] - 1);
        }

        return res;
    }
}
