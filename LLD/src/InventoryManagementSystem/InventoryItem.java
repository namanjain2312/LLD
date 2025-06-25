package InventoryManagementSystem;

import java.util.concurrent.atomic.AtomicInteger;

public class InventoryItem {
    private String itemId;
    private AtomicInteger availableCount;
    private AtomicInteger reservedCount;
    private int threshold;

    InventoryItem(String itemId,int count) {
        this.itemId = itemId;
        this.availableCount = new AtomicInteger(count);
        this.reservedCount = new AtomicInteger(0);
        this.threshold = 10;
    }

    public boolean isBelowThreshold() {
        return availableCount.get() < threshold;
    }

    public AtomicInteger getReservedCount() {
        return reservedCount;
    }

    public void setReservedCount(AtomicInteger reservedCount) {
        this.reservedCount = reservedCount;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public AtomicInteger getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(AtomicInteger availableCount) {
        this.availableCount = availableCount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


}
