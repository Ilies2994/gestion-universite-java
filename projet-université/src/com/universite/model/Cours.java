package com.universite.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe représentant un cours
 */
public class Cours {
    private String code;
    private String nom;
    private String description;
    private int nombreHeures;
    private int credits;
    private String niveau; // Licence, Master, Doctorat
    private int annee;
    private Professeur professeur;
    private Departement departement;
    private List<Etudiant> etudiants;
    private int capaciteMax;

    public Cours(String code, String nom, String description, int nombreHeures,
                 int credits, String niveau, int annee, Departement departement, 
                 int capaciteMax) {
        this.code = code;
        this.nom = nom;
        this.description = description;
        this.nombreHeures = nombreHeures;
        this.credits = credits;
        this.niveau = niveau;
        this.annee = annee;
        this.departement = departement;
        this.capaciteMax = capaciteMax;
        this.etudiants = new ArrayList<>();
    }

    /**
     * Ajouter un étudiant au cours
     */
    public boolean ajouterEtudiant(Etudiant etudiant) {
        if (etudiants.size() >= capaciteMax) {
            System.out.println("Erreur: Le cours est complet!");
            return false;
        }

        if (etudiants.contains(etudiant)) {
            System.out.println("L'étudiant est déjà inscrit à ce cours.");
            return false;
        }

        etudiants.add(etudiant);
        return true;
    }

    /**
     * Retirer un étudiant du cours
     */
    public boolean retirerEtudiant(Etudiant etudiant) {
        return etudiants.remove(etudiant);
    }

    /**
     * Vérifier si le cours est complet
     */
    public boolean estComplet() {
        return etudiants.size() >= capaciteMax;
    }

    /**
     * Obtenir le nombre de places restantes
     */
    public int getPlacesRestantes() {
        return capaciteMax - etudiants.size();
    }

    /**
     * Afficher les informations du cours
     */
    public void afficherInfos() {
        System.out.println("\n=== Informations du Cours ===");
        System.out.println("Code: " + code);
        System.out.println("Nom: " + nom);
        System.out.println("Description: " + description);
        System.out.println("Heures: " + nombreHeures + "h");
        System.out.println("Crédits: " + credits);
        System.out.println("Niveau: " + niveau + " - Année " + annee);
        System.out.println("Professeur: " + (professeur != null ? professeur.getNomComplet() : "Non assigné"));
        System.out.println("Département: " + (departement != null ? departement.getNom() : "Non défini"));
        System.out.println("Étudiants inscrits: " + etudiants.size() + "/" + capaciteMax);
        System.out.println("Places restantes: " + getPlacesRestantes());
    }

    /**
     * Calculer la moyenne de la classe
     */
    public double calculerMoyenneClasse() {
        if (etudiants.isEmpty()) {
            return 0.0;
        }

        double somme = 0.0;
        for (Etudiant etudiant : etudiants) {
            somme += etudiant.getMoyenne();
        }

        return somme / etudiants.size();
    }

    /**
     * Afficher les statistiques du cours
     */
    public void afficherStatistiques() {
        System.out.println("\n=== Statistiques du Cours " + nom + " ===");
        System.out.println("Nombre d'étudiants: " + etudiants.size());
        
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant inscrit.");
            return;
        }

        double moyenneClasse = calculerMoyenneClasse();
        System.out.println("Moyenne de la classe: " + String.format("%.2f", moyenneClasse));

        // Trouver min et max
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        
        for (Etudiant e : etudiants) {
            double moy = e.getMoyenne();
            if (moy < min) min = moy;
            if (moy > max) max = moy;
        }

        System.out.println("Note minimale: " + String.format("%.2f", min));
        System.out.println("Note maximale: " + String.format("%.2f", max));
        
        // Taux de réussite (moyenne >= 10)
        long reussis = etudiants.stream()
                                .filter(e -> e.getMoyenne() >= 10)
                                .count();
        double tauxReussite = (reussis * 100.0) / etudiants.size();
        System.out.println("Taux de réussite: " + String.format("%.1f", tauxReussite) + "%");
    }

    // Getters et Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getNombreHeures() { return nombreHeures; }
    public void setNombreHeures(int nombreHeures) { this.nombreHeures = nombreHeures; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public Professeur getProfesseur() { return professeur; }
    public void setProfesseur(Professeur professeur) { 
        this.professeur = professeur; 
    }

    public Departement getDepartement() { return departement; }
    public void setDepartement(Departement departement) { 
        this.departement = departement; 
    }

    public List<Etudiant> getEtudiants() { return new ArrayList<>(etudiants); }

    public int getCapaciteMax() { return capaciteMax; }
    public void setCapaciteMax(int capaciteMax) { this.capaciteMax = capaciteMax; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return Objects.equals(code, cours.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Cours{" +
                "code='" + code + '\'' +
                ", nom='" + nom + '\'' +
                ", credits=" + credits +
                ", niveau='" + niveau + '\'' +
                ", etudiants=" + etudiants.size() + "/" + capaciteMax +
                '}';
    }
}