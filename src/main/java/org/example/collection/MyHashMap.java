package org.example.collection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyHashMap {
    private final int MAX_LEN = 100000;             // the amount of buckets
    private List<DataStore<Integer, Integer>>[] map;     // hash map implemented by array

    /** Returns the corresponding bucket index. */
    private int getIndex(int key) {
        return key % MAX_LEN;
    }

    /** Search the key in a specific bucket. Returns -1 if the key does not existed. */
    private int getPos(int key, int index) {
        // Each bucket contains a list.
        List<DataStore<Integer, Integer>> temp = map[index];
        if (temp == null) {
            return -1;
        }
        // Iterate all the elements in the bucket to find the target key.
        for (int i = 0; i < temp.size(); ++i) {
            if (temp.get(i).getKey() == key) {
                return i;
            }
        }
        return -1;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = (List<DataStore<Integer, Integer>>[])new ArrayList[MAX_LEN];
    }

    /** value will always be positive. */
    public void put(int key, int value) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            // Add new (key, value) pair if key is not existed.
            if (map[index] == null) {
                map[index] = new ArrayList<DataStore<Integer, Integer>>();
            }
            map[index].add(new DataStore(key, value));
        } else {
            // Update the value if key is existed.
            map[index].set(pos, new DataStore(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos < 0) {
            return -1;
        } else {
            return map[index].get(pos).getValue();
        }
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        int pos = getPos(key, index);
        if (pos >= 0) {
            map[index].remove(pos);
        }
    }
}

class DataStore<K, V> implements Serializable {
    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public DataStore( K var1,  V var2) {
        this.key = var1;
        this.value = var2;
    }

    public String toString() {
        return this.key + "=" + this.value;
    }

    public int hashCode() {
        int var1 = 7;
        var1 = 31 * var1 + (this.key != null ? this.key.hashCode() : 0);
        var1 = 31 * var1 + (this.value != null ? this.value.hashCode() : 0);
        return var1;
    }

    public boolean equals(Object var1) {
        if (this == var1) {
            return true;
        } else if (!(var1 instanceof DataStore)) {
            return false;
        } else {
            DataStore var2 = (DataStore)var1;
            if (this.key != null) {
                if (!this.key.equals(var2.key)) {
                    return false;
                }
            } else if (var2.key != null) {
                return false;
            }

            if (this.value != null) {
                if (!this.value.equals(var2.value)) {
                    return false;
                }
            } else if (var2.value != null) {
                return false;
            }

            return true;
        }
    }
}
