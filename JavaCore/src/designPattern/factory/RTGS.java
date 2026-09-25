package designPattern.factory;

public class RTGS implements Payment{
    @Override
    public double transactionCharge() {
        return 50;
    }

    @Override
    public double transactioLimit() {
        return 1000000;
    }
}
