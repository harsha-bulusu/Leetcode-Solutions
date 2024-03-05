class Pair {
    int ele;
    int max;

    public Pair(int ele, int max) {
        this.ele = ele;
        this.max = max;
    }

    public String toString() {
        return "{" + ele + ", " + max + "}";
    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res[] = new int[n];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            res[i] = heights[i];
        }

        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int ele = heights[i];
            int max = 0;
            if (stack.isEmpty()) {
                stack.push(new Pair(ele, 0));
            } else {
                while (!stack.isEmpty() && stack.peek().ele >= ele) {
                    Pair pair = stack.pop();
                    max += (1 + pair.max);
                }
                stack.push(new Pair(ele, max));
            }
            res[i] += (ele * max);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            int ele = heights[i];
            int max = 0;
            if (stack.isEmpty()) {
                stack.push(new Pair(ele, max));
            } else {
                while (!stack.isEmpty() && stack.peek().ele >= ele) {
                    Pair pair = stack.pop();
                    max += (1 + pair.max);
                }
                stack.push(new Pair(ele, max));
            }
            res[i] += (ele * max);
            maxArea = Math.max(res[i], maxArea);
        }

        return maxArea;
    }
}
