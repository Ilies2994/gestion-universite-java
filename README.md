# Système de Gestion Universitaire (Java)

Ce projet est une application console en **Java** simulant la gestion administrative et pédagogique d'une université (basé sur le modèle LMD : Licence, Master, Doctorat).

Il a été conçu pour démontrer l'application des principes de la **Programmation Orientée Objet (POO)** et l'utilisation des fonctionnalités modernes de Java.

## Fonctionnalités Principales

* **Architecture Hiérarchique** : Gestion de l'Université, des Départements, des Professeurs et des Étudiants.
* **Système LMD** : Distinction des parcours (Licence, Master, Doctorat) et des années.
* **Gestion Pédagogique** :
    * Création et assignation des cours.
    * Inscriptions pédagogiques des étudiants.
    * Attribution des notes (Examens, TP, Projets) avec coefficients.
* **Calculs Automatiques** : Calcul des moyennes pondérées et génération de relevés de notes.
* **Reporting** : Génération d'un rapport complet avec statistiques globales et classements.

## Concepts Techniques

* **Héritage & Polymorphisme** : Classe abstraite `Personne` étendue par `Etudiant` et `Professeur`.
* **Encapsulation** : Protection des données et accesseurs sécurisés.
* **Java Streams API** : Utilisés pour les calculs de statistiques, les filtres de recherche et les classements.
* **Relations d'objets** : Gestion des associations bidirectionnelles (Ex: Département <-> Professeur).
* **Gestion des Dates** : Utilisation de `java.time.LocalDate`.

## Exemple d'exécution

Voici un extrait du rapport généré par l'application :

```text
╔════════════════════════════════════════════════╗
║        UNIVERSITÉ DJILALI LIABES               ║
╚════════════════════════════════════════════════╝
Localisation: Sidi Bel Abbes, Algérie
Départements: 3
Étudiants: 13
Professeurs: 6
Cours: 9

=== TOP 3 DES MEILLEURS ÉTUDIANTS ===
1. Fellah Sofiane (20200012) - Moyenne: 17.25
2. Bensalem Meriem (20210010) - Moyenne: 17.00
3. Bouziane Yasmine (20220001) - Moyenne: 16.90

classDiagram
    class Universite {
        -String nom
        -List~Departement~ departements
        -List~Etudiant~ etudiants
    }
    class Departement {
        -String code
        -String nom
    }
    class Personne {
        <<Abstract>>
        #String nom
        #String prenom
        #String email
    }
    class Etudiant {
        -String numeroEtudiant
        -Double moyenne
        +calculerMoyenne()
    }
    class Professeur {
        -String matricule
        -String grade
        +attribuerNote()
    }
    class Cours {
        -String code
        -Int credits
    }
    class Note {
        -Double valeur
        -Double coefficient
    }

    Universite *-- "0..*" Departement
    Departement o-- "0..*" Professeur
    Departement o-- "0..*" Etudiant
    Personne <|-- Etudiant
    Personne <|-- Professeur
    Etudiant "1" --> "0..*" Note
    Note --> "1" Cours
    Professeur --> "0..*" Cours : enseigne
