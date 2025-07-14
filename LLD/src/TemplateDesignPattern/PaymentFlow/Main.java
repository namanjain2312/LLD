package TemplateDesignPattern.PaymentFlow;

public class Main {
    public static void main(String[] args) {
        PayementFlow payementFlow = new PeerToPeer();
        payementFlow.sendMoney();
    }

}
