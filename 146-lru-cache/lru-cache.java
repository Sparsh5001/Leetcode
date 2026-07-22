class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key,int val){
            this.val = val;
            this.key = key;
        }
    }

    HashMap<Integer,Node>map = new HashMap<>();
    Node front;
    Node tail;
    int cap;
    int size;


    public LRUCache(int capacity) {
        front = null;
        tail = null;
        size = 0;
        cap = capacity; 
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            if(cur==tail && cur!=front){
                //removed from last 
                cur.prev.next=null;
                tail = cur.prev;
                //add to front
                cur.prev = null;
                cur.next = front;
                front.prev = cur;
                front = cur;
            }
            else if(cur!=front && cur!=tail){
                //remove from middle
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                //add to front
                cur.prev = null;
                cur.next = front;
                front.prev = cur;
                front = cur;
            }
            return cur.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
            map.get(key).val = value;
            get(key);
            return;
        }

        if(size==cap){
            map.remove(tail.key);
            Node node = new Node(key , value);
            map.put(key,node);
            if(size==1){
                front = tail = node;
                node.prev = node.next = null;
            }else{
                tail=tail.prev;
                node.prev=null;
                node.next=front;
                front.prev=node;
                front = node;
                tail.next=null;
            }
            return;
        }

        if(size<cap){
            Node node = new Node(key , value);
            map.put(key,node);
            if(size==0){
                front = tail = node;
                node.prev = node.next = null;
                size++;
            }else{
                node.prev=null;
                node.next=front;
                front.prev=node;
                front=node;
                size++;
            }
            return;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */