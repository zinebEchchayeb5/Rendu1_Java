public class Evenement {
    private int id;
    private String nom;
    private String date;  
    private String description;
    private int utilisateurId;

    public Evenement(String nom, String date, String description, int utilisateurId) {
        this.nom = nom;
        this.date = date;
        this.description = description;
        this.utilisateurId = utilisateurId;
    }

    public Evenement(int id, String nom, String date, String description, int utilisateurId) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.description = description;
        this.utilisateurId = utilisateurId;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    @Override
    public String toString() {
        return nom + " - " + description;
    }
}
