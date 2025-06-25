package InventoryManagementSystem;

import java.util.concurrent.ConcurrentHashMap;

public class WareHouse {

    private String wareHouseId;
    private ConcurrentHashMap<String, InventoryItem> inventoryMap;

    WareHouse(String wareHouseId) {
        this.wareHouseId = wareHouseId;
        this.inventoryMap = new ConcurrentHashMap<>();
    }

    public ConcurrentHashMap<String, InventoryItem> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(ConcurrentHashMap<String, InventoryItem> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }

    public String getWareHouseId() {
        return wareHouseId;
    }

    public void setWareHouseId(String wareHouseId) {
        this.wareHouseId = wareHouseId;
    }


}
