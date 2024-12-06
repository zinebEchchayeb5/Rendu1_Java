# Gestion des événements - Projet Java JDBC

## Prérequis

- JDK 11 ou supérieur
- MySQL ou PostgreSQL
- JDBC Driver pour MySQL ou PostgreSQL

## Installation et exécution

1. **Clonez ou téléchargez le projet**.

2. **Configurez votre base de données** :
   - Exécutez le script `script.sql` pour créer la base de données et insérer des données d'exemple.

3. **Compilez le projet** :
   - Ouvrez un terminal et exécutez la commande suivante pour compiler le code Java :
     ```bash
     javac -d bin src/*.java
     ```

4. **Exécutez le projet** :
   - Exécutez la classe `Main` avec la commande suivante :
     ```bash
     java -cp "bin;lib/*" Main
     ```

## Fonctionnalités

- **Gestion des utilisateurs** : Ajouter, afficher, supprimer des utilisateurs.
- **Gestion des événements** : Ajouter, afficher, modifier, supprimer des événements.
- **Gestion des salles et terrains** : Ajouter, afficher, supprimer des salles et terrains.
- **Gestion des réservations** : Réserver une salle, vérifier la disponibilité, afficher, modifier et supprimer des réservations.

## Exemple de tests

- Vérification de la disponibilité d'une salle.
- Ajout et suppression d'un utilisateur.
- Ajout, affichage, et modification d'un événement.
