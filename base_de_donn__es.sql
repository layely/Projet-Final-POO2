-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Ven 01 Juillet 2016 à 00:09
-- Version du serveur: 5.5.35-1ubuntu1
-- Version de PHP: 5.5.9-1ubuntu4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `base_de_données`
--

-- --------------------------------------------------------

--
-- Structure de la table `Ecole`
--

CREATE TABLE IF NOT EXISTS `Ecole` (
  `nom_ecole` varchar(60) NOT NULL,
  `Password` varchar(60) DEFAULT NULL,
  `nom_inspection` varchar(60) NOT NULL,
  PRIMARY KEY (`nom_ecole`),
  KEY `FK_Ecole_nom_inspection` (`nom_inspection`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Eleve`
--

CREATE TABLE IF NOT EXISTS `Eleve` (
  `numeroTable` int(50) NOT NULL,
  `Prenom` varchar(60) DEFAULT NULL,
  `Nom` varchar(30) DEFAULT NULL,
  `dateNaissance` date DEFAULT NULL,
  `lieu_Naissance` varchar(60) DEFAULT NULL,
  `sexe` varchar(10) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `choix` varchar(5) DEFAULT NULL,
  `nom_ecole` varchar(60) NOT NULL,
  `resultat_num_result` int(50) NOT NULL,
  PRIMARY KEY (`numeroTable`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Inspection`
--

CREATE TABLE IF NOT EXISTS `Inspection` (
  `nom_inspection` varchar(60) NOT NULL,
  `password_inspection` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`nom_inspection`)
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

CREATE TABLE IF NOT EXISTS `Lycee` (
  `nom_lycee` varchar(60) NOT NULL,
  `nb_place_S` int(11) DEFAULT NULL,
  `nb_place_L` int(11) DEFAULT NULL,
  `nb_place_G` int(11) DEFAULT NULL,
  `nb_place_T` int(11) DEFAULT NULL,
  `nom_inspection` varchar(60) NOT NULL,
  PRIMARY KEY (`nom_lycee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `Resultat`
--

CREATE TABLE IF NOT EXISTS `Resultat` (
  `num_result` bigint(20) NOT NULL AUTO_INCREMENT,
  `passage` int(1) DEFAULT NULL,
  `Moyenne_General` float DEFAULT NULL,
  `moyenne_Maths` float DEFAULT NULL,
  `moyenne_Francais` float DEFAULT NULL,
  `moyenne_SVT` float DEFAULT NULL,
  `moyenne_HistoGeo` float DEFAULT NULL,
  `moyenne_PC` float DEFAULT NULL,
  `eleve_numerotable` bigint(20) NOT NULL,
  PRIMARY KEY (`num_result`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Ecole`
--
ALTER TABLE `Ecole`
  ADD CONSTRAINT `FK_Ecole_nom_inspection` FOREIGN KEY (`nom_inspection`) REFERENCES `Inspection` (`nom_inspection`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
