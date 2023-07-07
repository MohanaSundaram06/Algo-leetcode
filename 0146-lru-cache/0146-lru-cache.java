class LRUCache {
    int capacity;
    Node head;
    Node tail;
    HashMap<Integer,Node> map;
        
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void add(Node node){
        
        map.put(node.key, node);
        
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        
    }
    public void remove(Node node){
        map.remove(node.key);
        
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int get(int key) {
        
        if(!map.containsKey(key)) return -1;
        
        Node node = map.get(key);
        
        remove(node);
        add(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        if(map.size() == capacity) remove(tail.prev);
        
        Node node = new Node(key, value);
        
        add(node);
    }
}

class Node{
    
    int key;
    int val;
    Node next;
    Node prev;
    
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */










