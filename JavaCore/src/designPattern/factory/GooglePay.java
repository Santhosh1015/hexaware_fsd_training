package designPattern.factory;

public class GooglePay extends UPI{
    @Override
    public double transactionCharge() {
        return 1;
    }

    @Override
    public double transactioLimit() {
        return 100000;
    }
}
