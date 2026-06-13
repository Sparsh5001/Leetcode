class StockSpanner {
Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack();
    }
    
    public int next(int price) {
        int x = 0;
        if(!stack.isEmpty()){
            x = stack.peek()[1]+1;
        }
        

        while(!stack.isEmpty()){
            if(stack.peek()[0] > price){
                stack.push(new int[]{price , x});
                break;
            }
            else{
                stack.pop();
            }
        }

        if(stack.isEmpty()){
            stack.push( new int[]{price , x});
            return x+1;
        }

        return stack.peek()[1] - stack.get(stack.size()-2)[1];



    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */