/*
cacheHead and cacheTail track order of keys to remove
keyMap for get()
nodeMap() to update which node to remove

cache/node tracks keys
keyMap tracks key-value
nodeMap tracks key-node
*/
class LRUCache {
    Node cacheHead;
    Node cacheTail;
    HashMap<Integer, Integer> keyMap;
    HashMap<Integer, Node> nodeMap; 
    int capacity;
    int size;

    public LRUCache(int capacity) {
        cacheHead = new Node(-1);
        cacheTail = new Node(-1);
        link(cacheHead, cacheTail);

        keyMap = new HashMap<>();
        nodeMap = new HashMap<>();
        this.capacity = capacity;
        size = 0;
    }
    
    public int get(int key) {
        // get key and move key to end of cache if it exists
        int val = keyMap.getOrDefault(key, -1);
        if (val != -1) {
            Node node = nodeMap.get(key);
            link(node.prev, node.next);
            link(cacheTail.prev, node);
            link(node, cacheTail);
        }
        return val;
    }
    
    public void put(int key, int value) {
        // if key exists, update key and move key to end of cache
        if (keyMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            link(node.prev, node.next);
            link(cacheTail.prev, node);
            link(node, cacheTail);
        } else {
            // otherwise check size for overflow and add new key-value pair
            size++;
            if (size > capacity) {
                int oldKey = cacheHead.next.key
    ;
                keyMap.remove(oldKey);
                link(cacheHead, cacheHead.next.next);
                size--;
            }
            Node newNode = new Node(key);
            link(cacheTail.prev, newNode);
            link(newNode, cacheTail);
            nodeMap.put(key, newNode);
        }
        keyMap.put(key, value);
    }

    private class Node {
        int key;
        Node next;
        Node prev;

        public Node(int key) {
            this.key = key
;
            this.next = null;
            this.prev = null;
        }
    }

    private void link(Node head, Node tail) {
        head.next = tail;
        tail.prev = head;
    }
}
