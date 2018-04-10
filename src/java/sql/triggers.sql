DELIMITER $$

DROP TRIGGER IF EXISTS before_insert_personne $$
CREATE TRIGGER before_insert_personne 
BEFORE INSERT ON personne 
FOR EACH ROW
BEGIN
    SET NEW.nom := UPPER(NEW.nom);
    SET NEW.prenom := CONCAT(UPPER(LEFT(NEW.prenom, 1)), LOWER(SUBSTR(NEW.prenom, 2)));
END $$


DROP TRIGGER IF EXISTS seance_after_insert_trg $$
CREATE TRIGGER seance_after_insert_trg
AFTER INSERT ON seance
FOR EACH ROW
BEGIN
    DECLARE termine BOOLEAN DEFAULT FALSE;
    DECLARE v_id_personne INT;
    -- stagiaires de la session associee a la seance
    DECLARE lignes CURSOR FOR
    SELECT id_personne
    FROM stagiaire
    WHERE id_session_formation=NEW.id_session_formation;
    -- inserer une ligne de presence vide pour chaque stagiaire
    OPEN lignes;
    BEGIN
        DECLARE EXIT HANDLER FOR NOT FOUND SET termine = TRUE;
        REPEAT
            FETCH lignes INTO v_id_personne;
            INSERT INTO presence(id_personne, id_seance, est_present)
            VALUES (v_id_personne, NEW.id_seance, NULL);
        UNTIL termine END REPEAT; 
    END;
    CLOSE lignes;
END$$