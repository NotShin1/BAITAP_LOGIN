package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final String serverName = "SHIN";    
    private final String dbName = "LTWEB";       
    private final String portNumber = "1433";  
    private final String instance = "";         
    private final String userID = "root";
    private final String password = "nhatnam1402@!"; 

    public Connection getConnection() throws Exception {
        String url;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
        } else {
            url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
                + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
        }
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            System.out.println(new DBConnection().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
