class Solution {

    void checkBalance(Stack<Character> stack, int[] bal) {
        while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop == '(') bal[1]++;
                    else bal[0]++;
        }
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int[] bal = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else if (ch == '(' && stack.peek() == ')') {
                checkBalance(stack, bal);
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        checkBalance(stack, bal);
        return bal[0] + bal[1];
    }
}
