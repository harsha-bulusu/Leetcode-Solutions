class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        // for storing frequency of each card
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i : hand) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freqMap.keySet());
        
        while (!minHeap.isEmpty()) {
            int card = minHeap.peek();

            for (int i = card; i < card + groupSize; i++) {
                if (freqMap.containsKey(i)) {
                    freqMap.put(i, freqMap.get(i) - 1);
                    if (freqMap.get(i) == 0) {
                        minHeap.poll();
                    }
                } else {
                    return false;
                }
            }
        }

        return true;

    }
}
