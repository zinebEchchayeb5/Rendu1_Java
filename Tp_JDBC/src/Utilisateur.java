public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String type;

    // Constructeur avec ID
    public Utilisateur(int id, String nom, String prenom, String email, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.type = type;
    }

    // Constructeur sans ID (pour les nouveaux utilisateurs)
    public Utilisateur(String nom, String prenom, String email, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Utilisateur{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "', email='" + email + "', type='" + type + "'}";
    }
}
