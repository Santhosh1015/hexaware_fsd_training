package designPattern.factory;

public class PaymentFactory {
    public static  Payment getInstance(PaymentMode paymentMode) {
        return
                switch(paymentMode) {
                    case NEFT -> new Neft();
                    case RTGS -> new RTGS();
                    case GooglePay -> new GooglePay();
                    case PhonePe -> new Phonepe();
                    case PayTM -> new PayTM();
                };

    }
}
