DELIMITER //

CREATE TRIGGER new_message_trigger AFTER INSERT ON `eKamp`.`message`
FOR EACH ROW
BEGIN
    DECLARE creator_id INT;
    
    -- Pronalazi ID kreatora poruke
    SELECT employee_person_id INTO creator_id
    FROM `eKamp`.`message`
    WHERE id = NEW.id;
    
    -- Ubacuje novi red u user_messages za svakog korisnika osim kreatora poruke
    INSERT INTO `eKamp`.`user_messages` (message_id, employee_person_id, read_at)
    SELECT NEW.id, person_id, NULL
    FROM `eKamp`.`employee`
    WHERE person_id != creator_id;
END;
//

DELIMITER ;
