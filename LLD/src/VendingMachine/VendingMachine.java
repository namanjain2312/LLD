package VendingMachine;

import java.util.List;
import java.util.Map;

public class VendingMachine {

    List<Slot> vendingMachineSlots;

    public void addingInventory()
    {
        Item iceCream = new Item("1",20,5,"IceCream");
        Item coldDrink = new Item("2",40,4,"ColdDrink");
        Slot slot1 = new Slot("SlotId1",iceCream);
        Slot slot2 = new Slot("SlotId2",coldDrink);
        vendingMachineSlots.add(slot1);
        vendingMachineSlots.add(slot2);
    }




}
