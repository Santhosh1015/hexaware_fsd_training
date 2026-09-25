package designPattern.factory;

public class Phonepe extends UPI{
    @Override
    public double transactionCharge() {
        return 2;
    }

    @Override
    public double transactioLimit() {
        return 500000;
    }
}
