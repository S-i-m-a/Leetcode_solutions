class MyHashMap {
    private static final int SIZE = 10000;
    private Node[] map;

    private static class Node {
        int key, value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
            return;
        }
        Node prev = null, curr = map[index];
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        prev.next = new Node(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = map[index];
        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = map[index], prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    map[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
