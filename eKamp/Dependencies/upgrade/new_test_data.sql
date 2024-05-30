-- Insert data into country table
INSERT INTO `eKamp`.`country` (`name`) VALUES 
('Country A'),
('Country B'),
('Country C');

-- Insert data into person table with different residents and employees
INSERT INTO `eKamp`.`person` (`first_name`, `last_name`, `date_of_birth`, `sex`, `jmbg`, `country_id`) VALUES 
('John', 'Doe', '1980-01-01', 'M', '1234567890123', 1),
('Jane', 'Smith', '1990-02-02', 'F', '2345678901234', 2),
('Jim', 'Beam', '1975-03-03', 'M', '3456789012345', 3),
('Michael', 'Johnson', '1985-04-04', 'M', '4567890123456', 1),
('Emily', 'Taylor', '1978-05-05', 'F', '5678901234567', 2),
('David', 'Williams', '1995-06-06', 'M', '6789012345678', 3),
('Sarah', 'Brown', '1982-07-07', 'F', '7890123456789', 1),
('Robert', 'Jones', '1992-08-08', 'M', '8901234567890', 2),
('Laura', 'Clark', '1987-09-09', 'F', '9012345678901', 3),
('Daniel', 'Martinez', '1991-10-10', 'M', '0123456789012', 1);

-- Insert data into employee table with different employees
INSERT INTO `eKamp`.`employee` (`person_id`, `username`, `password`, `is_admin`, `is_active`) VALUES 
(4, 'michaeljohnson', '$2y$10$BEifFhq2TcHYEv7Q9B2Fme.uHc9FKE6O883K1.rEnGAsWyGLQ.93u', 1, 1),
(5, 'emilytaylor', '$2y$10$CrZclESnFMWQcigKHeNqt.t4sEUmOwQvF1OwjKPrE0AMR/TDG1eQ6', 0, 1),
(6, 'davidwilliams', '$2y$10$jeU92LgU/cZ/hdv38XOr2eCWT3/WOKckq3KJha23tBKaSd4nZVG06', 0, 1);

-- Insert data into resident table with different residents
INSERT INTO `eKamp`.`resident` (`person_id`, `needs_hospitalisation`, `employee_person_id`) VALUES 
(1, 0, 5),
(2, 1, 6),
(3, 0, 4),
(7, 1, 6),
(8, 0, 4),
(9, 1, 5),
(10, 0, 6);

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
('2024-01-01', '2024-12-31', 4, 1),
('2024-02-01', '2024-11-30', 5, 2),
('2024-03-01', '2024-10-31', 6, 3);

-- Insert data into residence_period table
INSERT INTO `eKamp`.`residence_period` (`start_date`, `end_date`, `camp_id`, `resident_person_id`) VALUES 
('2024-01-01 08:00:00', '2024-06-01 18:00:00', 1, 1),
('2024-02-01 09:00:00', '2024-07-01 19:00:00', 2, 2),
('2024-03-01 10:00:00', '2024-08-01 20:00:00', 3, 3),
('2024-04-01 08:00:00', '2024-09-01 18:00:00', 1, 7),
('2024-05-01 09:00:00', '2024-10-01 19:00:00', 2, 8),
('2024-06-01 10:00:00', '2024-11-01 20:00:00', 3, 9),
('2024-07-01 08:00:00', '2024-12-01 18:00:00', 1, 10);

-- Insert data into message table
INSERT INTO `eKamp`.`message` (`content`, `time_created`, `employee_person_id`) VALUES 
('Welcome to Camp Alpha!', '2024-01-01 12:00:00', 4),
('Please follow the camp rules.', '2024-02-01 13:00:00', 5),
('Emergency drill at 3 PM.', '2024-03-01 14:00:00', 6);
