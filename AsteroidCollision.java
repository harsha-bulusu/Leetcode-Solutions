class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            int direction = asteroid > 0 ? 1 : -1;

            if (stack.isEmpty() || direction == 1) {
                stack.push(asteroid);
            } else {
                int abs = Math.abs(asteroid);
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < abs) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == abs)
                    stack.pop();
                else if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroid);
            }
        }


        int n = stack.size();
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
