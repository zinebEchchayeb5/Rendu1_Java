import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalleDAO {
    private final Connection connection;

    public SalleDAO(Connection connection) {
        this.connection = connection;
    }

    public void addSalle(Salle salle) throws SQLException {
        String sql = "INSERT INTO salles (id, nom, capacite) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, salle.getId());
            statement.setString(2, salle.getNom());
            statement.setInt(3, salle.getCapacite());
            statement.executeUpdate();
        }
    }

    public List<Salle> getAllSalles() throws SQLException {
        List<Salle> salles = new ArrayList<>();
        String sql = "SELECT * FROM salles";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Salle salle = new Salle(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getInt("capacite")
                );
                salles.add(salle);
            }
        }
        return salles;
    }

    public void deleteSalle(int id) throws SQLException {
        String sql = "DELETE FROM salles WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
