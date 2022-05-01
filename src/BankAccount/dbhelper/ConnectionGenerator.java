package BankAccount.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionGenerator {

    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:\\D:\\SQLiteStudio\\product.db");
            } catch (ClassNotFoundException e) {
                System.out.println("SQL Driver not found [" + e + "]");
            } catch (SQLException e) {
                System.out.println("SQL Exception [" + e + "]");
            }
        }
        return con;
    }    
}
