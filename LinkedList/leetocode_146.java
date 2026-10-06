package LinkedList;

import java.util.HashMap;

public class leetocode_146 {
    class LRUCache {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head.next = tail;
        tail.prev = head;
    }

    // Add node at the end = Most Recently Used
    void add(Node node) {
        Node last = tail.prev;

        last.next = node;
        node.prev = last;

        node.next = tail;
        tail.prev = node;
    }

    // Remove node
    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Make it most recently used
        remove(node);
        add(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.value = value;

            remove(node);
            add(node);

            return;
        }

        // New key
        Node node = new Node(key, value);

        map.put(key, node);
        add(node);

        // Remove least recently used
        if (map.size() > capacity) {

            Node lru = head.next;

            remove(lru);
            map.remove(lru.key);
        }
    }
}
}
