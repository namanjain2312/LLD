package VendingMachine.State;


public class IdleState implements State{
    @Override
    public void acceptingCoin() {
        System.out.println("Please enter the coin");
    }

    @Override
    public void insertCoin() throws Exception {
        throw  new Exception("Insert Coin Function called from Idle  State");
    }

    @Override
    public void selectSlot() throws Exception {
        throw  new Exception("Select Slot Function called from Idle  State");
    }

    @Override
    public void returnChange() throws Exception {
        throw  new Exception("Return Change Function called from Idle  State");
    }

    @Override
    public void dispenseItem() throws Exception {
        throw  new Exception("Dispense Item Function called from Idle  State");

    }

    @Override
    public void cancel() throws Exception {
        throw new Exception("Cancel Function is been called from Idle State");

    }
}
