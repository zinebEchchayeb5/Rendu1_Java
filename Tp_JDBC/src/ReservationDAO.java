import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
    private final Connection connection;

    public ReservationDAO(Connection connection) {
        this.connection = connection;
    }

    public void addReservation(Reservation reservation) throws SQLException {
        String sql = "INSERT INTO reservations (id, utilisateur_id, salle_id, date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reservation.getId());
            statement.setInt(2, reservation.getUtilisateurId());
            statement.setInt(3, reservation.getSalleId());
            statement.setDate(4, reservation.getDate());
            statement.executeUpdate();
        }
    }

    public boolean isSalleDisponible(int salleId, Date date) throws SQLException {
        String sql = "SELECT COUNT(*) FROM reservations WHERE salle_id = ? AND date = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, salleId);
            statement.setDate(2, date);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) == 0;
                }
            }
        }
        return false;
    }

    public List<Reservation> getAllReservations() throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                    resultSet.getInt("id"),
                    resultSet.getInt("utilisateur_id"),
                    resultSet.getInt("salle_id"),
                    resultSet.getDate("date")
                );
                reservations.add(reservation);
            }
        }
        return reservations;
    }

    public void deleteReservation(int id) throws SQLException {
        String sql = "DELETE FROM reservations WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
