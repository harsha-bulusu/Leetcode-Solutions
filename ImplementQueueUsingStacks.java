class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        while (!input.isEmpty()) {
            int ele = input.pop();
            output.push(ele);
        }
        input.add(x);
        while (!output.isEmpty()) {
            int ele = output.pop();
            input.push(ele);
        }
    }
    
    public int pop() {
        return input.pop();
    }
    
    public int peek() {
        return input.peek();
    }
    
    public boolean empty() {
        return input.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
