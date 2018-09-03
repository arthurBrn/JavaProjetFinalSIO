-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 03 sep. 2018 à 07:42
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gsbjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `famille`
--

DROP TABLE IF EXISTS `famille`;
CREATE TABLE IF NOT EXISTS `famille` (
  `FAM_CODE` varchar(3) NOT NULL,
  `FAM_LIBELLE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`FAM_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `famille`
--

INSERT INTO `famille` (`FAM_CODE`, `FAM_LIBELLE`) VALUES
('AA', 'Antalgiques en association'),
('AAA', 'Antalgiques antipyrétiques en association'),
('AAC', 'Antidépresseur d\'action centrale'),
('AAH', 'Antivertigineux antihistaminique H1'),
('ABA', 'Antibiotique antituberculeux'),
('ABC', 'Antibiotique antiacnéique local'),
('ABP', 'Antibiotique de la famille des béta-lactamines (pénicilline A)'),
('AFC', 'Antibiotique de la famille des cyclines'),
('AFM', 'Antibiotique de la famille des macrolides'),
('AH', 'Antihistaminique H1 local'),
('AIM', 'Antidépresseur imipraminique (tricyclique)'),
('AIN', 'Antidépresseur inhibiteur sélectif de la recapture de la sérotonine'),
('ALO', 'Antibiotique local (ORL)'),
('ANS', 'Antidépresseur IMAO non sélectif'),
('AO', 'Antibiotique ophtalmique'),
('AP', 'Antipsychotique normothymique'),
('AUM', 'Antibiotique urinaire minute'),
('CRT', 'Corticoïde, antibiotique et antifongique à  usage local'),
('HYP', 'Hypnotique antihistaminique'),
('PSA', 'Psychostimulant, antiasthénique');

-- --------------------------------------------------------

--
-- Structure de la table `localite`
--

DROP TABLE IF EXISTS `localite`;
CREATE TABLE IF NOT EXISTS `localite` (
  `LOC_CODEPOSTAL` char(5) NOT NULL,
  `LOC_VILLE` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`LOC_CODEPOSTAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `localite`
--

INSERT INTO `localite` (`LOC_CODEPOSTAL`, `LOC_VILLE`) VALUES
('13012', 'Allauh'),
('13015', 'Marseille'),
('13025', 'Berre'),
('23100', 'La souteraine'),
('23120', 'GrandBourg'),
('23200', 'Guéret'),
('44000', 'Nantes'),
('45000', 'Orléans'),
('46000', 'Cahors'),
('46123', 'Gramat'),
('46200', 'Lalbenque'),
('46250', 'Montcuq'),
('46512', 'Bessines'),
('75011', 'Paris'),
('75017', 'Paris'),
('75019', 'paris'),
('93100', 'Montreuil'),
('93210', 'Rosny'),
('93230', 'Romainville'),
('94000', 'Créteil');

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE IF NOT EXISTS `medecin` (
  `CODEMED` char(4) NOT NULL,
  `MEDECIN_TELEPHONE` varchar(15) DEFAULT NULL,
  `MEDECIN_POTENTIEL` varchar(50) DEFAULT NULL,
  `CODESPE` int(11) NOT NULL,
  PRIMARY KEY (`CODEMED`),
  KEY `CODESPE` (`CODESPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`CODEMED`, `MEDECIN_TELEPHONE`, `MEDECIN_POTENTIEL`, `CODESPE`) VALUES
('m001', '05-55-12-65-45', '', 1),
('m002', '04-91-67-45-98', '', 2),
('m003', '04-42-65-43-89', '', 3),
('m004', '02-40-88-77-76', '', 2),
('m005', '04-91-88-54-89', '', 4),
('m006', '02-38-67-98-22', '', 5),
('m007', '01-48-67-55-44', '', 6),
('m008', '05-55-98-67-44', '', 7),
('m009', '04-91-56-34-99', '', 8),
('m010', '01-44-33-56-21', '', 9),
('m011', '05-65-78-76-77', '', 2),
('m012', '05-61-56-29-35', '', 3),
('m013', '02-38-99-76-34', '', 5),
('m014', '02-40-78-43-22', '', 2),
('m015', '05-55-78-23-12', '', 1),
('m016', '04-50-67-34-22', '', 8),
('m017', '01-48-77-98-34', '', 2),
('m018', '01-55-76-43-54', '', 6),
('m019', '02-40-78-45-66', '', 2),
('m020', '02-48-54-53-44', '', 4);

-- --------------------------------------------------------

--
-- Structure de la table `medicament`
--

DROP TABLE IF EXISTS `medicament`;
CREATE TABLE IF NOT EXISTS `medicament` (
  `MED_DEPOTLEGAL` varchar(10) NOT NULL DEFAULT '',
  `MED_NOMCOMMERCIAL` varchar(25) DEFAULT NULL,
  `MED_COMPOSITION` varchar(255) DEFAULT NULL,
  `MED_EFFETS` varchar(255) DEFAULT NULL,
  `MED_CONTREINDIC` varchar(255) DEFAULT NULL,
  `MED_PRIXECHANTILLON` float DEFAULT NULL,
  `FAM_CODE` varchar(3) DEFAULT NULL,
  `FAM_LIBELLE` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`MED_DEPOTLEGAL`),
  KEY `FAM_CODE` (`FAM_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `medicament`
--

INSERT INTO `medicament` (`MED_DEPOTLEGAL`, `MED_NOMCOMMERCIAL`, `MED_COMPOSITION`, `MED_EFFETS`, `MED_CONTREINDIC`, `MED_PRIXECHANTILLON`, `FAM_CODE`, `FAM_LIBELLE`) VALUES
('3MYC7', 'TRIMYCINE', 'Triamcinolone (acétonide) + Néomycine + Nystatine', 'Ce médicament est un corticoïde à  activité forte ou très forte associé à  un antibiotique et un antifongique, utilisé en application locale dans certaines atteintes cutanées surinfectées.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants, d\'infections de la peau ou de parasitisme non traités, d\'acné. Ne pas appliquer sur une plaie, ni sous un pansement occlusif.', NULL, 'CRT', 'Corticoïde, antibiotique et antifongique à  usage local'),
('ADIMOL9', 'ADIMOL', 'Amoxicilline + Acide clavulanique', 'Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux pénicillines ou aux céphalosporines.', NULL, 'ABP', 'Antibiotique de la famille des béta-lactamines (pénicilline A)'),
('AMOPIL7', 'AMOPIL', 'Amoxicilline', 'Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux pénicillines. Il doit être administré avec prudence en cas d\'allergie aux céphalosporines.', NULL, 'ABP', 'Antibiotique de la famille des béta-lactamines (pénicilline A)'),
('AMOX45', 'AMOXAR', 'Amoxicilline', 'Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.', 'La prise de ce médicament peut rendre positifs les tests de dépistage du dopage.', NULL, 'ABP', 'Antibiotique de la famille des béta-lactamines (pénicilline A)'),
('AMOXIG12', 'AMOXI Gé', 'Amoxicilline', 'Ce médicament, plus puissant que les pénicillines simples, est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux pénicillines. Il doit être administré avec prudence en cas d\'allergie aux céphalosporines.', NULL, 'ABP', 'Antibiotique de la famille des béta-lactamines (pénicilline A)'),
('APATOUX22', 'APATOUX Vitamine C', 'Tyrothricine + Tétracaïne + Acide ascorbique (Vitamine C)', 'Ce médicament est utilisé pour traiter les affections de la bouche et de la gorge.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants, en cas de phénylcétonurie et chez l\'enfant de moins de 6 ans.', NULL, 'ALO', 'Antibiotique local (ORL)'),
('BACTIG10', 'BACTIGEL', 'Erythromycine', 'Ce médicament est utilisé en application locale pour traiter l\'acné et les infections cutanées bactériennes associées.', 'Ce médicament est contre-indiqué en cas d\'allergie aux antibiotiques de la famille des macrolides ou des lincosanides.', NULL, 'ABC', 'Antibiotique antiacnéique local'),
('BACTIV13', 'BACTIVIL', 'Erythromycine', 'Ce médicament est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux macrolides (dont le chef de file est l\'érythromycine).', NULL, 'AFM', 'Antibiotique de la famille des macrolides'),
('BITALV', 'BIVALIC', 'Dextropropoxyphène + Paracétamol', 'Ce médicament est utilisé pour traiter les douleurs d\'intensité modérée ou intense.', 'Ce médicament est contre-indiqué en cas d\'allergie aux médicaments de cette famille, d\'insuffisance hépatique ou d\'insuffisance rénale.', NULL, 'AAA', 'Antalgiques antipyrétiques en association'),
('CARTION6', 'CARTION', 'Acide acétylsalicylique (aspirine) + Acide ascorbique (Vitamine C) + Paracétamol', 'Ce médicament est utilisé dans le traitement symptomatique de la douleur ou de la fièvre.', 'Ce médicament est contre-indiqué en cas de troubles de la coagulation (tendances aux hémorragies), d\'ulcère gastroduodénal, maladies graves du foie.', NULL, 'AAA', 'Antalgiques antipyrétiques en association'),
('CLAZER6', 'CLAZER', 'Clarithromycine', 'Ce médicament est utilisé pour traiter des infections bactériennes spécifiques. Il est également utilisé dans le traitement de l\'ulcère gastro-duodénal, en association avec d\'autres médicaments.', 'Ce médicament est contre-indiqué en cas d\'allergie aux macrolides (dont le chef de file est l\'érythromycine).', NULL, 'AFM', 'Antibiotique de la famille des macrolides'),
('DEPRIL9', 'DEPRAMIL', 'Clomipramine', 'Ce médicament est utilisé pour traiter les épisodes dépressifs sévères, certaines douleurs rebelles, les troubles obsessionnels compulsifs et certaines énurésies chez l\'enfant.', 'Ce médicament est contre-indiqué en cas de glaucome ou d\'adénome de la prostate, d\'infarctus récent, ou si vous avez reà§u un traitement par IMAO durant les 2 semaines précédentes ou en cas d\'allergie aux antidépresseurs imipraminiques.', NULL, 'AIM', 'Antidépresseur imipraminique (tricyclique)'),
('DIMIRTAM6', 'DIMIRTAM', 'Mirtazapine', 'Ce médicament est utilisé pour traiter les épisodes dépressifs sévères.', 'La prise de ce produit est contre-indiquée en cas de d\'allergie à  l\'un des constituants.', NULL, 'AAC', 'Antidépresseur d\'action centrale'),
('DOLRIL7', 'DOLORIL', 'Acide acétylsalicylique (aspirine) + Acide ascorbique (Vitamine C) + Paracétamol', 'Ce médicament est utilisé dans le traitement symptomatique de la douleur ou de la fièvre.', 'Ce médicament est contre-indiqué en cas d\'allergie au paracétamol ou aux salicylates.', NULL, 'AAA', 'Antalgiques antipyrétiques en association'),
('DORNOM8', 'NORMADOR', 'Doxylamine', 'Ce médicament est utilisé pour traiter l\'insomnie chez l\'adulte.', 'Ce médicament est contre-indiqué en cas de glaucome, de certains troubles urinaires (rétention urinaire) et chez l\'enfant de moins de 15 ans.', NULL, 'HYP', 'Hypnotique antihistaminique'),
('EQUILARX6', 'EQUILAR', 'Méclozine', 'Ce médicament est utilisé pour traiter les vertiges et pour prévenir le mal des transports.', 'Ce médicament ne doit pas être utilisé en cas d\'allergie au produit, en cas de glaucome ou de rétention urinaire.', NULL, 'AAH', 'Antivertigineux antihistaminique H1'),
('EVILR7', 'EVEILLOR', 'Adrafinil', 'Ce médicament est utilisé pour traiter les troubles de la vigilance et certains symptomes neurologiques chez le sujet agé.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants.', NULL, 'PSA', 'Psychostimulant, antiasthénique'),
('INSXT5', 'INSECTIL', 'Diphénydramine', 'Ce médicament est utilisé en application locale sur les piqûres d\'insecte et l\'urticaire.', 'Ce médicament est contre-indiqué en cas d\'allergie aux antihistaminiques.', NULL, 'AH', 'Antihistaminique H1 local'),
('JOVAI8', 'JOVENIL', 'Josamycine', 'Ce médicament est utilisé pour traiter des infections bactériennes spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie aux macrolides (dont le chef de file est l\'érythromycine).', NULL, 'AFM', 'Antibiotique de la famille des macrolides'),
('LIDOXY23', 'LIDOXYTRACINE', 'Oxytétracycline +Lidocaïne', 'Ce médicament est utilisé en injection intramusculaire pour traiter certaines infections spécifiques.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants. Il ne doit pas être associé aux rétinoïdes.', NULL, 'AFC', 'Antibiotique de la famille des cyclines'),
('LITHOR12', 'LITHORINE', 'Lithium', 'Ce médicament est indiqué dans la prévention des psychoses maniaco-dépressives ou pour traiter les états maniaques.', 'Ce médicament ne doit pas être utilisé si vous êtes allergique au lithium. Avant de prendre ce traitement, signalez à  votre médecin traitant si vous souffrez d\'insuffisance rénale, ou si vous avez un régime sans sel.', NULL, 'AP', 'Antipsychotique normothymique'),
('PARMOL16', 'PARMOCODEINE', 'Codéine + Paracétamol', 'Ce médicament est utilisé pour le traitement des douleurs lorsque des antalgiques simples ne sont pas assez efficaces.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants, chez l\'enfant de moins de 15 Kg, en cas d\'insuffisance hépatique ou respiratoire, d\'asthme, de phénylcétonurie et chez la femme qui allaite.', NULL, 'AA', 'Antalgiques en association'),
('PHYSOI8', 'PHYSICOR', 'Sulbutiamine', 'Ce médicament est utilisé pour traiter les baisses d\'activité physique ou psychique, souvent dans un contexte de dépression.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants.', NULL, 'PSA', 'Psychostimulant, antiasthénique'),
('PIRIZ8', 'PIRIZAN', 'Pyrazinamide', 'Ce médicament est utilisé, en association à  d\'autres antibiotiques, pour traiter la tuberculose.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants, d\'insuffisance rénale ou hépatique, d\'hyperuricémie ou de porphyrie.', NULL, 'ABA', 'Antibiotique antituberculeux'),
('POMDI20', 'POMADINE', 'Bacitracine', 'Ce médicament est utilisé pour traiter les infections oculaires de la surface de l\'oeil.', 'Ce médicament est contre-indiqué en cas d\'allergie aux antibiotiques appliqués localement.', NULL, 'AO', 'Antibiotique ophtalmique'),
('TROXT21', 'TROXADET', 'Paroxétine', 'Ce médicament est utilisé pour traiter la dépression et les troubles obsessionnels compulsifs. Il peut également être utilisé en prévention des crises de panique avec ou sans agoraphobie.', 'Ce médicament est contre-indiqué en cas d\'allergie au produit.', NULL, 'AIN', 'Antidépresseur inhibiteur sélectif de la recapture de la sérotonine'),
('TXISOL22', 'TOUXISOL Vitamine C', 'Tyrothricine + Acide ascorbique (Vitamine C)', 'Ce médicament est utilisé pour traiter les affections de la bouche et de la gorge.', 'Ce médicament est contre-indiqué en cas d\'allergie à  l\'un des constituants et chez l\'enfant de moins de 6 ans.', NULL, 'ALO', 'Antibiotique local (ORL)'),
('URIEG6', 'URIREGUL', 'Fosfomycine trométamol', 'Ce médicament est utilisé pour traiter les infections urinaires simples chez la femme de moins de 65 ans.', 'La prise de ce médicament est contre-indiquée en cas d\'allergie à  l\'un des constituants et d\'insuffisance rénale.', NULL, 'AUM', 'Antibiotique urinaire minute');

-- --------------------------------------------------------

--
-- Structure de la table `offrir`
--

DROP TABLE IF EXISTS `offrir`;
CREATE TABLE IF NOT EXISTS `offrir` (
  `OFF_QTE_OFFERTE` int(11) NOT NULL,
  `MED_DEPOTLEGAL` varchar(10) DEFAULT NULL,
  `REFERENCE` char(5) DEFAULT NULL,
  PRIMARY KEY (`OFF_QTE_OFFERTE`),
  KEY `MED_DEPOTLEGAL` (`MED_DEPOTLEGAL`),
  KEY `REFERENCE` (`REFERENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `CODE_PERSONNE` varchar(4) NOT NULL,
  `PERS_NOM` varchar(50) DEFAULT NULL,
  `PERS_PRENOM` varchar(30) DEFAULT NULL,
  `PERS_ADRESSE` varchar(250) DEFAULT NULL,
  `LOC_CODEPOSTAL` char(5) NOT NULL,
  PRIMARY KEY (`CODE_PERSONNE`),
  KEY `fk_personne_loccodepostal` (`LOC_CODEPOSTAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`CODE_PERSONNE`, `PERS_NOM`, `PERS_PRENOM`, `PERS_ADRESSE`, `LOC_CODEPOSTAL`) VALUES
('a131', 'Villechalane', 'Louis', '8 rue des Charmes', '46000'),
('a17', 'Andre', 'David', '1 rue Petit', '46200'),
('a55', 'Bedos', 'Christian', '1 rue Peranud', '46250'),
('a93', 'Tusseau', 'Louis', '22 rue des Ternes', '46123'),
('b13', 'Bentot', 'Pascal', '11 allée des Cerises', '46512'),
('b16', 'Bioret', 'Luc', '1 Avenue gambetta', '46000'),
('b19', 'Bunisset', 'Francis', '10 rue des Perles', '93100'),
('b25', 'Bunisset', 'Denis', '23 rue Manin', '75019'),
('b28', 'Cacheux', 'Bernard', '114 rue Blanche', '75017'),
('b34', 'Cadic', 'Eric', '123 avenue de la République', '75011'),
('b4', 'Charoze', 'CATHERINE', '100 rue Petit', '75019'),
('b50', 'CLEPKENS', 'CHRISTOPHE', '12 allée des Anges', '93230'),
('b59', 'COTTIN', 'VINCENNE', '36 rue Des Roches', '93100'),
('c14', 'DABURON', 'FRANCOIS', '13 rue de Chanzy', '94000'),
('c3', 'DE', 'PHILIPPE', '13 rue Barthes', '94000'),
('c54', 'DEBELLE', 'MICHEL', '181 avenue Barbusse', '93210'),
('d13', 'DEBELLE', 'JEANNE', '134 allée des Joncs', '44000'),
('d51', 'DEBROISE', 'MICHEL', '2 Bld Jourdain', '44000'),
('e22', 'DESMARQUEST', 'NATHALIE', '14 Place d Arc', '45000'),
('e24', 'DESNOST', 'PIERRE', '16 avenue des Cèdres', '23200'),
('e39', 'DUDOUIT', 'FREDERIC', '18 rue de l église', '23120'),
('e49', 'DUNCOMBE', 'CLAUDE', '19 rue de la tour', '23100'),
('e5', 'ENAULT-PASCREAU', 'CELINE', '25 place de la gare', '44000'),
('e52', 'EYNDE', 'VALERIE', '3 Grand Place', '13015'),
('f21', 'Finck', 'Jacques', '10 avenue du Prado', '13012'),
('f39', 'Frémont', 'Fernande', '4 route de la mer', '13012'),
('f4', 'Gest', 'Alain', '30 avenue de la mer', '13025'),
('m001', 'SMITH', 'JEAN', '5 rue de la Poste', '23200'),
('m002', 'DURAND', 'PAUL', '34 boulevard Malherbes', '13015'),
('m003', 'JACQUES', 'ERIC', '45 rue des Tilleuls', '13025'),
('m004', 'LE GUEN', 'HENRI', '6 rue de la Paix', '44000'),
('m005', 'PAVERNE', 'PATRICK', '89 avenue Jean Jaures', '13015'),
('m006', 'LEMALIN', 'EMILE', '67 rue de la Mairie', '45000'),
('m007', 'DECHAVANNE', 'LAURENT', '7 impasse de l Etang', '93210'),
('m008', 'KAMELIN', 'JACQUES', '9 rue des Mimosas', '23120'),
('m009', 'TULAN', 'PIERRE', '4 avenue Mendes France', '13015'),
('m010', 'BANIZE', 'MARIE', '27 rue des Fleurs', '75019'),
('m011', 'DEVE', 'ANNIE', '8 rue des Platanes', '46000'),
('m012', 'CLEMENCEAU', 'MARC', '6 rue Nationale', '46512'),
('m013', 'BELLENOS', 'MICHEL', '89 rue des Embruns', '45000'),
('m014', 'FUMEL', 'ANNE-MARIE', '8 rue des écoles', '44000'),
('m015', 'GARDES', 'JEAN-LOUIS', '3 rue du 4 Septembre', '23100'),
('m016', 'GUYOT', 'BENOIS', '6 rue Nationale', '46512'),
('m017', 'WILSON', 'YANN', '34 rue Paul Eluard', '93210'),
('m018', 'MENJOUE', 'GERARD', '21 rue Jules Rimet', '93210'),
('m019', 'TRANSCEN', 'JEAN', '12 rue des Pinsons', '44000'),
('m020', 'LAGADEC', 'FREDERIQUE', '67 rue des Chênes', '13025');

-- --------------------------------------------------------

--
-- Structure de la table `specialites`
--

DROP TABLE IF EXISTS `specialites`;
CREATE TABLE IF NOT EXISTS `specialites` (
  `CODESPE` int(1) NOT NULL,
  `SPE_NOMSPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CODESPE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `specialites`
--

INSERT INTO `specialites` (`CODESPE`, `SPE_NOMSPE`) VALUES
(1, 'Cardiologue'),
(2, 'Généraliste'),
(3, 'Rhumatologue'),
(4, 'Dermatologue'),
(5, 'Neurologue'),
(6, 'Pédiatrie'),
(7, 'Psychiatrie'),
(8, 'Allergologue'),
(9, 'Gériatrie');

-- --------------------------------------------------------

--
-- Structure de la table `stocker`
--

DROP TABLE IF EXISTS `stocker`;
CREATE TABLE IF NOT EXISTS `stocker` (
  `STOCKER_QTESTOCKER` int(11) NOT NULL,
  `MATRICULE` char(4) DEFAULT NULL,
  `MED_DEPOTLEGAL` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`STOCKER_QTESTOCKER`),
  KEY `MATRICULE` (`MATRICULE`),
  KEY `MED_DEPOTLEGAL` (`MED_DEPOTLEGAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `visite`
--

DROP TABLE IF EXISTS `visite`;
CREATE TABLE IF NOT EXISTS `visite` (
  `REFERENCE` char(5) NOT NULL,
  `VISITE_DATEVISITE` datetime DEFAULT NULL,
  `VISITE_COMMENTAIRE` varchar(100) DEFAULT NULL,
  `MATRICULE` char(4) NOT NULL,
  `CODEMED` char(4) NOT NULL,
  PRIMARY KEY (`REFERENCE`),
  KEY `MATRICULE` (`MATRICULE`),
  KEY `CODEMED` (`CODEMED`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `visite`
--

INSERT INTO `visite` (`REFERENCE`, `VISITE_DATEVISITE`, `VISITE_COMMENTAIRE`, `MATRICULE`, `CODEMED`) VALUES
('v0001', '2002-01-20 00:00:00', '', 'b59', 'm001'),
('v0002', '2000-10-01 00:00:00', '', 'e39', 'm007'),
('v0003', '2001-05-10 00:00:00', '', 'e49', 'm005'),
('v0004', '2000-07-11 00:00:00', '', 'd13', 'm004'),
('v0005', '2006-12-22 00:00:00', '', 'c54', 'm008'),
('v0006', '2005-12-10 00:00:00', '', 'e22', 'm010'),
('v0007', '2006-02-03 00:00:00', '', 'e22', 'm014'),
('v0008', '2008-10-27 00:00:00', '', 'b34', 'm020'),
('v0009', '2001-06-18 00:00:00', '', 'e49', 'm005'),
('v0010', '2007-01-20 00:00:00', '', 'c54', 'm008'),
('v0011', '2002-02-13 00:00:00', '', 'f21', 'm011'),
('v0012', '2002-10-01 00:00:00', '', 'f39', 'm015'),
('v0013', '2002-03-10 00:00:00', '', 'f21', 'm012'),
('v0014', '2008-11-03 00:00:00', '', 'b34', 'm020'),
('v0015', '2006-04-20 00:00:00', '', 'e22', 'm010'),
('v0016', '2003-10-14 00:00:00', '', 'f21', 'm001'),
('v0017', '2002-07-04 00:00:00', '', 'e49', 'm005'),
('v0018', '2009-12-11 00:00:00', '', 'b28', 'm002'),
('v0019', '2001-01-10 00:00:00', '', 'e39', 'm007'),
('v0020', '2010-01-05 00:00:00', '', 'b28', 'm011'),
('v0021', '2000-09-03 00:00:00', '', 'd13', 'm004'),
('v0022', '2010-02-05 00:00:00', '', 'b28', 'm002'),
('v0023', '2002-06-02 00:00:00', '', 'b13', 'm009'),
('v1111', '2018-02-01 00:00:00', 'YEEEEEEEEEEEEEEEEES', 'b59', 'm015'),
('v1112', '2018-01-05 00:00:00', 'yeeees', 'b13', 'm008'),
('v1973', '2018-05-08 00:00:00', 'YEESSYESYESY', 'b28', 'm020');

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
CREATE TABLE IF NOT EXISTS `visiteur` (
  `MATRICULE` char(4) NOT NULL,
  `VISITEUR_LOGIN` varchar(50) DEFAULT NULL,
  `VISITEUR_MDP` varchar(20) DEFAULT NULL,
  `VISITEUR_DATEENTREE` datetime DEFAULT NULL,
  PRIMARY KEY (`MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `visiteur`
--

INSERT INTO `visiteur` (`MATRICULE`, `VISITEUR_LOGIN`, `VISITEUR_MDP`, `VISITEUR_DATEENTREE`) VALUES
('a131', 'lvillachane', 'jux7g', '2005-12-21 00:00:00'),
('a17', 'dandre', 'oppg5', '1998-11-23 00:00:00'),
('a55', 'cbedos', 'gmhxd', '1995-01-12 00:00:00'),
('a93', 'ltusseau', 'ktp3s', '2000-05-01 00:00:00'),
('b13', 'pbentot', 'doyw1', '1992-07-09 00:00:00'),
('b16', 'lbioret', 'hrjfs', '1998-05-11 00:00:00'),
('b19', 'fbunisset', '4vbnd', '1987-10-21 00:00:00'),
('b25', 'dbunisset', 's1y1r', '2010-12-05 00:00:00'),
('b28', 'bcacheux', 'uf7r3', '2009-11-12 00:00:00'),
('b34', 'ecadic', '6u8dc', '2008-09-23 00:00:00'),
('b4', 'ccharoze', 'u817o', '2005-11-12 00:00:00'),
('b50', 'cclepkens', 'bw1us', '2003-08-11 00:00:00'),
('b59', 'vcottin', '2hoh9', '2001-11-18 00:00:00'),
('c14', 'fdaburon', '7oqpv', '2002-02-11 00:00:00'),
('c3', 'pde', 'gk9kx', '2010-12-14 00:00:00'),
('c54', 'mdebelle', 'od5rt', '2006-11-23 00:00:00'),
('d13', 'jdebelle', 'nvwqq', '2000-05-11 00:00:00'),
('d51', 'mdebroise', 'sghkb', '2001-04-17 00:00:00'),
('e22', 'ndesmarquest', 'f1fob', '2005-11-12 00:00:00'),
('e24', 'pdesnost', '4k2o5', '2001-02-05 00:00:00'),
('e39', 'fdudouit', '44im8', '2000-08-01 00:00:00'),
('e49', 'cduncombe', 'qf77j', '1987-10-10 00:00:00'),
('e5', 'cenault', 'y2qdu', '1995-09-01 00:00:00'),
('e52', 'veynde', 'i7sn3', '1999-11-01 00:00:00'),
('f21', 'jfinck', 'mpb3t', '2001-11-10 00:00:00'),
('f39', 'ffremont', 'xs5tq', '1998-10-01 00:00:00'),
('f4', 'agest', 'dywvt', '1985-11-01 00:00:00');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD CONSTRAINT `fk_medecin_personne` FOREIGN KEY (`CODEMED`) REFERENCES `personne` (`CODE_PERSONNE`),
  ADD CONSTRAINT `medecin_ibfk_1` FOREIGN KEY (`CODESPE`) REFERENCES `specialites` (`CODESPE`);

--
-- Contraintes pour la table `medicament`
--
ALTER TABLE `medicament`
  ADD CONSTRAINT `medicament_ibfk_1` FOREIGN KEY (`FAM_CODE`) REFERENCES `famille` (`FAM_CODE`);

--
-- Contraintes pour la table `offrir`
--
ALTER TABLE `offrir`
  ADD CONSTRAINT `offrir_ibfk_1` FOREIGN KEY (`MED_DEPOTLEGAL`) REFERENCES `medicament` (`MED_DEPOTLEGAL`),
  ADD CONSTRAINT `offrir_ibfk_2` FOREIGN KEY (`REFERENCE`) REFERENCES `visite` (`REFERENCE`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `fk_personne_loccodepostal` FOREIGN KEY (`LOC_CODEPOSTAL`) REFERENCES `localite` (`LOC_CODEPOSTAL`);

--
-- Contraintes pour la table `stocker`
--
ALTER TABLE `stocker`
  ADD CONSTRAINT `stocker_ibfk_1` FOREIGN KEY (`MATRICULE`) REFERENCES `visiteur` (`MATRICULE`),
  ADD CONSTRAINT `stocker_ibfk_2` FOREIGN KEY (`MED_DEPOTLEGAL`) REFERENCES `medicament` (`MED_DEPOTLEGAL`);

--
-- Contraintes pour la table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `visite_ibfk_1` FOREIGN KEY (`MATRICULE`) REFERENCES `visiteur` (`MATRICULE`),
  ADD CONSTRAINT `visite_ibfk_2` FOREIGN KEY (`CODEMED`) REFERENCES `medecin` (`CODEMED`);

--
-- Contraintes pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD CONSTRAINT `fk_visiteur_personne` FOREIGN KEY (`MATRICULE`) REFERENCES `personne` (`CODE_PERSONNE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
