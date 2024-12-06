import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/your_database_name";
            String username = "root";
            String password = "Zineb@2005";
            Connection conn = DriverManager.getConnection(url, username, password);

            if (conn != null) {
                System.out.println("Connected to the database!");

                Statement stmt = conn.createStatement();
                
                String createTableSQL = "CREATE TABLE IF NOT EXISTS utilisateurs ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY, "
                        + "nom VARCHAR(255) NOT NULL, "
                        + "prenom VARCHAR(255) NOT NULL, "
                        + "email VARCHAR(255) NOT NULL, "
                        + "type ENUM('ETUDIANT', 'PROFESSEUR') NOT NULL)";
                
                stmt.execute(createTableSQL);
                System.out.println("Table 'utilisateurs' created successfully!");

                String insertUserSQL = "INSERT INTO utilisateurs (nom, prenom, email, type) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertUserSQL);
                pstmt.setString(1, "Echchayeb");
                pstmt.setString(2, "Zineb");
                pstmt.setString(3, "z.ec@gmail.com");
                pstmt.setString(4, "ETUDIANT");

                pstmt.executeUpdate();
                System.out.println("User added successfully!");

                String selectSQL = "SELECT * FROM utilisateurs";
                ResultSet rs = stmt.executeQuery(selectSQL);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nom");
                    String prenom = rs.getString("prenom");
                    String email = rs.getString("email");
                    String type = rs.getString("type");

                    System.out.println("ID: " + id + ", Name: " + nom + " " + prenom + ", Email: " + email + ", Type: " + type);
                }

                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
