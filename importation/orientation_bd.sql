-- phpMyAdmin SQL Dump
-- version 4.6.3
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1:3306
-- Généré le :  Ven 15 Juillet 2016 à 21:20
-- Version du serveur :  5.7.13
-- Version de PHP :  5.5.9-1ubuntu4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `orientation`
--

-- --------------------------------------------------------

--
-- Structure de la table `Ecole`
--

CREATE TABLE `Ecole` (
  `nom_ecole` varchar(60) NOT NULL,
  `Password` varchar(60) DEFAULT NULL,
  `nom_inspection` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Ecole`
--

INSERT INTO `Ecole` (`nom_ecole`, `Password`, `nom_inspection`) VALUES
('hlm grand yoff 2', 'pass', 'inspection de thiaroye'),
('scat urbam', 'pass', 'inspection de thiaroye');

-- --------------------------------------------------------

--
-- Structure de la table `Eleve`
--

CREATE TABLE `Eleve` (
  `numeroTable` int(50) NOT NULL,
  `Prenom` varchar(60) DEFAULT NULL,
  `Nom` varchar(30) DEFAULT NULL,
  `dateNaissance` varchar(20) DEFAULT NULL,
  `lieu_Naissance` varchar(60) DEFAULT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `choix` varchar(5) DEFAULT NULL,
  `nom_ecole` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Eleve`
--

INSERT INTO `Eleve` (`numeroTable`, `Prenom`, `Nom`, `dateNaissance`, `lieu_Naissance`, `sexe`, `email`, `choix`, `nom_ecole`) VALUES
(78, 'Aissatou', 'Dem', '13/01/1999', 'Thies', 'F', 'null', 'TLS', 'null'),
(123, 'abdoulaye', 'ly', '12/01/2000', 'Podor', 'M', 'null', 'STG', 'null'),
(887, 'Seydou', 'Ba', '19/03/1998', 'Dakar', 'M', 'null', 'LGS', 'null'),
(1623, 'Hamady', 'LY', '29/09/2000', 'Casamanse', 'M', 'null', 'STG', 'null'),
(6688, 'Abou', 'Sow', '12/08/1998', 'St Louis', 'M', 'null', 'GST', 'null'),
(66776, 'Mariam', 'Diop', '16/08/1999', 'Linguere', 'F', 'null', 'LSG', 'null'),
(98877, 'Oumar', 'Gueye', '17/09/2000', 'Rufisque', 'M', 'null', 'LGS', 'null'),
(123456, 'Omzo', 'Gueye', '02/03/1998', 'Mbao', 'M', 'null', 'LSG', 'null');

-- --------------------------------------------------------

--
-- Structure de la table `Inspection`
--

CREATE TABLE `Inspection` (
  `nom_inspection` varchar(60) NOT NULL,
  `password_inspection` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Inspection`
--

INSERT INTO `Inspection` (`nom_inspection`, `password_inspection`) VALUES
('inspection de thiaroye', '12345');

-- --------------------------------------------------------

--
-- Structure de la table `Lycee`
--

CREATE TABLE `Lycee` (
  `nom_lycee` varchar(60) NOT NULL,
  `nb_place_S` int(11) DEFAULT NULL,
  `nb_place_L` int(11) DEFAULT NULL,
  `nb_place_G` int(11) DEFAULT NULL,
  `nb_place_T` int(11) DEFAULT NULL,
  `nom_inspection` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Lycee`
--

INSERT INTO `Lycee` (`nom_lycee`, `nb_place_S`, `nb_place_L`, `nb_place_G`, `nb_place_T`, `nom_inspection`) VALUES
('Delafosse', 0, 0, 0, 3, 'Inspection'),
('Lymodak', 50, 50, 0, 0, 'Inspection');

-- --------------------------------------------------------

--
-- Structure de la table `Resultat`
--

CREATE TABLE `Resultat` (
  `num_result` bigint(20) NOT NULL,
  `passage` int(1) DEFAULT NULL,
  `Moyenne_General` float DEFAULT NULL,
  `moyenne_Maths` float DEFAULT NULL,
  `moyenne_Francais` float DEFAULT NULL,
  `moyenne_SVT` float DEFAULT NULL,
  `moyenne_HistoGeo` float DEFAULT NULL,
  `moyenne_PC` float DEFAULT NULL,
  `eleve_numerotable` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Resultat`
--

INSERT INTO `Resultat` (`num_result`, `passage`, `Moyenne_General`, `moyenne_Maths`, `moyenne_Francais`, `moyenne_SVT`, `moyenne_HistoGeo`, `moyenne_PC`, `eleve_numerotable`) VALUES
(2, 2, 10, 11, 12, 9, 14, 6, 123),
(3, 1, 12, 12, 12, 12, 12, 12, 6688),
(4, 1, 12, 12, 12, 12, 12, 12, 98877),
(5, 0, 11, 11, 11, 11, 11, 11, 78),
(6, 1, 11, 10, 12, 14, 15, 9, 887),
(7, 1, 14.5, 19, 8, 18, 12, 17, 1623),
(8, 1, 11, 11, 11, 11, 11, 11, 66776),
(9, 1, 11, 11, 11, 11, 11, 11, 66776),
(10, 1, 14, 12, 15, 14, 16, 15, 123456);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Ecole`
--
ALTER TABLE `Ecole`
  ADD PRIMARY KEY (`nom_ecole`),
  ADD KEY `FK_Ecole_nom_inspection` (`nom_inspection`);

--
-- Index pour la table `Eleve`
--
ALTER TABLE `Eleve`
  ADD PRIMARY KEY (`numeroTable`);

--
-- Index pour la table `Inspection`
--
ALTER TABLE `Inspection`
  ADD PRIMARY KEY (`nom_inspection`);

--
-- Index pour la table `Lycee`
--
ALTER TABLE `Lycee`
  ADD PRIMARY KEY (`nom_lycee`);

--
-- Index pour la table `Resultat`
--
ALTER TABLE `Resultat`
  ADD PRIMARY KEY (`num_result`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Resultat`
--
ALTER TABLE `Resultat`
  MODIFY `num_result` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Ecole`
--
ALTER TABLE `Ecole`
  ADD CONSTRAINT `FK_Ecole_nom_inspection` FOREIGN KEY (`nom_inspection`) REFERENCES `Inspection` (`nom_inspection`);
