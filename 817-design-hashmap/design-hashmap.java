class Bucket {
    LinkedList<int[]> container;

    public Bucket() {
        this.container = new LinkedList<int[]>();
    }

    public void insert(int val , int num){
        int index = -1;

        for (int i = 0; i < this.container.size(); i++) {
            if (this.container.get(i)[0] == val) {
                index = i;
                break;
            }
        }
        if(index==-1){
            this.container.addFirst(new int[]{val , num});
        }else{
            this.container.get(index)[1] = num;
        }

    }

    public void delete(int val) {

        int index = -1;
        int i;
        for (i = 0; i < this.container.size(); i++) {
            if (this.container.get(i)[0] == val) {
                index = i;
                break;
            }
        }
        if(index!=-1){
                this.container.remove(this.container.get(i));
        }

    }


    public int find(int val) {
        int index = -1;
        int i;
        for (i = 0; i < this.container.size(); i++) {
            if (this.container.get(i)[0] == val) {
                index = i;
                break;
            }
        }
        if(index!=-1){
            return this.container.get(i)[1];
        }else{
            return -1;
        }

    }
}


class MyHashMap {

    int num_buckets = 719;
    Bucket[] buckets;

    public MyHashMap() {
        this.buckets = new Bucket[this.num_buckets];

        for(int i = 0 ; i < this.num_buckets ; i++){
            this.buckets[i] = new Bucket();
        } 
        
    }
    
    public void put(int key, int value) {
        int index = key%num_buckets;
        this.buckets[index].insert(key , value);
    }
    
    public int get(int key) {
        int index = key%num_buckets;
        return this.buckets[index].find(key);
    }
    
    public void remove(int key) {
        int index = key%num_buckets;
        this.buckets[index].delete(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */