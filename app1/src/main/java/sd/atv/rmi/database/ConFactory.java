package sd.atv.rmi.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {

    private static final String DATABASE = "sd";
    private static final String URL = "jdbc:postgresql://localhost:5432/" + DATABASE;
    private static final String USER = "postgres";
    private static final String PASSWORD = "secret";

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Nao possivel se conectar ao banco de dados:");
            e.printStackTrace();
            return null;
        }
    }

}
