package com.universite.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe principale représentant l'université
 */
public class Universite {
    private String nom;
    private String ville;
    private String pays;
    private List<Departement> departements;
    private List<Etudiant> etudiants;
    private List<Professeur> professeurs;
    private List<Cours> cours;

    public Universite(String nom, String ville, String pays) {
        this.nom = nom;
        this.ville = ville;
        this.pays = pays;
        this.departements = new ArrayList<>();
        this.etudiants = new ArrayList<>();
        this.professeurs = new ArrayList<>();
        this.cours = new ArrayList<>();
    }

    // ========== GESTION DES DÉPARTEMENTS ==========

    /**
     * Ajouter un département
     */
    public void ajouterDepartement(Departement dept) {
        if (!departements.contains(dept)) {
            departements.add(dept);
            System.out.println("Département " + dept.getNom() + " ajouté à l'université.");
        }
    }

    /**
     * Rechercher un département par code
     */
    public Departement rechercherDepartement(String code) {
        return departements.stream()
                          .filter(d -> d.getCode().equals(code))
                          .findFirst()
                          .orElse(null);
    }

    // ========== GESTION DES ÉTUDIANTS ==========

    /**
     * Inscrire un étudiant
     */
    public void inscrireEtudiant(Etudiant etudiant) {
        if (!etudiants.contains(etudiant)) {
            etudiants.add(etudiant);
            System.out.println("Étudiant " + etudiant.getNomComplet() 
                             + " inscrit avec succès (N°" + etudiant.getNumeroEtudiant() + ")");
        }
    }

    /**
     * Rechercher un étudiant par numéro
     */
    public Etudiant rechercherEtudiant(String numeroEtudiant) {
        return etudiants.stream()
                       .filter(e -> e.getNumeroEtudiant().equals(numeroEtudiant))
                       .findFirst()
                       .orElse(null);
    }

    /**
     * Rechercher des étudiants par nom
     */
    public List<Etudiant> rechercherEtudiantsParNom(String nom) {
        return etudiants.stream()
                       .filter(e -> e.getNom().toLowerCase().contains(nom.toLowerCase()) ||
                                   e.getPrenom().toLowerCase().contains(nom.toLowerCase()))
                       .collect(Collectors.toList());
    }

    // ========== GESTION DES PROFESSEURS ==========

    /**
     * Recruter un professeur
     */
    public void recruterProfesseur(Professeur professeur) {
        if (!professeurs.contains(professeur)) {
            professeurs.add(professeur);
            System.out.println("Professeur " + professeur.getNomComplet() 
                             + " recruté avec succès (Matricule: " + professeur.getMatricule() + ")");
        }
    }

    /**
     * Rechercher un professeur par matricule
     */
    public Professeur rechercherProfesseur(String matricule) {
        return professeurs.stream()
                         .filter(p -> p.getMatricule().equals(matricule))
                         .findFirst()
                         .orElse(null);
    }

    // ========== GESTION DES COURS ==========

    /**
     * Créer un cours
     */
    public void creerCours(Cours nouveauCours) {
        if (!cours.contains(nouveauCours)) {
            cours.add(nouveauCours);
            System.out.println("Cours " + nouveauCours.getNom() + " créé avec succès.");
        }
    }

    /**
     * Rechercher un cours par code
     */
    public Cours rechercherCours(String code) {
        return cours.stream()
                   .filter(c -> c.getCode().equals(code))
                   .findFirst()
                   .orElse(null);
    }

    /**
     * Rechercher des cours par niveau
     */
    public List<Cours> rechercherCoursParNiveau(String niveau, int annee) {
        return cours.stream()
                   .filter(c -> c.getNiveau().equals(niveau) && c.getAnnee() == annee)
                   .collect(Collectors.toList());
    }

    // ========== AFFICHAGE ET STATISTIQUES ==========

