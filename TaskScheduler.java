class Pair {
    int pending;
    int time;

    public Pair(int pending, int time) {
        this.pending = pending;
        this.time = time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((t1, t2) -> t2 - t1);
        maxHeap.addAll(freqMap.values());

        Queue<Pair> queue = new LinkedList<>();
        int time = 0;
        while(!queue.isEmpty() || !maxHeap.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int task = maxHeap.poll();
                int pending = task - 1;

                if (pending != 0) {
                    queue.add(new Pair(pending, time + n));
                }
            }

            if (!queue.isEmpty() && queue.peek().time <= time) {
                maxHeap.add(queue.poll().pending);
            }            
            
        }
        return time;
    }
}
