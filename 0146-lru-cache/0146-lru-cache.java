import java.util.*;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);  // Dummy head
        this.tail = new Node(0, 0);  // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Move the given node to the front (right after head)
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Add the node right after head
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Remove the given node from the linked list
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Get the value of the key if exists, otherwise return -1
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;  // Key not found
        }
        // Move the accessed node to the front
        moveToHead(node);
        return node.value;
    }

    // Insert or update the value of the key
    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            addNode(node);

            // If the cache is over capacity, remove the least recently used item
            if (cache.size() > capacity) {
                Node tailNode = tail.prev;
                removeNode(tailNode);
                cache.remove(tailNode.key);
            }
        } else {
            // Update the value of the existing node
            node.value = value;
            moveToHead(node);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // Capacity of 2
        cache.put(1, 1);  // Cache is {1=1}
        cache.put(2, 2);  // Cache is {1=1, 2=2}
        System.out.println(cache.get(1));  // Returns 1
        cache.put(3, 3);  // Evicts key 2, Cache is {1=1, 3=3}
        System.out.println(cache.get(2));  // Returns -1 (not found)
        cache.put(4, 4);  // Evicts key 1, Cache is {4=4, 3=3}
        System.out.println(cache.get(1));  // Returns -1 (not found)
        System.out.println(cache.get(3));  // Returns 3
        System.out.println(cache.get(4));  // Returns 4
    }
}
