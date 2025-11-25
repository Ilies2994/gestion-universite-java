package com.universite;

import com.universite.model.*;
import java.time.LocalDate;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║  SYSTÈME DE GESTION UNIVERSITAIRE - DÉMONSTRATION     ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        // Création de l'université
        Universite universite = new Universite("Université Djilali Liabes", "Sidi Bel Abbes", "Algérie");
        universite.afficherInfos();

        // CRÉATION DES DÉPARTEMENTS
        System.out.println("\n--- Création des départements ---");
        
        Departement deptInfo = new Departement("INFO", "Informatique", 
            "Département d'Informatique et Technologies");
        
        Departement deptMath = new Departement("MATH", "Mathématiques", 
            "Département de Mathématiques et Applications");
        
        Departement deptPhysique = new Departement("PHYS", "Physique", 
            "Département de Physique");

        universite.ajouterDepartement(deptInfo);
        universite.ajouterDepartement(deptMath);
        universite.ajouterDepartement(deptPhysique);

        // CRÉATION DES PROFESSEURS
        System.out.println("\n--- Recrutement des professeurs ---");
        
        // Professeurs d'Informatique
        Adresse adr1 = new Adresse("12 Rue des Sciences", "Sidi Bel Abbes", "22000", "Algérie");
        Professeur profInfo1 = new Professeur("P001", "Benali", "Ahmed", 
            LocalDate.of(1975, 3, 15), "a.benali@univ.dz", "0555123456", adr1,
            "PROF001", "Professeur", "POO", deptInfo, 80000.0);

        Adresse adr2 = new Adresse("25 Avenue de l'Université", "Sidi Bel Abbes", "22000", "Algérie");
        Professeur profInfo2 = new Professeur("P002", "Kaddour", "Fatima", 
            LocalDate.of(1980, 7, 22), "f.kaddour@univ.dz", "0555234567", adr2,
            "PROF002", "Maître de Conférences", "Base de Données", deptInfo, 65000.0);

        Adresse adr3 = new Adresse("8 Rue Al Imane", "Sidi Bel Abbes", "22000", "Algérie");
        Professeur profInfo3 = new Professeur("P003", "Messaoudi", "Karim", 
            LocalDate.of(1978, 11, 5), "k.messaoudi@univ.dz", "0555345678", adr3,
            "PROF003", "Maître Assistant", "Réseaux", deptInfo, 60000.0);

        // Professeurs de Mathématiques
        Adresse adr4 = new Adresse("33 Boulevard Zirout Youcef", "Sidi Bel Abbes", "22000", "Algérie");
        Professeur profMath1 = new Professeur("P004", "Hadj", "Youcef", 
            LocalDate.of(1970, 9, 12), "y.hadj@univ.dz", "0555567890", adr4,
            "PROF004", "Professeur", "Analyse", deptMath, 85000.0);

        Adresse adr5 = new Adresse("18 Rue Larbi Ben M'hidi", "Sidi Bel Abbes", "22000", "Algérie");
        Professeur profMath2 = new Professeur("P005", "Bouazza", "Nadia", 
            LocalDate.of(1977, 6, 25), "n.bouazza@univ.dz", "0555678901", adr5,
            "PROF005", "Maître de Conférences", "Algèbre", deptMath, 70000.0);

        // Professeur de Physique
        Adresse adr6 = new Adresse("52 Hai Boudghene", "Sidi Bel Abbes", "22000", "Algérie");
        Professeur profPhys1 = new Professeur("P006", "Ziani", "Rachid", 
            LocalDate.of(1973, 12, 30), "r.ziani@univ.dz", "0555890123", adr6,
            "PROF006", "Professeur", "Mécanique Quantique", deptPhysique, 82000.0);

        // Recrutement
        universite.recruterProfesseur(profInfo1);
        universite.recruterProfesseur(profInfo2);
        universite.recruterProfesseur(profInfo3);
        universite.recruterProfesseur(profMath1);
        universite.recruterProfesseur(profMath2);
        universite.recruterProfesseur(profPhys1);

        // Ajouter aux départements
        deptInfo.ajouterProfesseur(profInfo1);
        deptInfo.ajouterProfesseur(profInfo2);
        deptInfo.ajouterProfesseur(profInfo3);
        deptInfo.setChef(profInfo1);

        deptMath.ajouterProfesseur(profMath1);
        deptMath.ajouterProfesseur(profMath2);
        deptMath.setChef(profMath1);

        deptPhysique.ajouterProfesseur(profPhys1);
        deptPhysique.setChef(profPhys1);

        // CRÉATION DES COURS 
        System.out.println("\n--- Création des cours ---");
        
        // Cours Informatique
        Cours coursInfoL3_POO = new Cours("INFO301", "Programmation Orientée Objet", 
            "Concepts avancés de la POO en Java", 60, 6, "Licence", 3, deptInfo, 40);
        
        Cours coursInfoL3_BD = new Cours("INFO302", "Base de Données", 
            "Conception de BD relationnelles", 45, 5, "Licence", 3, deptInfo, 40);
        
        Cours coursInfoL3_Reseaux = new Cours("INFO303", "Réseaux Informatiques", 
            "Architecture et protocoles", 50, 5, "Licence", 3, deptInfo, 35);
        
        Cours coursInfoM1_IA = new Cours("INFO401", "Intelligence Artificielle", 
            "Machine Learning et IA", 70, 8, "Master", 1, deptInfo, 25);

        // Cours Mathématiques
        Cours coursMathL2 = new Cours("MATH201", "Algèbre Linéaire", 
            "Espaces vectoriels", 55, 6, "Licence", 2, deptMath, 50);
        
        Cours coursMathL3 = new Cours("MATH301", "Analyse III", 
            "Intégrales et séries", 60, 7, "Licence", 3, deptMath, 45);
        
        Cours coursMathM1 = new Cours("MATH401", "Topologie", 
            "Espaces topologiques", 65, 8, "Master", 1, deptMath, 20);

        // Cours Physique
        Cours coursPhysL3 = new Cours("PHYS301", "Mécanique Quantique", 
            "Introduction à la physique quantique", 60, 7, "Licence", 3, deptPhysique, 30);
        
        Cours coursPhysM2 = new Cours("PHYS501", "Physique des Particules", 
            "Physique subatomique", 70, 8, "Master", 2, deptPhysique, 15);

        // Créer tous les cours
        universite.creerCours(coursInfoL3_POO);
        universite.creerCours(coursInfoL3_BD);
        universite.creerCours(coursInfoL3_Reseaux);
        universite.creerCours(coursInfoM1_IA);
        universite.creerCours(coursMathL2);
        universite.creerCours(coursMathL3);
        universite.creerCours(coursMathM1);
        universite.creerCours(coursPhysL3);
        universite.creerCours(coursPhysM2);

        // Ajouter aux départements
        deptInfo.ajouterCours(coursInfoL3_POO);
        deptInfo.ajouterCours(coursInfoL3_BD);
        deptInfo.ajouterCours(coursInfoL3_Reseaux);
        deptInfo.ajouterCours(coursInfoM1_IA);

        deptMath.ajouterCours(coursMathL2);
        deptMath.ajouterCours(coursMathL3);
        deptMath.ajouterCours(coursMathM1);

        deptPhysique.ajouterCours(coursPhysL3);
        deptPhysique.ajouterCours(coursPhysM2);

        // Assigner les professeurs
        profInfo1.assignerCours(coursInfoL3_POO);
        profInfo2.assignerCours(coursInfoL3_BD);
        profInfo3.assignerCours(coursInfoL3_Reseaux);
        profInfo1.assignerCours(coursInfoM1_IA);

        profMath1.assignerCours(coursMathL3);
        profMath1.assignerCours(coursMathM1);
        profMath2.assignerCours(coursMathL2);

        profPhys1.assignerCours(coursPhysL3);
        profPhys1.assignerCours(coursPhysM2);

        //INSCRIPTION
        System.out.println("\n--- Inscription des étudiants ---");
        
        //ÉTUDIANTS INFORMATIQUE
        
        // Licence 3 Informatique
        Adresse adrEtud1 = new Adresse("Cité Universitaire", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudInfoL3_1 = new Etudiant("E001", "Bouziane", "Yasmine", 
            LocalDate.of(2002, 5, 12), "y.bouziane@etu.univ.dz", "0666123456", adrEtud1,
            "20220001", "Licence", 3, deptInfo);

        Adresse adrEtud2 = new Adresse("Résidence Les Palmiers", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudInfoL3_2 = new Etudiant("E002", "Cherifi", "Mohammed", 
            LocalDate.of(2001, 9, 8), "m.cherifi@etu.univ.dz", "0666234567", adrEtud2,
            "20220002", "Licence", 3, deptInfo);

        Adresse adrEtud3 = new Adresse("Hai Sidi Said", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudInfoL3_3 = new Etudiant("E003", "Hadj", "Amina", 
            LocalDate.of(2002, 1, 20), "a.hadj@etu.univ.dz", "0666345678", adrEtud3,
            "20220003", "Licence", 3, deptInfo);

        Adresse adrEtud4 = new Adresse("Boulevard de la Liberté", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudInfoL3_4 = new Etudiant("E004", "Taleb", "Omar", 
            LocalDate.of(2002, 3, 30), "o.taleb@etu.univ.dz", "0666456789", adrEtud4,
            "20220004", "Licence", 3, deptInfo);

        // Master 1 Informatique
        Adresse adrEtud5 = new Adresse("Quartier Kiffane", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudInfoM1_1 = new Etudiant("E005", "Benamara", "Sarah", 
            LocalDate.of(2001, 12, 15), "s.benamara@etu.univ.dz", "0666567890", adrEtud5,
            "20210005", "Master", 1, deptInfo);

        Adresse adrEtud6 = new Adresse("Cité Pasteur", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudInfoM1_2 = new Etudiant("E006", "Meziane", "Karim", 
            LocalDate.of(2000, 7, 22), "k.meziane@etu.univ.dz", "0666678901", adrEtud6,
            "20210006", "Master", 1, deptInfo);

        // ===== ÉTUDIANTS MATHÉMATIQUES =====
        
        // Licence 2 Maths
        Adresse adrEtud7 = new Adresse("Avenue Benbadis", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudMathL2_1 = new Etudiant("E007", "Bekkai", "Fatima", 
            LocalDate.of(2003, 8, 17), "f.bekkai@etu.univ.dz", "0666789012", adrEtud7,
            "20230007", "Licence", 2, deptMath);

        // Licence 3 Maths
        Adresse adrEtud8 = new Adresse("Hai El Djorf", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudMathL3_1 = new Etudiant("E008", "Ouali", "Amine", 
            LocalDate.of(2002, 9, 25), "a.ouali@etu.univ.dz", "0666890123", adrEtud8,
            "20220008", "Licence", 3, deptMath);

        Adresse adrEtud9 = new Adresse("Cité Lala Setti", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudMathL3_2 = new Etudiant("E009", "Belhadj", "Nassima", 
            LocalDate.of(2002, 5, 11), "n.belhadj@etu.univ.dz", "0666901234", adrEtud9,
            "20220009", "Licence", 3, deptMath);

        // Master 1 Maths
        Adresse adrEtud10 = new Adresse("Boulevard Zirout Youcef", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudMathM1_1 = new Etudiant("E010", "Bensalem", "Meriem", 
            LocalDate.of(2001, 12, 7), "m.bensalem@etu.univ.dz", "0666012345", adrEtud10,
            "20210010", "Master", 1, deptMath);

        // ===== ÉTUDIANTS PHYSIQUE =====
        
        // Licence 3 Physique
        Adresse adrEtud11 = new Adresse("Hai Birouana", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudPhysL3_1 = new Etudiant("E011", "Ghomari", "Bilal", 
            LocalDate.of(2002, 4, 19), "b.ghomari@etu.univ.dz", "0666123456", adrEtud11,
            "20220011", "Licence", 3, deptPhysique);

        // Master 2 Physique
        Adresse adrEtud12 = new Adresse("Résidence Bel Horizon", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudPhysM2_1 = new Etudiant("E012", "Fellah", "Sofiane", 
            LocalDate.of(2000, 3, 21), "s.fellah@etu.univ.dz", "0666234567", adrEtud12,
            "20200012", "Master", 2, deptPhysique);

        // Doctorant Physique
        Adresse adrEtud13 = new Adresse("Cité des Professeurs", "Sidi Bel Abbes", "22000", "Algérie");
        Etudiant etudPhysD1 = new Etudiant("E013", "Bencherif", "Khaled", 
            LocalDate.of(1998, 11, 8), "k.bencherif@etu.univ.dz", "0666345678", adrEtud13,
            "20180013", "Doctorat", 1, deptPhysique);

        // Inscription
        universite.inscrireEtudiant(etudInfoL3_1);
        universite.inscrireEtudiant(etudInfoL3_2);
        universite.inscrireEtudiant(etudInfoL3_3);
        universite.inscrireEtudiant(etudInfoL3_4);
        universite.inscrireEtudiant(etudInfoM1_1);
        universite.inscrireEtudiant(etudInfoM1_2);
        universite.inscrireEtudiant(etudMathL2_1);
        universite.inscrireEtudiant(etudMathL3_1);
        universite.inscrireEtudiant(etudMathL3_2);
        universite.inscrireEtudiant(etudMathM1_1);
        universite.inscrireEtudiant(etudPhysL3_1);
        universite.inscrireEtudiant(etudPhysM2_1);
        universite.inscrireEtudiant(etudPhysD1);

        // Ajouter aux départements
        deptInfo.ajouterEtudiant(etudInfoL3_1);
        deptInfo.ajouterEtudiant(etudInfoL3_2);
        deptInfo.ajouterEtudiant(etudInfoL3_3);
        deptInfo.ajouterEtudiant(etudInfoL3_4);
        deptInfo.ajouterEtudiant(etudInfoM1_1);
        deptInfo.ajouterEtudiant(etudInfoM1_2);

        deptMath.ajouterEtudiant(etudMathL2_1);
        deptMath.ajouterEtudiant(etudMathL3_1);
        deptMath.ajouterEtudiant(etudMathL3_2);
        deptMath.ajouterEtudiant(etudMathM1_1);

        deptPhysique.ajouterEtudiant(etudPhysL3_1);
        deptPhysique.ajouterEtudiant(etudPhysM2_1);
        deptPhysique.ajouterEtudiant(etudPhysD1);

        //INSCRIPTION AUX COURS
        System.out.println("\n--- Inscription des étudiants aux cours ---");
        
        // Étudiants Informatique L3
        etudInfoL3_1.inscrireCours(coursInfoL3_POO);
        etudInfoL3_1.inscrireCours(coursInfoL3_BD);
        etudInfoL3_1.inscrireCours(coursInfoL3_Reseaux);

        etudInfoL3_2.inscrireCours(coursInfoL3_POO);
        etudInfoL3_2.inscrireCours(coursInfoL3_BD);
        etudInfoL3_2.inscrireCours(coursInfoL3_Reseaux);

        etudInfoL3_3.inscrireCours(coursInfoL3_POO);
        etudInfoL3_3.inscrireCours(coursInfoL3_BD);

        etudInfoL3_4.inscrireCours(coursInfoL3_POO);
        etudInfoL3_4.inscrireCours(coursInfoL3_Reseaux);

        // Étudiants Informatique M1
        etudInfoM1_1.inscrireCours(coursInfoM1_IA);
        etudInfoM1_2.inscrireCours(coursInfoM1_IA);

        // Étudiants Maths
        etudMathL2_1.inscrireCours(coursMathL2);
        etudMathL3_1.inscrireCours(coursMathL3);
        etudMathL3_2.inscrireCours(coursMathL3);
        etudMathM1_1.inscrireCours(coursMathM1);

        // Étudiants Physique
        etudPhysL3_1.inscrireCours(coursPhysL3);
        etudPhysM2_1.inscrireCours(coursPhysM2);

        // ========== ATTRIBUTION DES NOTES ==========
        System.out.println("\n--- Attribution des notes ---");
        
        // Notes Informatique L3
        profInfo1.attribuerNote(etudInfoL3_1, coursInfoL3_POO, 17.5, 3, "Examen");
        profInfo1.attribuerNote(etudInfoL3_1, coursInfoL3_POO, 16.0, 2, "TP");
        profInfo2.attribuerNote(etudInfoL3_1, coursInfoL3_BD, 18.0, 3, "Examen");
        profInfo2.attribuerNote(etudInfoL3_1, coursInfoL3_BD, 17.0, 2, "TP");
        profInfo3.attribuerNote(etudInfoL3_1, coursInfoL3_Reseaux, 16.5, 3, "Examen");

        profInfo1.attribuerNote(etudInfoL3_2, coursInfoL3_POO, 15.0, 3, "Examen");
        profInfo1.attribuerNote(etudInfoL3_2, coursInfoL3_POO, 14.5, 2, "TP");
        profInfo2.attribuerNote(etudInfoL3_2, coursInfoL3_BD, 14.0, 3, "Examen");
        profInfo3.attribuerNote(etudInfoL3_2, coursInfoL3_Reseaux, 13.5, 3, "Examen");

        profInfo1.attribuerNote(etudInfoL3_3, coursInfoL3_POO, 12.5, 3, "Examen");
        profInfo2.attribuerNote(etudInfoL3_3, coursInfoL3_BD, 11.5, 3, "Examen");

        profInfo1.attribuerNote(etudInfoL3_4, coursInfoL3_POO, 9.5, 3, "Examen");
        profInfo3.attribuerNote(etudInfoL3_4, coursInfoL3_Reseaux, 10.5, 3, "Examen");

        // Notes Informatique M1
        profInfo1.attribuerNote(etudInfoM1_1, coursInfoM1_IA, 16.5, 4, "Examen");
        profInfo1.attribuerNote(etudInfoM1_1, coursInfoM1_IA, 15.0, 3, "Projet");
        profInfo1.attribuerNote(etudInfoM1_2, coursInfoM1_IA, 14.0, 4, "Examen");

        // Notes Maths
        profMath2.attribuerNote(etudMathL2_1, coursMathL2, 13.5, 3, "Examen");
        profMath1.attribuerNote(etudMathL3_1, coursMathL3, 15.5, 3, "Examen");
        profMath1.attribuerNote(etudMathL3_2, coursMathL3, 14.0, 3, "Examen");
        profMath1.attribuerNote(etudMathM1_1, coursMathM1, 17.0, 4, "Examen");

        // Notes Physique
        profPhys1.attribuerNote(etudPhysL3_1, coursPhysL3, 16.0, 3, "Examen");
        profPhys1.attribuerNote(etudPhysM2_1, coursPhysM2, 18.5, 4, "Examen");

        // ========== AFFICHAGE DES RÉSULTATS ==========
        System.out.println("\n\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║              RÉSULTATS ET STATISTIQUES                ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");

        // Statistiques par département
        deptInfo.afficherInfos();
        deptMath.afficherInfos();
        deptPhysique.afficherInfos();

        // Relevés de notes
        etudInfoL3_1.afficherReleveNotes();
        etudInfoM1_1.afficherReleveNotes();
        etudMathM1_1.afficherReleveNotes();
        etudPhysM2_1.afficherReleveNotes();

        // Statistiques des cours
        coursInfoL3_POO.afficherStatistiques();
        coursMathL3.afficherStatistiques();

        // Statistiques globales
        universite.afficherStatistiques();
        universite.afficherClassement(10);

        // Génération du rapport complet
        universite.genererRapport();

        System.out.println("\n╔═══════════════════════════════════════════════════════╗");
        System.out.println("║            FIN DE LA DÉMONSTRATION                    ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
    }

}