    /**
     * Afficher les informations de l'université
     */
    public void afficherInfos() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║        UNIVERSITÉ " + nom.toUpperCase() + "        ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Localisation: " + ville + ", " + pays);
        System.out.println("Départements: " + departements.size());
        System.out.println("Étudiants: " + etudiants.size());
        System.out.println("Professeurs: " + professeurs.size());
        System.out.println("Cours: " + cours.size());
    }

    /**
     * Afficher les statistiques globales
     */
    public void afficherStatistiques() {
        System.out.println("\n=== STATISTIQUES GLOBALES ===");
        
        // Statistiques étudiants
        System.out.println("\n--- Étudiants ---");
        long licence = etudiants.stream().filter(e -> e.getNiveau().equals("Licence")).count();
        long master = etudiants.stream().filter(e -> e.getNiveau().equals("Master")).count();
        long doctorat = etudiants.stream().filter(e -> e.getNiveau().equals("Doctorat")).count();
        
        System.out.println("Total: " + etudiants.size());
        System.out.println("  - Licence: " + licence);
        System.out.println("  - Master: " + master);
        System.out.println("  - Doctorat: " + doctorat);

        // Moyenne générale
        if (!etudiants.isEmpty()) {
            double moyenneGenerale = etudiants.stream()
                                              .mapToDouble(Etudiant::getMoyenne)
                                              .average()
                                              .orElse(0.0);
            System.out.println("Moyenne générale: " + String.format("%.2f", moyenneGenerale));
        }

        // Statistiques professeurs
        System.out.println("\n--- Professeurs ---");
        System.out.println("Total: " + professeurs.size());
        
        // Statistiques cours
        System.out.println("\n--- Cours ---");
        System.out.println("Total: " + cours.size());
        long coursComplets = cours.stream().filter(Cours::estComplet).count();
        System.out.println("Cours complets: " + coursComplets);

        // Par département
        System.out.println("\n--- Départements ---");
        for (Departement dept : departements) {
            System.out.println(dept.getNom() + ": " + dept.getEtudiants().size() 
                             + " étudiants, " + dept.getProfesseurs().size() + " professeurs");
        }
    }

    /**
     * Afficher le classement des meilleurs étudiants
     */
    public void afficherClassement(int top) {
        System.out.println("\n=== TOP " + top + " DES MEILLEURS ÉTUDIANTS ===");
        
        List<Etudiant> classement = etudiants.stream()
                                             .sorted((e1, e2) -> Double.compare(e2.getMoyenne(), e1.getMoyenne()))
                                             .limit(top)
                                             .collect(Collectors.toList());

        for (int i = 0; i < classement.size(); i++) {
            Etudiant e = classement.get(i);
            System.out.println((i + 1) + ". " + e.getNomComplet() 
                             + " (" + e.getNumeroEtudiant() + ") - Moyenne: " 
                             + String.format("%.2f", e.getMoyenne()));
        }
    }

    /**
     * Générer un rapport complet
     */
    public void genererRapport() {
        System.out.println("\n");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("          RAPPORT COMPLET - " + nom.toUpperCase());
        System.out.println("═══════════════════════════════════════════════════");
        
        afficherInfos();
        afficherStatistiques();
        
        System.out.println("\n--- Détail des départements ---");
        for (Departement dept : departements) {
            dept.afficherInfos();
        }

        afficherClassement(10);
        
        System.out.println("\n═══════════════════════════════════════════════════");
    }

    // Getters
    public String getNom() { return nom; }
    public String getVille() { return ville; }
    public String getPays() { return pays; }
    public List<Departement> getDepartements() { return new ArrayList<>(departements); }
    public List<Etudiant> getEtudiants() { return new ArrayList<>(etudiants); }
    public List<Professeur> getProfesseurs() { return new ArrayList<>(professeurs); }
    public List<Cours> getCours() { return new ArrayList<>(cours); }

    @Override
    public String toString() {
        return "Universite{" +
                "nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                ", departements=" + departements.size() +
                ", etudiants=" + etudiants.size() +
                ", professeurs=" + professeurs.size() +
                '}';
    }
}