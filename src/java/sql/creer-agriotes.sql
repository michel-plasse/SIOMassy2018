DROP SCHEMA IF EXISTS agriotes2018 ;

CREATE SCHEMA IF NOT EXISTS agriotes2018 DEFAULT CHARACTER SET utf8 ;
USE agriotes2018 ;

CREATE TABLE IF NOT EXISTS personne (
  id_personne INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  mail VARCHAR(45) NOT NULL,
  tel VARCHAR(10) NOT NULL,
  adresse VARCHAR(45) NULL,
  code_postal INT NULL,
  ville VARCHAR(45) NULL,
  mot_de_passe VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_personne),
  UNIQUE INDEX id_personne_UNIQUE (id_personne ASC),
  UNIQUE INDEX mail_UNIQUE (mail ASC))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS formation (
  id_formation INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  description VARCHAR(250) NOT NULL,
  PRIMARY KEY (id_formation),
  UNIQUE INDEX id_candidature_UNIQUE (id_formation ASC),
  UNIQUE INDEX nom_UNIQUE (nom ASC),
  UNIQUE INDEX description_UNIQUE (description ASC))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS session_formation (
  id_session_formation INT NOT NULL AUTO_INCREMENT,
  id_formation INT NOT NULL,
  date_debut DATETIME NOT NULL,
  date_fin DATETIME NOT NULL,
  est_ouverte TINYINT(1) NOT NULL,
  PRIMARY KEY (id_session_formation),
  UNIQUE INDEX id_session_formation_UNIQUE (id_session_formation ASC),
  INDEX fk_session_formation_formation_idx (id_formation ASC),
  CONSTRAINT fk_session_formation_formation
    FOREIGN KEY (id_formation)
    REFERENCES formation (id_formation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS etat_candidature (
  id_etat_candidature INT NOT NULL AUTO_INCREMENT,
  libelle VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_etat_candidature),
  UNIQUE INDEX id_etat_candidature_UNIQUE (id_etat_candidature ASC))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS candidature (
  id_personne INT NOT NULL,
  id_session_formation INT NOT NULL,
  id_etat_candidature INT NOT NULL,
  PRIMARY KEY (id_personne, id_session_formation),
  INDEX fk_candidature_personne1_idx (id_personne ASC),
  INDEX fk_candidature_session_formation1_idx (id_session_formation ASC),
  CONSTRAINT fk_candidature_etat_candidature1
    FOREIGN KEY (id_etat_candidature)
    REFERENCES etat_candidature (id_etat_candidature)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_candidature_personne1
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_candidature_session_formation1
    FOREIGN KEY (id_session_formation)
    REFERENCES session_formation (id_session_formation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS formateur (
  id_formateur INT NOT NULL,
  PRIMARY KEY (id_formateur),
  CONSTRAINT fk_formateur_personne1
    FOREIGN KEY (id_formateur)
    REFERENCES personne (id_personne)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS module (
  id_module INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_module),
  UNIQUE INDEX nom_UNIQUE (nom ASC))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS seance (
  id_seance INT NOT NULL AUTO_INCREMENT,
  id_session_formation INT NOT NULL,
  id_formateur INT NOT NULL,
  id_module INT NOT NULL,
  jour DATE NOT NULL,
  creneau TINYINT NOT NULL COMMENT '1 pour le matin, 2 pour l''après-midi',
  PRIMARY KEY (id_seance),
  INDEX fk_seance_session_formation1_idx (id_session_formation ASC),
  INDEX fk_seance_formateur1_idx (id_formateur ASC),
  INDEX fk_seance_module1_idx (id_module ASC),
  UNIQUE INDEX seance_unique_session_jour_creneau (id_session_formation ASC, jour ASC, creneau ASC),
  UNIQUE INDEX seance_unique_formateur_jour_creneau (id_formateur ASC, jour ASC, creneau ASC),
  CONSTRAINT fk_seance_session_formation1
    FOREIGN KEY (id_session_formation)
    REFERENCES session_formation (id_session_formation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_seance_formateur1
    FOREIGN KEY (id_formateur)
    REFERENCES formateur (id_formateur)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_seance_module1
    FOREIGN KEY (id_module)
    REFERENCES module (id_module)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS presence (
  id_seance INT NOT NULL,
  id_personne INT NOT NULL,
  est_present TINYINT(1) NULL,
  PRIMARY KEY (id_seance, id_personne),
  INDEX fk_candidature_has_seance_seance1_idx (id_seance ASC),
  INDEX fk_presence_personne1_idx (id_personne ASC),
  CONSTRAINT fk_candidature_has_seance_seance1
    FOREIGN KEY (id_seance)
    REFERENCES seance (id_seance)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_presence_personne1
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS evaluation (
  id_evaluation INT NOT NULL AUTO_INCREMENT,
  id_session_formation INT NOT NULL,
  id_module INT NOT NULL,
  id_formateur INT NOT NULL,
  date_debut DATETIME NOT NULL,
  nb_minutes INT NULL,
  titre VARCHAR(45) NULL,
  PRIMARY KEY (id_evaluation),
  INDEX fk_evaluation_module1_idx (id_module ASC),
  INDEX fk_evaluation_formateur1_idx (id_formateur ASC),
  INDEX fk_evaluation_session_formation1_idx (id_session_formation ASC),
  CONSTRAINT fk_evaluation_module1
    FOREIGN KEY (id_module)
    REFERENCES module (id_module)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_evaluation_formateur1
    FOREIGN KEY (id_formateur)
    REFERENCES formateur (id_formateur)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_evaluation_session_formation1
    FOREIGN KEY (id_session_formation)
    REFERENCES session_formation (id_session_formation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS note (
  id_evaluation INT NOT NULL,
  id_personne INT NOT NULL,
  note DECIMAL(3,1) NULL,
  PRIMARY KEY (id_evaluation, id_personne),
  INDEX fk_candidature_has_evaluation_evaluation1_idx (id_evaluation ASC),
  INDEX fk_note_personne1_idx (id_personne ASC),
  CONSTRAINT fk_candidature_has_evaluation_evaluation
    FOREIGN KEY (id_evaluation)
    REFERENCES evaluation (id_evaluation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_note_personne
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS evenement (
  id_evenement INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  date_effet DATE NOT NULL,
  PRIMARY KEY (id_evenement))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS type_echange (
  id_type_echange INT NOT NULL AUTO_INCREMENT,
  libelle VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_type_echange),
  UNIQUE INDEX libelle_UNIQUE (libelle ASC))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS echange (
  id_echange INT NOT NULL AUTO_INCREMENT,
  id_personne INT NOT NULL,
  id_type_echange INT NOT NULL,
  instant DATETIME NOT NULL,
  texte TEXT NOT NULL,
  PRIMARY KEY (id_echange),
  INDEX fk_echange_personne1_idx (id_personne ASC),
  INDEX fk_echange_type_echange1_idx (id_type_echange ASC),
  CONSTRAINT fk_echange_personne1
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_echange_type_echange1
    FOREIGN KEY (id_type_echange)
    REFERENCES type_echange (id_type_echange)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS invitation (
  id_personne INT NOT NULL,
  id_evenement INT NOT NULL,
  PRIMARY KEY (id_personne, id_evenement),
  INDEX fk_personne_has_evenement_evenement1_idx (id_evenement ASC),
  INDEX fk_personne_has_evenement_personne1_idx (id_personne ASC),
  CONSTRAINT fk_personne_has_evenement_personne1
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_personne_has_evenement_evenement1
    FOREIGN KEY (id_evenement)
    REFERENCES evenement (id_evenement)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS projet (
  id_projet INT NOT NULL AUTO_INCREMENT,
  id_formateur INT NOT NULL,
  id_session_formation INT NOT NULL,
  titre VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_projet),
  INDEX fk_projet_formateur1_idx (id_formateur ASC),
  INDEX fk_projet_session_formation1_idx (id_session_formation ASC),
  CONSTRAINT fk_projet_formateur1
    FOREIGN KEY (id_formateur)
    REFERENCES formateur (id_formateur)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_projet_session_formation1
    FOREIGN KEY (id_session_formation)
    REFERENCES session_formation (id_session_formation)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS avis (
  id_personne INT NOT NULL,
  fonctionnalite TINYINT NOT NULL,
  ergonomie TINYINT NOT NULL,
  beaute TINYINT NOT NULL,
  commentaire TEXT NULL,
  date_effet DATETIME NOT NULL,
  PRIMARY KEY (id_personne),
  CONSTRAINT fk_avis_personne1
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE  OR REPLACE VIEW stagiaire AS
SELECT p.*, sf.*
FROM 
  personne p
    INNER JOIN
  candidature c ON p.id_personne = c.id_personne
    INNER JOIN
  session_formation sf ON c.id_session_formation = sf.id_session_formation
WHERE c.id_etat_candidature = 6;
