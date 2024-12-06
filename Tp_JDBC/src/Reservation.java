import java.sql.Date;

public class Reservation {
    private int id;
    private int utilisateurId;
    private int salleId;
    private Date date;

    public Reservation(int id, int utilisateurId, int salleId, Date date) {
        this.id = id;
        this.utilisateurId = utilisateurId;
        this.salleId = salleId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public int getSalleId() {
        return salleId;
    }

    public void setSalleId(int salleId) {
        this.salleId = salleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
