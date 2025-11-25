package com.universite.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un département universitaire
 */
public class Departement {
    private String code;
    private String nom;
    private String description;
    private Professeur chef;
    private List<Professeur> professeurs;
    private List<Etudiant> etudiants;
    private List<Cours> cours;

    public Departement(String code, String nom, String description) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.professeurs = new ArrayList<>();
        this.etudiants = new ArrayList<>();
        this.cours = new ArrayList<>();
    }

    /**
     * Ajouter un professeur au département
     */
    public void ajouterProfesseur(Professeur professeur) {
        if (!professeurs.contains(professeur)) {
            professeurs.add(professeur);
            professeur.setDepartement(this);
            System.out.println("Professeur " + professeur.getNomComplet() 
                             + " ajouté au département " + nom);
        }
    }

    /**
     * Retirer un professeur du département
     */
    public void retirerProfesseur(Professeur professeur) {
        if (professeurs.remove(professeur)) {
            professeur.setDepartement(null);
            System.out.println("Professeur " + professeur.getNomComplet() 
                             + " retiré du département " + nom);
        }
    }

    /**
     * Ajouter un étudiant au département
     */
    public void ajouterEtudiant(Etudiant etudiant) {
        if (!etudiants.contains(etudiant)) {
            etudiants.add(etudiant);
            etudiant.setDepartement(this);
            System.out.println("Étudiant " + etudiant.getNomComplet() 
                             + " ajouté au département " + nom);
        }
    }

    /**
     * Retirer un étudiant du département
     */
    public void retirerEtudiant(Etudiant etudiant) {
        if (etudiants.remove(etudiant)) {
            etudiant.setDepartement(null);
        }
    }

    /**
     * Ajouter un cours au département
     */
    public void ajouterCours(Cours nouveauCours) {
        if (!cours.contains(nouveauCours)) {
            cours.add(nouveauCours);
            nouveauCours.setDepartement(this);
            System.out.println("Cours " + nouveauCours.getNom() 
                             + " ajouté au département " + nom);
        }
    }

    /**
     * Retirer un cours du département
     */
    public void retirerCours(Cours coursARetirer) {
        if (cours.remove(coursARetirer)) {
            coursARetirer.setDepartement(null);
        }
    }

    /**
     * Afficher les informations du département
     */
    public void afficherInfos() {
        System.out.println("\n=== Département " + nom + " ===");
        System.out.println("Code: " + code);
        System.out.println("Description: " + description);
        System.out.println("Chef de département: " + (chef != null ? chef.getNomComplet() : "Non défini"));
        System.out.println("Nombre de professeurs: " + professeurs.size());
        System.out.println("Nombre d'étudiants: " + etudiants.size());
        System.out.println("Nombre de cours: " + cours.size());
    }

    /**
     * Afficher la liste des professeurs
     */
    public void afficherProfesseurs() {
        System.out.println("\n=== Professeurs du département " + nom + " ===");
        if (professeurs.isEmpty()) {
            System.out.println("Aucun professeur.");
            return;
        }

        for (int i = 0; i < professeurs.size(); i++) {
            Professeur p = professeurs.get(i);
            System.out.println((i + 1) + ". " + p.getMatricule() + " - " 
                             + p.getNomComplet() + " (" + p.getGrade() + ")");
        }
    }

    /**
     * Afficher la liste des étudiants
     */
    public void afficherEtudiants() {
        System.out.println("\n=== Étudiants du département " + nom + " ===");
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant.");
            return;
        }

        for (int i = 0; i < etudiants.size(); i++) {
            Etudiant e = etudiants.get(i);
            System.out.println((i + 1) + ". " + e.getNumeroEtudiant() + " - " 
                             + e.getNomComplet() + " (" + e.getNiveau() + " " + e.getAnnee() + ")");
        }
    }

    /**
     * Afficher la liste des cours
     */
    public void afficherCours() {
        System.out.println("\n=== Cours du département " + nom + " ===");
        if (cours.isEmpty()) {
            System.out.println("Aucun cours.");
            return;
        }

        for (int i = 0; i < cours.size(); i++) {
            Cours c = cours.get(i);
            System.out.println((i + 1) + ". " + c.getCode() + " - " + c.getNom() 
                             + " (" + c.getCredits() + " crédits, " 
                             + c.getEtudiants().size() + "/" + c.getCapaciteMax() + " étudiants)");
        }
    }

    /**
     * Obtenir les statistiques du département
     */
    public void afficherStatistiques() {
        System.out.println("\n=== Statistiques du département " + nom + " ===");
        System.out.println("Professeurs: " + professeurs.size());
        System.out.println("Étudiants: " + etudiants.size());
        System.out.println("Cours: " + cours.size());

        if (!etudiants.isEmpty()) {
            double moyenneGenerale = etudiants.stream()
                                              .mapToDouble(Etudiant::getMoyenne)
                                              .average()
                                              .orElse(0.0);
            System.out.println("Moyenne générale des étudiants: " 
                             + String.format("%.2f", moyenneGenerale));
        }

        // Répartition par niveau
        long licence = etudiants.stream().filter(e -> e.getNiveau().equals("Licence")).count();
        long master = etudiants.stream().filter(e -> e.getNiveau().equals("Master")).count();
        long doctorat = etudiants.stream().filter(e -> e.getNiveau().equals("Doctorat")).count();

        System.out.println("\nRépartition par niveau:");
        System.out.println("  - Licence: " + licence);
        System.out.println("  - Master: " + master);
        System.out.println("  - Doctorat: " + doctorat);
    }

    // Getters et Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Professeur getChef() { return chef; }
    public void setChef(Professeur chef) { this.chef = chef; }

    public List<Professeur> getProfesseurs() { return new ArrayList<>(professeurs); }
    
    public List<Etudiant> getEtudiants() { return new ArrayList<>(etudiants); }
    
    public List<Cours> getCours() { return new ArrayList<>(cours); }

    @Override
    public String toString() {
        return "Departement{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", professeurs=" + professeurs.size() +
                ", etudiants=" + etudiants.size() +
                ", cours=" + cours.size() +
                '}';
    }
}