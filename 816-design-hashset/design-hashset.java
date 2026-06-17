class MyHashSet {

    ArrayList<Integer> set;

    public MyHashSet() {
        set = new ArrayList<>();
    }
    
    public void add(int key) {
        if(!contains(key)){
            set.add(key);
        }
    }
    
    public void remove(int key) {
        if(contains(key)){
            set.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        for(int val : set){
            if(val == key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */