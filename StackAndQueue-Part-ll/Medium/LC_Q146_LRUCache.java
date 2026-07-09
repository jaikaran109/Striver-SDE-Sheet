// Review

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        addAfterHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node oldNode = map.get(key);

            remove(oldNode);
            map.remove(key);
        }

        Node newNode = new Node(key, value);

        addAfterHead(newNode);
        map.put(key, newNode);

        if(map.size() > capacity) {
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
    }

    private void remove(Node node) {
        Node before = node.prev;
        Node after = node.next;

        before.next = after;
        after.prev = before;
    }

    private void addAfterHead(Node node) {
        Node currentFirst = head.next;

        head.next = node;
        node.prev = head;

        node.next = currentFirst;
        currentFirst.prev = node;
    }
}



// Ques :- 
// Is problem me hume ek cache design karna hai jisme `put(key, value)` se data store hota hai aur `get(key)` se data access hota hai.

// Main condition ye hai ki cache ki capacity limited hoti hai. Agar cache full ho jaye, to hume us key ko remove karna hota hai jo sabse pehle use hui thi ya longest time se use nahi hui.

// Isi ko Least Recently Used, yani LRU, bolte hain.

// Simple idea ye hai:

// Jab bhi koi key `get()` se access hoti hai ya `put()` se insert/update hoti hai, vo key most recently used ban jaati hai.

// Agar cache capacity se zyada ho jaye, to hum least recently used key ko remove kar dete hain.

// Isko efficiently karne ke liye hum HashMap aur Doubly Linked List use karte hain.

// HashMap se hume kisi bhi key ka node O(1) time me mil jata hai.

// Doubly Linked List se hum recent usage order maintain karte hain. Head ke paas most recently used key hoti hai, aur tail ke paas least recently used key hoti hai.

// So, jab bhi koi key use hoti hai, hum usko front me move kar dete hain. Aur jab cache full hota hai, hum tail ke pehle wale node ko remove kar dete hain.
