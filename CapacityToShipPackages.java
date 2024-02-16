class Solution {

    int findMaxCapacity(int[] weights) {
        int sum = 0;
        for (int weight: weights) sum += weight;
        return sum;
    }
    

    public int shipWithinDays(int[] weights, int days) {
        int maxCapacity = findMaxCapacity(weights);

        // define search space with different capacities
        int low = 1, high = maxCapacity;
        int res = Integer.MAX_VALUE;

        while (low <= high){
            int cap = (low + high) / 2; // considering a mid capacity
            int daysTaken = 1;
            int shipWeight = 0;
            for (int weight : weights) {
                if (weight > cap) {
                    daysTaken = Integer.MAX_VALUE;
                    break;
                }
                if ((shipWeight + weight) <= cap) {
                    shipWeight += weight;
                } else {
                    daysTaken++;
                    shipWeight = weight;
                }
            }

            if (daysTaken <= days) {
                res = cap;
                high = cap - 1;
            } else {
                low = cap + 1;
            }

        }

        return res;
    }
}
