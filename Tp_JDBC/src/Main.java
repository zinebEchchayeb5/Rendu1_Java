import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/gestion_evenements";
            String username = "root";
            String password = "Zineb@2005";
            Connection conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connexion à la base de données réussie!");

                Statement stmt = conn.createStatement();

                String insertUserSQL = "INSERT INTO utilisateurs (nom, prenom, email, type) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertUserSQL);
                pstmt.setString(1, "Dupont");
                pstmt.setString(2, "Jean");
                pstmt.setString(3, "jean.dupont@example.com");
                pstmt.setString(4, "ETUDIANT");

                pstmt.executeUpdate();
                System.out.println("Utilisateur ajouté avec succès!");

                String selectSQL = "SELECT * FROM utilisateurs";
                ResultSet rs = stmt.executeQuery(selectSQL);

                System.out.println("Liste des utilisateurs :");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + ", Nom: " + rs.getString("nom") + ", Prénom: " + rs.getString("prenom"));
                }

                String eventSQL = "SELECT * FROM evenements";
                ResultSet rsEvents = stmt.executeQuery(eventSQL);

                System.out.println("Liste des événements :");
                while (rsEvents.next()) {
                    System.out.println("ID: " + rsEvents.getInt("id") + ", Nom: " + rsEvents.getString("nom") + ", Date: " + rsEvents.getDate("date"));
                }

                rs.close();
                rsEvents.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
