package designPattern.singletonPattern;

import com.beans.Customer;

public class App {
    public static void main(String[] args) {
        CusotmerDAO cusotmerDAO = new CusotmerDAO();
        cusotmerDAO.getData();
        PaymentDAO paymentDAO = new PaymentDAO();
        paymentDAO.getData();
        OrderDAO orderDAO = new OrderDAO();
        orderDAO.getData();
    }
}
