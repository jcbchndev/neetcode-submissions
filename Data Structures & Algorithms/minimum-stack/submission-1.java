class MinStack {

    private ArrayDeque<Integer> stack;
    private ArrayDeque<List<Integer>> minTracker;

    public MinStack() {
        stack = new ArrayDeque<>();
        minTracker = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()){
            minTracker.push(List.of(val, val));
        } else {
            int currentMinimum = minTracker.peek().get(1);
            if (val < currentMinimum){
                minTracker.push(List.of(val, val));
            } else {
                minTracker.push(List.of(val, currentMinimum));
            }
        }
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minTracker.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minTracker.peek().get(1);
    }
}
