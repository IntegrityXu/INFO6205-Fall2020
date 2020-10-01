class MinStack {

    /** initialize your data structure here. */
    Stack <Integer> mins;
    public MinStack() {  
        mins = new Stack<>();
    }
    
    Stack<Integer> stack = new Stack();
    
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty()) mins.push(x);
        else {
            if (mins.peek() >= x) {
                mins.push(x);
            }
        }
    }
    
    public void pop() {
        int tmp = stack.pop();
        if (tmp == mins.peek()) {
            mins.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */