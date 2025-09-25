package main.java.org.lld.StrategyPattern;

public class PaymentGatewayHandler {
    public static void main(String[] args){
        PaymentGateway paymentGateway = new PaymentGateway();

        paymentGateway.addPaymentMethod(new CreditCardStrategy(),"Credit Card");
        paymentGateway.addPaymentMethod(new DebitCardStrategy(), "Debit Card");
        paymentGateway.pay("Debit Card", 12.567f);

        paymentGateway.addPaymentMethod(new UPIStrategy(), "UPI");
        paymentGateway.pay("UPI", 1232.567f);
    }
}
