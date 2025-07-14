package VendingMachine;

public class Coin {
    private Denomination denomination;
    private Integer quantity;

    public Coin(Denomination denomination, Integer quantity) {
        this.denomination = denomination;
        this.quantity = quantity;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public void setDenomination(Denomination denomination) {
        this.denomination = denomination;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
