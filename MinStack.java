class MinStack {

    Stack<Long> stack;
    long min;

    public MinStack() {
        stack = new Stack<>();
        min = Long.MAX_VALUE; 
    }
    
    public void push(int val) {
        long value = Long.valueOf(val);
        if (stack.isEmpty()) {
            min = val;
            stack.push(value);
        } else {
            if (val < min) {
                //encode the value and push to the stack so that while decoding you can get prev min from it
                stack.push(2 * value - min);
                min = value;
            } else {
                stack.push(value);
            }
        }
    }
    
    public void pop() {
        long val = stack.pop();        
        // check if value is encoded or not
        if (val < min) {
            // decode
            min = 2 * min - val;
        }
    }
    
    public int top() {
        long val = stack.peek();

        if (val < min) {
            return (int)min;
        }
        return (int)val;
        
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
