import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {
    private Connection connection;

    public UtilisateurDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean utilisateurExiste(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM utilisateurs WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;  // Retourne true si l'utilisateur existe
                }
            }
        }
        return false;
    }

    public void addUtilisateur(Utilisateur utilisateur) throws SQLException {
        String query = "INSERT INTO utilisateurs (nom, prenom, email, type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, utilisateur.getNom());
            statement.setString(2, utilisateur.getPrenom());
            statement.setString(3, utilisateur.getEmail());
            statement.setString(4, utilisateur.getType());
            statement.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès!");
        }
    }

    public List<Utilisateur> getAllUtilisateurs() throws SQLException {
        String query = "SELECT * FROM utilisateurs";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            List<Utilisateur> utilisateurs = new ArrayList<>();
            while (resultSet.next()) {
                Utilisateur utilisateur = new Utilisateur(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("type")
                );
                utilisateurs.add(utilisateur);
            }
            return utilisateurs;
        }
    }
}
