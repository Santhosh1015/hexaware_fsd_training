package designPattern.singletonPattern;

public class DBConnection {

    static DBConnection dbConnection = new DBConnection();
    private DBConnection(){}
    public void DBConnect(){

    }
    public void DBClose(){

    }
    public static DBConnection getInstance(){
        return dbConnection;
    }

}
