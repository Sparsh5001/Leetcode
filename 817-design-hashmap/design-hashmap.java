class Pair {
    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {

    LinkedList<Pair> container;

    public Bucket() {
        this.container = new LinkedList<>();
    }

    public void insert(int val , int num){
        for (Pair pair : this.container) {
            if (pair.key == val) {
                pair.value = num;
                return;
            }
        }
        this.container.addFirst(new Pair(val , num));
    }

    public void delete(int val) {
        for (Pair pair : this.container) {
            if (pair.key == val) {
                this.container.remove(pair);
                return;
            }
        }
    }

    public int find(int val) {
        for (Pair pair : container) {
            if (pair.key == val) {
                return pair.value;
            }
        }
        return -1;
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