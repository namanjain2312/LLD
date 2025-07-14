package VendingMachine;

public class Item {
    String itemId;
    String itemName;
    Integer itemPrice;
    Integer totalQuantity;

    public Item(String itemId, Integer itemPrice, Integer totalQuantity, String itemName) {
        this.itemId = itemId;
        this.itemPrice = itemPrice;
        this.totalQuantity = totalQuantity;
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
