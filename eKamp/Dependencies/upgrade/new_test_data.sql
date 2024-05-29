-- Test data for eKamp schema

-- Insert data into country table
INSERT INTO `eKamp`.`country` (`name`) VALUES 
('Country A'),
('Country B'),
('Country C');

-- Insert data into municipality table
INSERT INTO `eKamp`.`municipality` (`name`, `country_id`, `post_code`) VALUES 
('Municipality 1', 1, '12345'),
('Municipality 2', 2, '23456'),
('Municipality 3', 3, '34567');

-- Insert data into place table
INSERT INTO `eKamp`.`place` (`description`, `municipality_id`) VALUES 
('Place 1 in Municipality 1', 1),
('Place 2 in Municipality 2', 2),
('Place 3 in Municipality 3', 3);

-- Insert data into person table
INSERT INTO `eKamp`.`person` (`first_name`, `last_name`, `date_of_birth`, `sex`, `jmbg`, `country_id`) VALUES 
('John', 'Doe', '1980-01-01', 'M', '1234567890123', 1),
('Jane', 'Smith', '1990-02-02', 'F', '2345678901234', 2),
('Jim', 'Beam', '1975-03-03', 'M', '3456789012345', 3);

-- Insert data into employee table
INSERT INTO `eKamp`.`employee` (`person_id`, `username`, `password`, `is_admin`, `is_active`) VALUES 
(1, 'johndoe', SHA2('password123', 256), 1, 1),
(2, 'janesmith', SHA2('password123', 256), 0, 1),
(3, 'jimbeam', SHA2('password123', 256), 0, 1);

-- Insert data into camp_status table
INSERT INTO `eKamp`.`camp_status` (`name`) VALUES 
('Active'),
('Inactive'),
('Under Maintenance');

-- Insert data into camp table
INSERT INTO `eKamp`.`camp` (`name`, `place_id`, `camp_status_id`, `capacity`) VALUES 
('Camp Alpha', 1, 1, 100),
('Camp Beta', 2, 2, 200),
('Camp Gamma', 3, 3, 150);

-- Insert data into assignment table
INSERT INTO `eKamp`.`assignment` (`start_date`, `end_date`, `employee_person_id`, `camp_id`) VALUES 
('2024-01-01', '2024-12-31', 1, 1),
('2024-02-01', '2024-11-30', 2, 2),
('2024-03-01', '2024-10-31', 3, 3);

-- Insert data into resident table
INSERT INTO `eKamp`.`resident` (`person_id`, `needs_hospitalisation`, `employee_person_id`) VALUES 
(1, 0, 2),
(2, 1, 3),
(3, 0, 1);

-- Insert data into residence_period table
INSERT INTO `eKamp`.`residence_period` (`start_date`, `end_date`, `camp_id`, `resident_person_id`) VALUES 
('2024-01-01 08:00:00', '2024-06-01 18:00:00', 1, 1),
('2024-02-01 09:00:00', '2024-07-01 19:00:00', 2, 2),
('2024-03-01 10:00:00', '2024-08-01 20:00:00', 3, 3);

-- Insert data into message table
INSERT INTO `eKamp`.`message` (`content`, `time_created`, `employee_person_id`) VALUES 
('Welcome to Camp Alpha!', '2024-01-01 12:00:00', 1),
('Please follow the camp rules.', '2024-02-01 13:00:00', 2),
('Emergency drill at 3 PM.', '2024-03-01 14:00:00', 3);
