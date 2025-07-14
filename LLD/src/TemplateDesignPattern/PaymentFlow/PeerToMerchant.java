package TemplateDesignPattern.PaymentFlow;

public class PeerToMerchant extends  PayementFlow{

    @Override
    public void validateRequest() {
        //Make according to your own logic
    }

    @Override
    public void debitAmount() {
        //Make according to your own logic
    }

    @Override
    public void calculateFees() {
        //Make according to your own logic
    }

    @Override
    public void creditAmount() {
        //Make according to your own logic
    }

}
