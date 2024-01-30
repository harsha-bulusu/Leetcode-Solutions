class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String token : tokens) {
            if (token.matches("-?[0-9]+")) {
                stack.push(Integer.valueOf(token));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                if (token.equals("+")) {
                    System.out.println(op1 + op2);
                    stack.push(op1 + op2);
                } else if (token.equals("-")) {
                    stack.push(op1 - op2);
                } else if (token.equals("*")) {
                    stack.push(op1 * op2);
                } else {
                    stack.push(op1 / op2);
                }

            }
        }

        return stack.pop();
    }
}
