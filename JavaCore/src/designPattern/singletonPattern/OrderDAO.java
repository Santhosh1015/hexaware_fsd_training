package designPattern.singletonPattern;

public class OrderDAO {
    DBConnection conn = DBConnection.getInstance();
    public void getData(){
        System.out.println("Order Data...");
        System.out.println("DBConnection objects loc: "+conn);
        conn.DBConnect();// executable statement should not be in the class
        conn.DBClose(); // executable statement should not be in the class
    }
}
