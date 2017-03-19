package com.algorithms.qartks;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by qartks on 3/19/17.
 */
public class LRUCache {

    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true) {
            protected boolean removeEldestElement(Map.Entry<Integer, Integer> e) {
                 return this.size() > capacity;
             }
        };
    }

    public Integer lookup(Integer key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        return cache.get(key);
    }

    public Integer insert(Integer key, Integer value) {
        Integer currValue = cache.get(key);

        if (!cache.containsKey(key)) {
            cache.put(key, value);
            return currValue;
        } else {
            return null;
        }
    }



    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);

        System.out.println(lruCache.cache.toString());
        lruCache.insert(1, 1);
        lruCache.insert(2, 2);
        lruCache.insert(3, 3);
        System.out.println(lruCache.cache.toString());
        lruCache.lookup(3);
        System.out.println(lruCache.cache.toString());
        lruCache.insert(4, 4);
        lruCache.insert(5, 5);
        lruCache.insert(5, 6);
        System.out.println(lruCache.cache.toString());

    }
}
