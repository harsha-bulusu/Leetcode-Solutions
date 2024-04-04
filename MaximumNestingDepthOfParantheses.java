class Solution {
    public int maxDepth(String s) {
        // TC: O(N) SC: O(1)
        int depth = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '(') depth++;
            else if (ch == ')') {
                maxDepth = Math.max(depth, maxDepth);
                depth--;
            }
        }
        return maxDepth;

        /**
            * Using stack: TC: O(N) SC: O(N)
         */
        // int maxDepth = 0;
        // Stack<Character> stack = new Stack<>();
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if (ch == '(') stack.push(ch);
        //     else if (ch == ')') {
        //         maxDepth = Math.max(maxDepth, stack.size());
        //         stack.pop();
        //     }   
        // }
        // return maxDepth;
    }
}
