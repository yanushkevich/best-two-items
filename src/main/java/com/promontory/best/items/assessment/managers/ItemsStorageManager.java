package com.promontory.best.items.assessment.managers;

import java.util.HashMap;
import java.util.Map;


public class ItemsStorageManager {

    private static int ITEM_STORAGE_INIT_CAPACITY = 1000;

    private Map<String, Map<Double, String>> itemStorage = new HashMap<>();

    public Map<Double, String> getItemStorage(String filePath) {
        return this.itemStorage.computeIfAbsent(filePath, map -> {
            Map<Double, String> itemsMap = new HashMap<>(ITEM_STORAGE_INIT_CAPACITY);
            return itemsMap;
        });
    }


}
