class Solution {
    public int minOperations(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer num : nums) {
            if (freqMap.containsKey(num)) {
                freqMap.put(num, freqMap.get(num) + 1);
            } else {
                freqMap.put(num, 1);
            }
        }

        List<Integer> keysForDeletion = new LinkedList<>();

        int operations = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            int key = entry.getKey();
            while (freq > 1) {
                if (freq % 3 == 0) {
                    freq -= 3;
                } else if (freq % 2 == 0) {
                    freq -= 2;
                } else {
                    if (freq > 3) {
                        freq -= 3;
                    } else {
                        freq -= 2;
                    }
                }
                operations += 1;
            }
            
            if (freq == 0) keysForDeletion.add(key);
            freqMap.put(key, freq);
        }

        return freqMap.size() == keysForDeletion.size() ? operations : -1;
        
    }
}
