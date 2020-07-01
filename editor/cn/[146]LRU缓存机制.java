//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计


//leetcode submit region begin(Prohibit modification and deletion)
/**
 6.11 第一遍，7.1 第二遍
 思路：LRU API
 */
class LRUCache {
    class Node {
        private int key, val;
        private Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    class DoubleList {
        private int size;
        private Node head, tail;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            size = 0;
            head.next = tail;
            tail.prev = head;
        }

        public void addFirst(Node x) {
            x.next = head.next;
            head.next = x;
            x.prev = head;
            x.next.prev = x;
            head.next = x;
            size += 1;
        }

        public void remove(Node x) {
            size -= 1;
            x.next.prev = x.prev;
            x.prev.next = x.next;

        }

        public Node removeLast() {
            if (tail.prev == head) return null;
            size -= 1;
            Node tmp = tail.prev;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            // remove(tmp)
            return tmp;
        }

        public int size() {
            return size;
        }
    }



    private DoubleList cache;
    private HashMap<Integer, Node> map;
    private int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        Node curNode = new Node(key, value);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(curNode);
            map.put(key, curNode);
        } else {
            if (cache.size() == size) {
                // 从 HashMap 和 DoubleList 中删掉
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // add key
            cache.addFirst(curNode);
            map.put(key, curNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
