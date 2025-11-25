package com.universite.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un professeur
 */
public class Professeur extends Personne {
    private String matricule;
    private String grade; // Assistant, Maître Assistant, Maître de Conférences, Professeur
    private String specialite;
    private Departement departement;
    private List<Cours> coursEnseignes;
    private double salaire;

    public Professeur(String id, String nom, String prenom, LocalDate dateNaissance,
                      String email, String telephone, Adresse adresse,
                      String matricule, String grade, String specialite, 
                      Departement departement, double salaire) {
        super(id, nom, prenom, dateNaissance, email, telephone, adresse);
        this.matricule = matricule;
        this.grade = grade;
        this.specialite = specialite;
        this.departement = departement;
        this.salaire = salaire;
        this.coursEnseignes = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "PROFESSEUR";
    }

    @Override
    public void afficherInfos() {
        System.out.println("=== Informations Professeur ===");
        System.out.println("Matricule: " + matricule);
        System.out.println("Nom complet: " + getNomComplet());
        System.out.println("Email: " + email);
        System.out.println("Grade: " + grade);
        System.out.println("Spécialité: " + specialite);
        System.out.println("Département: " + (departement != null ? departement.getNom() : "Non défini"));
        System.out.println("Nombre de cours enseignés: " + coursEnseignes.size());
    }

    /**
     * Assigner un cours au professeur
     */
    public void assignerCours(Cours cours) {
        if (!coursEnseignes.contains(cours)) {
            coursEnseignes.add(cours);
            cours.setProfesseur(this);
            System.out.println("Cours '" + cours.getNom() + "' assigné au professeur " + getNomComplet());
        } else {
            System.out.println("Ce cours est déjà assigné au professeur.");
        }
    }

    /**
     * Retirer un cours du professeur
     */
    public void retirerCours(Cours cours) {
        if (coursEnseignes.remove(cours)) {
            cours.setProfesseur(null);
            System.out.println("Cours '" + cours.getNom() + "' retiré du professeur " + getNomComplet());
        }
    }

    /**
     * Attribuer une note à un étudiant pour un cours
     */
    public void attribuerNote(Etudiant etudiant, Cours cours, double valeur, 
                             double coefficient, String type) {
        if (!coursEnseignes.contains(cours)) {
            System.out.println("Erreur: Le professeur n'enseigne pas ce cours!");
            return;
        }

        if (valeur < 0 || valeur > 20) {
            System.out.println("Erreur: La note doit être entre 0 et 20!");
            return;
        }

        etudiant.ajouterNote(cours, valeur, coefficient, type);
        System.out.println("Note de " + valeur + " attribuée à " + etudiant.getNomComplet() 
                         + " pour le cours " + cours.getNom());
    }

    /**
     * Afficher la liste des cours enseignés
     */
    public void afficherCoursEnseignes() {
        System.out.println("\n=== Cours enseignés par " + getNomComplet() + " ===");
        if (coursEnseignes.isEmpty()) {
            System.out.println("Aucun cours assigné.");
            return;
        }

        for (Cours cours : coursEnseignes) {
            System.out.println("- " + cours.getCode() + ": " + cours.getNom() 
                             + " (" + cours.getNombreHeures() + "h, " 
                             + cours.getCredits() + " crédits)");
        }
    }

    /**
     * Afficher les étudiants d'un cours
     */
    public void afficherEtudiantsCours(Cours cours) {
        if (!coursEnseignes.contains(cours)) {
            System.out.println("Erreur: Vous n'enseignez pas ce cours!");
            return;
        }

        System.out.println("\n=== Étudiants inscrits au cours " + cours.getNom() + " ===");
        List<Etudiant> etudiants = cours.getEtudiants();
        
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant inscrit.");
            return;
        }

        for (int i = 0; i < etudiants.size(); i++) {
            Etudiant e = etudiants.get(i);
            System.out.println((i + 1) + ". " + e.getNumeroEtudiant() + " - " 
                             + e.getNomComplet() + " (" + e.getNiveau() + " " + e.getAnnee() + ")");
        }
    }

    // Getters et Setters
    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getSpecialite() { return specialite; }
    public void setSpecialite(String specialite) { this.specialite = specialite; }

    public Departement getDepartement() { return departement; }
    public void setDepartement(Departement departement) { 
        this.departement = departement; 
    }

    public List<Cours> getCoursEnseignes() { return new ArrayList<>(coursEnseignes); }

    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }

    @Override
    public String toString() {
        return "Professeur{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + getNomComplet() + '\'' +
                ", grade='" + grade + '\'' +
                ", specialite='" + specialite + '\'' +
                ", nbCours=" + coursEnseignes.size() +
                '}';
    }
}