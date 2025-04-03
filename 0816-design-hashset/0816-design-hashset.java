class MyHashSet {
    private static final int SIZE = 10000;
    private Node[] set;

    private static class Node {
        int key;
        Node next;
        
        Node(int key) {
            this.key = key;
        }
    }

    public MyHashSet() {
        set = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        if (set[index] == null) {
            set[index] = new Node(key);
            return;
        }
        Node curr = set[index];
        while (curr != null) {
            if (curr.key == key) {
                return;
            }
            if (curr.next == null) {
                curr.next = new Node(key);
                return;
            }
            curr = curr.next;
        }
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = set[index], prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    set[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node curr = set[index];
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
