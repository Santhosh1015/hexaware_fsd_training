package designPattern.factory;

public class PayTM extends UPI{
    @Override
    public double transactionCharge() {
        return 4;
    }

    @Override
    public double transactioLimit() {
        return 300000;
    }
}
