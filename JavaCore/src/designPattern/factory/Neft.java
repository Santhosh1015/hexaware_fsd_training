package designPattern.factory;

public class Neft implements Payment{
    @Override
    public double transactionCharge() {
        return 10;
    }

    @Override
    public double transactioLimit() {
        return 500000;
    }
}
