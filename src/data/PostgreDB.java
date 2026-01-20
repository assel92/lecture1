package data;
import data.interfaces.IDB;
import java.sql.*;
public class PostgreDB implements IDB {
    @Override
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/OOPassik3";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "postgres", "assel09@");
            return con;
        } catch (Exception e) {
            System.out.println("Exception occured!");
            return null;
        }
    }
}


