-- Sample Inserts for eKamp Database

-- Country
INSERT INTO `eKamp`.`country` (`name`) VALUES ('United States');
INSERT INTO `eKamp`.`country` (`name`) VALUES ('Canada');
INSERT INTO `eKamp`.`country` (`name`) VALUES ('United Kingdom');

-- Person
INSERT INTO `eKamp`.`person` (`first_name`, `last_name`, `date_of_birth`, `sex`, `jmbg`, `country_id`) VALUES ('John', 'Doe', '1990-05-15', 'M', '1234567890123', 1);
INSERT INTO `eKamp`.`person` (`first_name`, `last_name`, `date_of_birth`, `sex`, `jmbg`, `country_id`) VALUES ('Jane', 'Smith', '1985-10-20', 'F', '9876543210987', 2);
INSERT INTO `eKamp`.`person` (`first_name`, `last_name`, `date_of_birth`, `sex`, `jmbg`, `country_id`) VALUES ('Michael', 'Johnson', '1978-12-03', 'M', '4567890123456', 3);

-- Municipality
INSERT INTO `eKamp`.`municipility` (`name`, `country_id`, `post_code`) VALUES ('New York City', 1, '10001');
INSERT INTO `eKamp`.`municipility` (`name`, `country_id`, `post_code`) VALUES ('Toronto', 2, 'M5V 1J1');
INSERT INTO `eKamp`.`municipility` (`name`, `country_id`, `post_code`) VALUES ('London', 3, 'SW1A 1AA');

-- Place
INSERT INTO `eKamp`.`place` (`description`, `municipility_id`) VALUES ('Central Park', 1);
INSERT INTO `eKamp`.`place` (`description`, `municipility_id`) VALUES ('CN Tower', 2);
INSERT INTO `eKamp`.`place` (`description`, `municipility_id`) VALUES ('Buckingham Palace', 3);

-- Employee
INSERT INTO `eKamp`.`employee` (`person_id`, `username`, `password`, `is_admin`) VALUES (1, 'johndoe', 'password123', 1);

-- Camp Status
INSERT INTO `eKamp`.`camp_status` (`name`) VALUES ('Open');
INSERT INTO `eKamp`.`camp_status` (`name`) VALUES ('Closed');
INSERT INTO `eKamp`.`camp_status` (`name`) VALUES ('Under Construction');

-- Camp
INSERT INTO `eKamp`.`camp` (`name`, `place_id`, `camp_status_id`, `capacity`) VALUES ('Summer Camp 2024', 1, 1, 100);
INSERT INTO `eKamp`.`camp` (`name`, `place_id`, `camp_status_id`, `capacity`) VALUES ('Winter Retreat', 2, 2, 50);
INSERT INTO `eKamp`.`camp` (`name`, `place_id`, `camp_status_id`, `capacity`) VALUES ('Spring Break Camp', 3, 3, 75);

-- Assignment
INSERT INTO `eKamp`.`assignment` (`start_date`, `end_date`, `employee_person_id`, `camp_id`) VALUES ('2024-06-01', '2024-08-31', 1, 1);

-- Resident
INSERT INTO `eKamp`.`resident` (`person_id`, `needs_hospitalisation`, `employee_person_id`) VALUES (2, 1, 1);
INSERT INTO `eKamp`.`resident` (`person_id`, `needs_hospitalisation`, `employee_person_id`) VALUES (3, 0, 1);

-- Residence Period
INSERT INTO `eKamp`.`residence_period` (`start_date`, `end_date`, `camp_id`, `resident_person_id`) VALUES ('2024-06-01 09:00:00', '2024-08-31 18:00:00', 1, 2);
INSERT INTO `eKamp`.`residence_period` (`start_date`, `end_date`, `camp_id`, `resident_person_id`) VALUES ('2024-12-20 10:00:00', '2025-01-05 15:00:00', 2, 3);

