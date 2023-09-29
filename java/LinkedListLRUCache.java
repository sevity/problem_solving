package java;
import java.util.*;

class LinkedListLRUCache {
    private final int capacity;
    private final Map<Integer, Integer> map;
    private final LinkedList<Integer> keys;

    public LinkedListLRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.keys = new LinkedList<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            keys.remove((Integer) key); // Object로 캐스팅하여 정확한 오버로드를 호출
            keys.addFirst(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            keys.remove((Integer) key); // Object로 캐스팅하여 정확한 오버로드를 호출
        } else if (keys.size() == capacity) {
            int lastKey = keys.removeLast();
            map.remove(lastKey);
        }
        keys.addFirst(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LinkedListLRUCache cache = new LinkedListLRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }
}
