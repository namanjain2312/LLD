package VendingMachine;

import java.util.List;

public class Slot {
    String slotId;
    Item item;

    public Slot(String slotId, Item item) {
        this.slotId = slotId;
        this.item = item;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
