package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private final String serverName = "SHIN";    // Tên server của bạn
    private final String dbName = "LTWEB";       // Tên database
    private final String portNumber = "1433";    // SQL Server mặc định
    private final String instance = "";          // Nếu cài mặc định thì để trống, nếu có instance thì ghi ra VD: "SQLEXPRESS"
    private final String userID = "sa";          // SQL Server user
    private final String password = "nhatnam1402@!"; // password của user sa

    public Connection getConnection() throws Exception {
        String url;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=true;trustServerCertificate=true";
        } else {
            url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=true;trustServerCertificate=true";
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // load driver
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            Connection conn = new DBConnection().getConnection();
            if (conn != null) {
                System.out.println("✅ Kết nối thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
