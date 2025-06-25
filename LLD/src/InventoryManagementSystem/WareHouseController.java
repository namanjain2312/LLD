package InventoryManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class WareHouseController {
    ConcurrentHashMap<String, WareHouse> warehouseMap;

    WareHouseController() {
        this.warehouseMap = new ConcurrentHashMap<>();
    }

    boolean addItem(String itemId, int count, String warehouseId) {
        warehouseMap.putIfAbsent(warehouseId,new WareHouse(warehouseId));

        if(!warehouseMap.get(warehouseId).getInventoryMap().containsKey(itemId))
        {
            warehouseMap.get(warehouseId).getInventoryMap().put(itemId,new InventoryItem(itemId,count));
            return true;
        }

        InventoryItem existingInventory = warehouseMap.get(warehouseId).getInventoryMap().get(itemId);
        synchronized (existingInventory) {
            existingInventory.getAvailableCount().addAndGet(count);
        }

        return true;
    }

    boolean removeItem(String itemId, int count, String warehouseId) {
        if(!warehouseMap.containsKey(warehouseId))
            return false;
        else if(!warehouseMap.get(warehouseId).getInventoryMap().containsKey(itemId))
            return false;
        InventoryItem itemToBeRemoved = warehouseMap.get(warehouseId).getInventoryMap().get(itemId);
        synchronized (itemToBeRemoved) {
            if (itemToBeRemoved.getAvailableCount().get() < count)
                return false;

            itemToBeRemoved.getAvailableCount().addAndGet(-1 * count);

            if (itemToBeRemoved.getAvailableCount().get() < itemToBeRemoved.getThreshold())
                notifyManager(itemId, warehouseId);
        }
        return true;
    }

    ///    boolean reserveItem(String itemId, int count, String warehouseId);
    ///    boolean unreserveItem(String itemId, int count, String warehouseId);

    int getItemCount(String itemId) {
        int totalItemCount = 0;

        for(Map.Entry<String,WareHouse> entry : warehouseMap.entrySet()) {
            if(entry.getValue().getInventoryMap().containsKey(itemId))
                totalItemCount += entry.getValue().getInventoryMap().get(itemId).getAvailableCount().get();
        }
        return totalItemCount;
    }

    Map<String, Integer> getItemCountPerWarehouse(String itemId) {
        Map<String,Integer> itemCountPerWareHouse = new HashMap<>();
        for (Map.Entry<String,WareHouse> entry : warehouseMap.entrySet())
        {
            if(entry.getValue().getInventoryMap().containsKey(itemId))
                itemCountPerWareHouse.put(entry.getKey(),entry.getValue().getInventoryMap().get(itemId).getAvailableCount().get());
        }
        return  itemCountPerWareHouse;
    }

    void notifyManager(String itemId, String warehouseId) {
        System.out.println("ItemId : " + itemId + " is less than the threshold in warehouse : " +  warehouseId);
    }


}
