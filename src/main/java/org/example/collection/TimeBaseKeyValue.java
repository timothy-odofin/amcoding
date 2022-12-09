package org.example.collection;

import org.example.model.Pair;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
 *
 * Implement the TimeMap class:
 *
 *     TimeMap() Initializes the object of the data structure.
 *     void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
 *     String get(String key, int timestamp) Returns a value such that set was called previously,
 *     *     with timestamp_prev <= timestamp. If there are multiple such values, it returns the
 *     *     value associated with the largest timestamp_prev.
 *     *     If there are no values, it returns "".
 * * * */
public class TimeBaseKeyValue {
    HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;

    public TimeBaseKeyValue() {
        keyTimeMap = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList());
        }

        // Store '(timestamp, value)' pair in 'key' bucket.
        keyTimeMap.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        // If the 'key' does not exist in map we will return empty string.
        if (!keyTimeMap.containsKey(key)) {
            return "";
        }

        if (timestamp < keyTimeMap.get(key).get(0).getKey()) {
            return "";
        }

        // Using binary search on the list of pairs.
        int left = 0;
        int right = keyTimeMap.get(key).size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (keyTimeMap.get(key).get(mid).getKey() <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // If iterator points to first element it means, no time <= timestamp exists.
        if (right == 0) {
            return "";
        }

        return keyTimeMap.get(key).get(right - 1).getValue();
    }
}
/**
 * Complexity Analysis
 *
 * If MMM is the number of set function calls, NNN is the number of get function calls, and LLL is average length of key and value strings.
 *
 *     Time complexity:
 *
 *         In the set() function, in each call, we push a (timestamp, value) pair in the key bucket, which takes O(L)O(L)O(L) time to hash the string. Thus, for MMM calls overall it will take, $O(M \cdot L)$ time.
 *
 *         In the get() function, we use binary search on the key's bucket which can have at most M elements and to hash the string it takes O(L)O(L)O(L) time, thus overall it will take O(L⋅logM)O(L \cdot logM)O(L⋅logM) time for binary search.
 *         And, for NNN calls overall it will take, $O(N \cdot L \cdot logM)$ time.
 *
 *     Space complexity:
 *
 *         In the set() function, in each call we store one value string of length L, which takes O(L) space.
 *         Thus, for MMM calls we may store MMM unique values, so overall it may take O(M⋅L) space.
 *
 *         In the get() function, we are not using any additional space.
 *         Thus, for all NNN calls it is a constant space operation.
 * * * */
