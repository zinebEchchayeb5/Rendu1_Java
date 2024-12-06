import java.sql.*;
import java.util.*;

public class TerrainDAO {
    private Connection connection;

    public TerrainDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTerrain(Terrain terrain) throws SQLException {
        String query = "INSERT INTO terrains (nom) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, terrain.getNom());
            stmt.executeUpdate();
        }
    }

    public List<Terrain> getAllTerrains() throws SQLException {
        List<Terrain> terrains = new ArrayList<>();
        String query = "SELECT * FROM terrains";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Terrain terrain = new Terrain(
                    rs.getInt("id"),
                    rs.getString("nom")
                );
                terrains.add(terrain);
            }
        }
        return terrains;
    }
}
