class MyStack {
    Queue<Integer> q = new LinkedList<>();
    public MyStack() {
        this.q = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<>();
        while(!this.q.isEmpty()){
            temp.offer(this.q.peek());
            this.q.poll();
        }
        this.q.offer(x);
        while(!temp.isEmpty()){
            this.q.offer(temp.peek());
            temp.poll();
        }
        return;
    }
    
    public int pop() {
        return this.q.poll();   
    }
    
    public int top() {
        return this.q.peek();
    }
    
    public boolean empty() {
        return this.q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */