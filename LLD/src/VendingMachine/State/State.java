package VendingMachine.State;

public interface State {

    public void acceptingCoin() throws Exception;
    public void insertCoin() throws Exception;
    public void selectSlot() throws Exception;
    public void returnChange() throws Exception;
    public void dispenseItem() throws Exception;
    public void cancel() throws Exception;

}
