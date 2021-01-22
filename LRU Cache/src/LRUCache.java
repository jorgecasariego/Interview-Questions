import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * Follow up:
 * Could you do get and put in O(1) time complexity?
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 * Approach 1: Ordered dictionary
 *
 * Intuition
 *
 * We're asked to implement the structure which provides the following operations in O(1) time :
 *
 * Get the key / Check if the key exists
 *
 * Put the key
 *
 * Delete the first added key
 *
 * The first two operations in O(1) time are provided by the standard hashmap, and the last one - by linked list.
 *
 * There is a structure called ordered dictionary, it combines behind both hashmap and linked list.
 * In Python this structure is called OrderedDict and in Java LinkedHashMap.
 * Let's use this structure here.
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    /*
        getOrDefault(Object key, V defaultValue)
        Returns the value to which the specified key is mapped, or defaultValue if this map 
        contains no mapping for the key.
    */
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    /*
      Returns true if this map should remove its eldest entry.
        
      This method is invoked by put and putAll after inserting a new entry into the map. It provides the implementor with         the opportunity to remove the eldest entry each time a new one is added. This is useful if the map represents a             cache: it allows the map to reduce memory consumption by deleting stale entries.
      
      Parameters:
        eldest - The least recently inserted entry in the map, or if this is an access-ordered map, the least recently             accessed entry. This is the entry that will be removed it this method returns true. If the map was empty prior to           the put or putAll invocation resulting in this invocation, this will be the entry that was just inserted; in other         words, if the map contains a single entry, the eldest entry is also the newest.

    Returns:
        true if the eldest entry should be removed from the map; false if it should be retained.
    */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */