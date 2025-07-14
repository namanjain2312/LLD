package VendingMachine;

import java.util.List;

public class Amount {
    List<Coin> coinList;
    Integer totalAmount;

    public Amount(List<Coin> coinList, Integer totalAmount) {
        this.coinList = coinList;
        this.totalAmount = totalAmount;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
