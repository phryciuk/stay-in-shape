package org.hryciuk.stayinshape.algorithms.binary_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    private Map<String, List<Item>> map;

    public TimeBasedKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Item> list;
        if (!map.containsKey(key)) {
            list = new ArrayList<>();
        } else {
            list = map.get(key);
        }
        list.add(new Item(value, timestamp));
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        String possibleResult = "";
        if (!map.containsKey(key)) {
            return possibleResult;
        }
        List<Item> list = map.get(key);
        int lo = 0;
        int hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                possibleResult = list.get(mid).value;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return possibleResult;
    }
}

class Item {
    String value;
    int timestamp;

    public Item(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}