package com.universite.model;

import java.time.LocalDate;

public class Note {
    private Cours cours;
    private Etudiant etudiant;
    private double valeur;
    private double coefficient;
    private String type;
    private LocalDate date;
    private String commentaire;

    public Note(Cours cours, Etudiant etudiant, double valeur, 
                double coefficient, String type, LocalDate date) {
        this.cours = cours;
        this.etudiant = etudiant;
        this.valeur = valeur;
        this.coefficient = coefficient;
        this.type = type;
        this.date = date;
    }

    public String getMention() {
        if (valeur >= 16) return "Très Bien";
        if (valeur >= 14) return "Bien";
        if (valeur >= 12) return "Assez Bien";
        if (valeur >= 10) return "Passable";
        return "Insuffisant";
    }

    public boolean estValide() {
        return valeur >= 10;
    }

    // Getters et Setters complets...
    public Cours getCours() { return cours; }
    public void setCours(Cours cours) { this.cours = cours; }

    public Etudiant getEtudiant() { return etudiant; }
    public void setEtudiant(Etudiant etudiant) { this.etudiant = etudiant; }

    public double getValeur() { return valeur; }
    public void setValeur(double valeur) { this.valeur = valeur; }

    public double getCoefficient() { return coefficient; }
    public void setCoefficient(double coefficient) { this.coefficient = coefficient; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    @Override
    public String toString() {
        return String.format("%s - %s: %.2f/20 (coef %.1f) - %s - %s", 
                           cours.getCode(),
                           type,
                           valeur,
                           coefficient,
                           getMention(),
                           date);
    }
}