class Solution {
    class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        if (a != 0) priorityQueue.add(new Pair('a', a));
        if (b != 0) priorityQueue.add(new Pair('b', b));
        if (c != 0) priorityQueue.add(new Pair('c', c));


        String res = "";
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.poll();
            if (res.length() > 1 && res.charAt(res.length() - 1) == pair.ch && res.charAt(res.length() - 2) == pair.ch) {
                if (priorityQueue.isEmpty()) break;
                Pair pair2 = priorityQueue.poll();
                res += pair2.ch;
                pair2.count -= 1;
                if (pair2.count > 0) {
                    priorityQueue.add(pair2);
                }
            } else {
                res += pair.ch;
                pair.count -= 1;
            }

            if (pair.count > 0) {
                priorityQueue.add(pair);
            }

        }

        return res;
    }
}
