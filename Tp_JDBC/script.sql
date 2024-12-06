CREATE DATABASE IF NOT EXISTS gestion_evenements;
USE gestion_evenements;

CREATE TABLE IF NOT EXISTS utilisateurs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    type ENUM('ETUDIANT', 'PROFESSEUR') NOT NULL
);

CREATE TABLE IF NOT EXISTS evenements (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    date_evenement DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS salles_terrains (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,  
    capacite INT NOT NULL
);

CREATE TABLE IF NOT EXISTS reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    evenement_id INT NOT NULL,
    salle_terrain_id INT NOT NULL,
    date_reservation DATE NOT NULL,
    FOREIGN KEY (evenement_id) REFERENCES evenements(id),
    FOREIGN KEY (salle_terrain_id) REFERENCES salles_terrains(id)
);

INSERT INTO utilisateurs (nom, prenom, email, type) VALUES 
('Echchayeb', 'Zineb', 'z.ec@gmail.com', 'ETUDIANT'),
('Ali', 'Mouad', 'a.mouad@example.com', 'PROFESSEUR');

INSERT INTO evenements (nom, description, date_evenement) VALUES 
('Concert', 'Un concert de musique', '2024-12-12'),
('Conférence', 'Une conférence sur la programmation', '2024-12-13');

INSERT INTO salles_terrains (nom, type, capacite) VALUES 
('Salle A', 'SALLE', 50),
('Terrain 1', 'TERRAIN', 100);

INSERT INTO reservations (evenement_id, salle_terrain_id, date_reservation) VALUES 
(1, 1, '2024-12-12');
