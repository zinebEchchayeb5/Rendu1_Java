import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvenementDAO {
    private Connection connection;

    public EvenementDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean evenementExiste(String nom) throws SQLException {
        String query = "SELECT COUNT(*) FROM evenements WHERE nom = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nom);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;  
                }
            }
        }
        return false;
    }

    public void addEvenement(Evenement evenement) throws SQLException {
        if (evenementExiste(evenement.getNom())) {
            System.out.println("Cet événement existe déjà.");
            return;
        }

        String query = "INSERT INTO evenements (nom, date, description, utilisateur_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, evenement.getNom());
            statement.setDate(2, Date.valueOf(evenement.getDate()));  
            statement.setString(3, evenement.getDescription());
            statement.setInt(4, evenement.getUtilisateurId());
            statement.executeUpdate();
            System.out.println("Événement ajouté avec succès!");
        }
    }

    public List<Evenement> getAllEvenements() throws SQLException {
        String query = "SELECT * FROM evenements";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<Evenement> evenements = new ArrayList<>();
            while (resultSet.next()) {
                Evenement evenement = new Evenement(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getDate("date").toString(),
                    resultSet.getString("description"),
                    resultSet.getInt("utilisateur_id")
                );
                evenements.add(evenement);
            }
            return evenements;
        }
    }
}
