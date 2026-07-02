class FreqStack {

    HashMap<Integer,Integer> map;
    HashMap<Integer,Stack<Integer>> st_map;
    int max_freq;

    public FreqStack() {
        map = new HashMap<>();
        st_map = new HashMap<>();
        max_freq = 0;
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        max_freq = Math.max(max_freq , map.get(val));
        //st_map.computeIfAbsent(map.get(val), k -> new Stack<>()).push(val);
        if(!st_map.containsKey(map.get(val))){
            st_map.put(map.get(val),new Stack<>());
        }
        st_map.get(map.get(val)).push(val);
    }
    
    public int pop() {
        int val = st_map.get(max_freq).pop();
        if(st_map.get(max_freq).isEmpty()){
            max_freq--;
        }
        map.put(val,map.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */