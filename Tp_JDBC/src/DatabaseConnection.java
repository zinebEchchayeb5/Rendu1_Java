import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/gestion_evenements";
        String user = "root";
        String password = "Zineb@2005"; // Remplacez par votre mot de passe
        return DriverManager.getConnection(url, user, password);
    }
}
