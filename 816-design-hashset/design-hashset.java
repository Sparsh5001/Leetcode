class Bucket {
        LinkedList<Integer> container;

        public Bucket() {
            this.container = new LinkedList<Integer>();
        }

        public void insert(Integer val) {
            if(this.container.indexOf(val) == -1){
                this.container.addFirst(val);
            }
        }

        public boolean check(Integer val){
            if(this.container.indexOf(val)==-1){
                return false;
            }
            return true;
        }

        public void delete(Integer val){
                this.container.remove(val);
        }
}


class MyHashSet {
    int num_bucket = 409;
    Bucket[] buckets;

    public MyHashSet() {
        this.buckets = new Bucket[this.num_bucket];

        for(int i = 0 ; i < num_bucket ; i++){
            this.buckets[i] = new Bucket();
        }
    }
    
    public void add(int key) {
        int index = key%num_bucket;
        this.buckets[index].insert(key);
    }
    
    public void remove(int key) {
        int index = key%num_bucket;
        this.buckets[index].delete(key);
    }
    
    public boolean contains(int key) {
        int index = key%num_bucket;
        return this.buckets[index].check(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */