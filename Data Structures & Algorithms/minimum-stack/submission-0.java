class MinStack {
    List<Integer> stack;

    public MinStack() {
        this.stack = new ArrayList<>();
    }
    
    public void push(int val) {
        this.stack.add(val);
    }
    
    public void pop() {
        this.stack.remove(this.stack.size()-1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size()-1); 
    }
    
    public int getMin() {
        int minNum = this.stack.get(0);
        for(int i = 1; i < this.stack.size(); i++){
            minNum = minNum < this.stack.get(i) ? minNum : this.stack.get(i);
        }
        return minNum;
    }
}
