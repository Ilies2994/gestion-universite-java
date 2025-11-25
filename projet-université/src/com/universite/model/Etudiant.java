package com.universite.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un étudiant
 */
public class Etudiant extends Personne {
    private String numeroEtudiant;
    private String niveau; // Licence, Master, Doctorat
    private int annee; // 1, 2, 3, etc.
    private Departement departement;
    private List<Inscription> inscriptions;
    private List<Note> notes;
    private double moyenne;

    public Etudiant(String id, String nom, String prenom, LocalDate dateNaissance,
                    String email, String telephone, Adresse adresse,
                    String numeroEtudiant, String niveau, int annee, Departement departement) {
        super(id, nom, prenom, dateNaissance, email, telephone, adresse);
        this.numeroEtudiant = numeroEtudiant;
        this.niveau = niveau;
        this.annee = annee;
        this.departement = departement;
        this.inscriptions = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.moyenne = 0.0;
    }

    @Override
    public String getRole() {
        return "ETUDIANT";
    }

    @Override
    public void afficherInfos() {
        System.out.println("=== Informations Étudiant ===");
        System.out.println("Numéro: " + numeroEtudiant);
        System.out.println("Nom complet: " + getNomComplet());
        System.out.println("Email: " + email);
        System.out.println("Niveau: " + niveau + " - Année " + annee);
        System.out.println("Département: " + (departement != null ? departement.getNom() : "Non défini"));
        System.out.println("Moyenne générale: " + String.format("%.2f", moyenne));
        System.out.println("Nombre de cours inscrits: " + inscriptions.size());
    }

    /**
     * Inscrire l'étudiant à un cours
     */
    public boolean inscrireCours(Cours cours) {
        // Vérifier si déjà inscrit
        for (Inscription insc : inscriptions) {
            if (insc.getCours().equals(cours)) {
                System.out.println("Déjà inscrit à ce cours!");
                return false;
            }
        }
        
        Inscription inscription = new Inscription(this, cours, LocalDate.now());
        inscriptions.add(inscription);
        cours.ajouterEtudiant(this);
        System.out.println("Inscription réussie au cours: " + cours.getNom());
        return true;
    }

    /**
     * Ajouter une note pour un cours
     */
    public void ajouterNote(Cours cours, double valeur, double coefficient, String type) {
        Note note = new Note(cours, this, valeur, coefficient, type, LocalDate.now());
        notes.add(note);
        calculerMoyenne();
    }

    /**
     * Calculer la moyenne générale de l'étudiant
     */
    public void calculerMoyenne() {
        if (notes.isEmpty()) {
            moyenne = 0.0;
            return;
        }

        double sommeNotesPonderees = 0.0;
        double sommeCoefficients = 0.0;

        for (Note note : notes) {
            sommeNotesPonderees += note.getValeur() * note.getCoefficient();
            sommeCoefficients += note.getCoefficient();
        }

        moyenne = sommeCoefficients > 0 ? sommeNotesPonderees / sommeCoefficients : 0.0;
    }

    /**
     * Obtenir le relevé de notes
     */
    public void afficherReleveNotes() {
        System.out.println("\n=== Relevé de Notes - " + getNomComplet() + " ===");
        if (notes.isEmpty()) {
            System.out.println("Aucune note enregistrée.");
            return;
        }

        for (Note note : notes) {
            System.out.println(note);
        }
        System.out.println("\nMoyenne générale: " + String.format("%.2f", moyenne) + "/20");
    }

    // Getters et Setters
    public String getNumeroEtudiant() { return numeroEtudiant; }
    public void setNumeroEtudiant(String numeroEtudiant) { 
        this.numeroEtudiant = numeroEtudiant; 
    }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }

    public int getAnnee() { return annee; }
    public void setAnnee(int annee) { this.annee = annee; }

    public Departement getDepartement() { return departement; }
    public void setDepartement(Departement departement) { 
        this.departement = departement; 
    }

    public List<Inscription> getInscriptions() { return new ArrayList<>(inscriptions); }
    
    public List<Note> getNotes() { return new ArrayList<>(notes); }

    public double getMoyenne() { return moyenne; }

    @Override
    public String toString() {
        return "Etudiant{" +
                "numeroEtudiant='" + numeroEtudiant + '\'' +
                ", nom='" + getNomComplet() + '\'' +
                ", niveau='" + niveau + '\'' +
                ", annee=" + annee +
                ", moyenne=" + String.format("%.2f", moyenne) +
                '}';
    }
}