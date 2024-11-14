class Solution {
    class Pair {
        int x;
        int steps;

        Pair(int x, int steps) {
            this.x = x;
            this.steps = steps;
        }
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) { // The queue logic also handles this scenario but this statement avoids unwanted processing
            return y - x;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, 0));

        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {

            Pair pair = queue.remove();
            int val = pair.x;
            int steps = pair.steps;
            visited.add(val);
            
            if (val == y) return steps;

            if (val % 11 == 0 && !visited.contains(val % 11)) {
                queue.add(new Pair(val / 11, steps + 1));
            }

            if (val % 5 == 0 && !visited.contains(val % 5)) {
                queue.add(new Pair(val / 5, steps + 1));
            }

            if (!visited.contains(val - 1)) {
                queue.add(new Pair(val - 1, steps + 1));
            }

            if (!visited.contains(val + 1)) {
                queue.add(new Pair(val + 1, steps + 1));
            }
        }

        return -1;
    }
}
