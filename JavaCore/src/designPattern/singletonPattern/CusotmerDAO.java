package designPattern.singletonPattern;

public class CusotmerDAO {

    // it will create lot of objects for the same operation

//    DBConnection dbConnection = new DBConnection();
//    public void getData(){
//        dbConnection.DBConnect();// executable statement should not be in the class
//        dbConnection.DBClose(); // executable statement should not be in the class
//    }
    DBConnection conn = DBConnection.getInstance();
    public void getData(){
        System.out.println("Customer Data...");
        System.out.println("DBConnection objects loc: "+conn);
        conn.DBConnect();// executable statement should not be in the class
        conn.DBClose(); // executable statement should not be in the class
    }
}
