package VendingMachine.State;

import VendingMachine.Amount;
import VendingMachine.Coin;
import VendingMachine.Denomination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertCoinState implements State{

    @Override
    public void acceptingCoin() throws Exception {
        throw  new Exception("Accepting Coin Function called from Insert Coin  State");
    }

    @Override
    public void insertCoin() {
        Coin coin1 = new Coin(Denomination.Ten,2);
        Coin coin2 = new Coin(Denomination.Two,2);
        List<Coin> coinList = new ArrayList<>(Arrays.asList(coin2,coin1));
        Amount insertedAmount = new Amount(coinList,getTotalAmount(coinList));
    }

    @Override
    public void selectSlot() {

    }

    @Override
    public void returnChange() {

    }

    @Override
    public void dispenseItem() {

    }

    @Override
    public void cancel() {

    }

    Integer getTotalAmount(List<Coin> coinList)
    {
        Integer totalAmount=0;
        for(Coin coin : coinList)
        {
            if(coin.getDenomination().equals(Denomination.Ten))
                totalAmount+=coin.getQuantity()*10;
            else if(coin.getDenomination().equals(Denomination.One))
                totalAmount+=coin.getQuantity();
            else if(coin.getDenomination().equals(Denomination.Two))
                totalAmount+=coin.getQuantity()*2;
            else if(coin.getDenomination().equals(Denomination.Five))
                totalAmount+=coin.getQuantity()*5;

        }
        return  totalAmount;
    }
}
