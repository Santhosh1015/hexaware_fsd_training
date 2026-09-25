package designPattern.factory;

import designPattern.singletonPattern.PaymentDAO;

public class App {
    public static void main(String[] args) {
        try {
            Payment payment = PaymentFactory.getInstance(PaymentMode.NEFT);
            // assert payment != null;
            System.out.println(payment.transactionCharge());
            System.out.println(payment.transactioLimit());
        }
        catch(RuntimeException e){
            System.out.println("Payment failed...");
        }
    }
}
