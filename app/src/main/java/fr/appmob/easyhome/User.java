package fr.appmob.easyhome;

public class User {
    private String nom, prenom, email;
    private final String userId;

    public User(String nom, String prenom, String email, String userId) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.userId = userId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
}
