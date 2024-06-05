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
('Dejan', 'Ikic', '1999-11-11', 'M', '1111111111222', 1),
('Sarah', 'Brown', '1982-07-07', 'F', '7890123456789', 1),
('Robert', 'Jones', '1992-08-08', 'M', '8901234567890', 2),
('Laura', 'Clark', '1987-09-09', 'F', '9012345678901', 3),
('Daniel', 'Martinez', '1991-10-10', 'M', '0123456789012', 1),
('Alice', 'Wonderland', '1985-01-01', 'F', '1234500000001', 1),
('Bob', 'Builder', '1986-02-02', 'M', '1234500000002', 1),
('Charlie', 'Chocolate', '1987-03-03', 'M', '1234500000003', 1),
('Diana', 'Prince', '1988-04-04', 'F', '1234500000004', 1),
('Edward', 'Scissorhands', '1989-05-05', 'M', '1234500000005', 1),
('Fiona', 'Apple', '1990-06-06', 'F', '1234500000006', 1),
('George', 'Clooney', '1991-07-07', 'M', '1234500000007', 1),
('Hannah', 'Montana', '1992-08-08', 'F', '1234500000008', 1),
('Ian', 'Fleming', '1993-09-09', 'M', '1234500000009', 1),
('Julia', 'Roberts', '1994-10-10', 'F', '1234500000010', 1),
('Kevin', 'Hart', '1995-11-11', 'M', '1234500000011', 1),
('Liam', 'Neeson', '1996-12-12', 'M', '1234500000012', 1),
('Mila', 'Kunis', '1997-01-01', 'F', '1234500000013', 1),
('Noah', 'Wyle', '1998-02-02', 'M', '1234500000014', 1),
('Oprah', 'Winfrey', '1999-03-03', 'F', '1234500000015', 1),
('Paul', 'McCartney', '2000-04-04', 'M', '1234500000016', 1),
('Quentin', 'Tarantino', '2001-05-05', 'M', '1234500000017', 1),
('Rachel', 'Weisz', '2002-06-06', 'F', '1234500000018', 1),
('Sam', 'Smith', '2003-07-07', 'M', '1234500000019', 1),
('Tom', 'Hanks', '2004-08-08', 'M', '1234500000020', 1),
('Eve', 'Online', '1989-05-05', 'F', '1234500000021', 2),
('Frank', 'Ocean', '1990-06-06', 'M', '1234500000022', 2),
('Grace', 'Hopper', '1991-07-07', 'F', '1234500000023', 2),
('Hank', 'Williams', '1992-08-08', 'M', '1234500000024', 2),
('Isla', 'Fisher', '1993-09-09', 'F', '1234500000025', 2),
('Jack', 'Black', '1994-10-10', 'M', '1234500000026', 2),
('Karen', 'Gillan', '1995-11-11', 'F', '1234500000027', 2),
('Leonardo', 'DiCaprio', '1996-12-12', 'M', '1234500000028', 2),
('Meryl', 'Streep', '1997-01-01', 'F', '1234500000029', 2),
('Nina', 'Dobrev', '1998-02-02', 'F', '1234500000030', 2),
('Oscar', 'Isaac', '1999-03-03', 'M', '1234500000031', 2),
('Peyton', 'Manning', '2000-04-04', 'M', '1234500000032', 2),
('Quincy', 'Jones', '2001-05-05', 'M', '1234500000033', 2),
('Rihanna', 'Fenty', '2002-06-06', 'F', '1234500000034', 2),
('Selena', 'Gomez', '2003-07-07', 'F', '1234500000035', 2),
('Taylor', 'Swift', '2004-08-08', 'F', '1234500000036', 2),
('Uma', 'Thurman', '2005-09-09', 'F', '1234500000037', 2),
('Vin', 'Diesel', '2006-10-10', 'M', '1234500000038', 2),
('Will', 'Smith', '2007-11-11', 'M', '1234500000039', 2),
('Xena', 'Warrior', '2008-12-12', 'F', '1234500000040', 2),
('Ivan', 'Terrible', '1993-09-09', 'M', '1234500000041', 3),
('Jack', 'Sparrow', '1994-10-10', 'M', '1234500000042', 3),
('Kara', 'Thrace', '1995-11-11', 'F', '1234500000043', 3),
('Lara', 'Croft', '1996-12-12', 'F', '1234500000044', 3),
('Mario', 'Bros', '1997-01-01', 'M', '1234500000045', 3),
('Niko', 'Bellic', '1998-02-02', 'M', '1234500000046', 3),
('Olivia', 'Benson', '1999-03-03', 'F', '1234500000047', 3),
('Peter', 'Parker', '2000-04-04', 'M', '1234500000048', 3),
('Quinn', 'Fabray', '2001-05-05', 'F', '1234500000049', 3),
('Rebecca', 'Bunch', '2002-06-06', 'F', '1234500000050', 3),
('Sherlock', 'Holmes', '2003-07-07', 'M', '1234500000051', 3),
('Tina', 'Fey', '2004-08-08', 'F', '1234500000052', 3),
('Ursula', 'Leguin', '2005-09-09', 'F', '1234500000053', 3),
('Victor', 'Frankenstein', '2006-10-10', 'M', '1234500000054', 3),
('Wanda', 'Maximoff', '2007-11-11', 'F', '1234500000055', 3),
('Xander', 'Cage', '2008-12-12', 'M', '1234500000056', 3),
('Yara', 'Greyjoy', '2009-01-01', 'F', '1234500000057', 3),
('Zoe', 'Saldana', '2010-02-02', 'F', '1234500000058', 3),
('Albus', 'Dumbledore', '2011-03-03', 'M', '1234500000059', 3),
('Bilbo', 'Baggins', '2012-04-04', 'M', '1234500000060', 3);

-- Insert data into employee table with different employees
INSERT INTO `eKamp`.`employee` (`person_id`, `username`, `password`, `is_admin`, `is_active`) VALUES 
(4, 'michaeljohnson', '$2y$10$BEifFhq2TcHYEv7Q9B2Fme.uHc9FKE6O883K1.rEnGAsWyGLQ.93u', 1, 1),
(5, 'emilytaylor', '$2y$10$CrZclESnFMWQcigKHeNqt.t4sEUmOwQvF1OwjKPrE0AMR/TDG1eQ6', 0, 1),
(6, 'davidwilliams', '$2y$10$jeU92LgU/cZ/hdv38XOr2eCWT3/WOKckq3KJha23tBKaSd4nZVG06', 0, 1),
(7, 'dikic',  '$2y$10$jeU92LgU/cZ/hdv38XOr2eCWT3/WOKckq3KJha23tBKaSd4nZVG06', 0, 1);

-- Insert data into resident table with different residents
INSERT INTO `eKamp`.`resident` (`person_id`, `needs_hospitalisation`, `employee_person_id`) VALUES 
(1, 0, 5),
(2, 1, 6),
(3, 0, 4),
(8, 0, 4),
(9, 1, 5),
(10, 0, 6),
(11, 0, 5), (12, 1, 6), (13, 0, 4), (14, 1, 5), (15, 0, 6), (16, 1, 4), (17, 0, 5), (18, 1, 6), (19, 0, 4), (20, 1, 5), (21, 0, 6), (22, 1, 4), (23, 0, 5), (24, 1, 6), (25, 0, 4), (26, 1, 5), (27, 0, 6), (28, 1, 4), (29, 0, 5), (30, 1, 6),
(31, 1, 6), (32, 0, 4), (33, 1, 5), (34, 0, 6), (35, 1, 4), (36, 0, 5), (37, 1, 6), (38, 0, 4), (39, 1, 5), (40, 0, 6), (41, 1, 4), (42, 0, 5), (43, 1, 6), (44, 0, 4), (45, 1, 5), (46, 0, 6), (47, 1, 4), (48, 0, 5), (49, 1, 6), (50, 0, 4),
(51, 1, 6), (52, 0, 4), (53, 1, 5), (54, 0, 6), (55, 1, 4), (56, 0, 5), (57, 1, 6), (58, 0, 4), (59, 1, 5), (60, 0, 6);


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
('2024-02-01', '2024-11-30', 5, 2),
('2024-03-01', '2024-10-31', 6, 3),
('2024-03-01', '2024-10-31', 7, 1);

-- Insert data into residence_period table with additional residents
INSERT INTO `eKamp`.`residence_period` (`start_date`, `end_date`, `camp_id`, `resident_person_id`) VALUES 
('2024-07-01 08:00:00', '2024-12-01 18:00:00', 1, 1),
    ('2024-08-01 09:00:00', '2024-12-05 19:00:00', 1, 2),
    ('2024-09-01 10:00:00', '2024-12-10 20:00:00', 1, 3),
    ('2024-08-02 09:00:00', '2024-12-06 19:00:00', 1, 8),
    ('2024-09-02 10:00:00', '2024-12-11 20:00:00', 1, 9),
    ('2024-07-03 08:00:00', '2024-12-03 18:00:00', 1, 10),
    ('2024-08-02 09:00:00', '2024-12-04 18:00:00', 1, 11),
    ('2024-09-05 08:00:00', '2024-12-05 18:00:00', 1, 12),
    ('2024-10-06 08:00:00', '2024-12-06 18:00:00', 1, 13),
    ('2024-12-07 08:00:00', '2024-12-07 18:00:00', 1, 14),
    ('2024-11-08 08:00:00', '2024-12-08 18:00:00', 1, 15),
    ('2024-08-02 09:00:00', '2024-12-09 18:00:00', 1, 16),
    ('2024-05-10 08:00:00', '2024-12-10 18:00:00', 1, 17),
    ('2024-11-08 08:00:00', '2024-12-11 18:00:00', 1, 18),
    ('2024-01-12 08:00:00', '2024-12-12 18:00:00', 1, 19),
    ('2024-02-13 08:00:00', '2024-12-13 18:00:00', 1, 20),
    ('2024-02-14 08:00:00', '2024-12-14 18:00:00', 1, 21),
    ('2024-11-08 08:00:00', '2024-12-15 18:00:00', 1, 22),
    ('2024-07-16 08:00:00', '2024-12-16 18:00:00', 1, 23),
    ('2024-08-02 09:00:00', '2024-12-17 18:00:00', 1, 24),
    ('2024-08-18 08:00:00', '2024-12-18 18:00:00', 1, 25),
    ('2024-09-19 08:00:00', '2024-12-19 18:00:00', 1, 26),
    ('2024-10-20 08:00:00', '2024-12-20 18:00:00', 1, 27),
    ('2024-12-22 08:00:00', '2024-12-21 18:00:00', 1, 28),
    ('2024-08-18 08:00:00', '2024-12-22 18:00:00', 1, 29),
    ('2024-01-23 08:00:00', '2024-12-23 18:00:00', 1, 30),
	('2024-02-24 08:00:00', '2024-12-24 18:00:00', 1, 31),
    ('2024-03-25 08:00:00', '2024-12-25 18:00:00', 1, 32),
    ('2024-03-25 08:00:00','2024-12-26 18:00:00', 1, 33),
    ('2024-02-27 08:00:00', '2024-12-27 18:00:00', 1, 34),
    ('2024-03-28 08:00:00', '2024-12-28 18:00:00', 1, 35),
    ('2024-02-11 08:00:00', '2024-12-29 18:00:00', 1, 36),
    ('2024-07-30 08:00:00', '2024-12-30 18:00:00', 1, 37),
    ('2024-08-01 08:00:00', '2024-12-31 18:00:00', 1, 38),
    ('2024-03-25 08:00:00', '2024-12-01 18:00:00', 1, 39),
    ('2024-10-03 08:00:00', '2024-12-02 18:00:00', 1, 40),
    ('2024-02-08 08:00:00', '2024-12-03 18:00:00', 1, 41),
    ('2024-02-08 08:00:00', '2024-12-04 18:00:00', 1, 42),
    ('2024-02-08 08:00:00', '2024-12-05 18:00:00', 1, 43),
    ('2024-02-08 08:00:00', '2024-12-06 18:00:00', 1, 44),
    ('2024-02-08 08:00:00', '2024-12-07 18:00:00', 1, 45),
    ('2024-08-09 08:00:00', '2024-12-08 18:00:00', 1, 46),
    ('2024-02-11 08:00:00',  '2024-12-09 18:00:00', 1, 47),
    ('2024-08-11 08:00:00', '2024-12-10 18:00:00', 1, 48),
   ('2024-08-12 08:00:00', '2024-12-10 18:00:00', 1, 48),
    ('2024-08-13 08:00:00', '2024-12-11 18:00:00', 1, 49),
    ('2024-01-01 08:00:00', '2024-12-13 18:00:00', 1, 50),
    ('2024-02-02 08:00:00', '2024-12-14 18:00:00', 1, 51),
    ('2024-09-03 08:00:00', '2024-12-15 18:00:00', 1, 52),
    ('2024-09-04 08:00:00', '2024-12-16 18:00:00', 1, 53),
    ('2024-07-06 08:00:00', '2024-12-17 18:00:00', 1, 54),
    ('2024-07-06 08:00:00', '2024-12-18 18:00:00', 1, 55),
    ('2024-10-07 08:00:00', '2024-12-19 18:00:00', 1, 56),
    ('2024-09-10 08:00:00','2024-12-20 18:00:00', 1, 57),
    ('2024-02-11 08:00:00',  '2024-12-21 18:00:00', 1, 58),
    ('2024-09-10 08:00:00', '2024-12-22 18:00:00', 1, 59),
	('2024-09-10 08:00:00',  '2024-12-22 18:00:00', 1, 60);

-- Insert data into message table
INSERT INTO `eKamp`.`message` (`content`, `time_created`, `employee_person_id`) VALUES 
('Welcome to Camp Alpha!', '2024-01-01 12:00:00', 4),
('Please follow the camp rules.', '2024-02-01 13:00:00', 5),
('Emergency drill at 3 PM.', '2024-03-01 14:00:00', 6);

INSERT INTO `eKamp`.`user_messages` (`message_id`, `employee_person_id`, `read_at`) VALUES 
(1, 4, '2024-12-15 20:00:00'),
(2, 4, '2024-12-15 20:00:10'),
(3, 4, null),
(1, 5, '2024-12-15 21:00:00'),
(2, 5, null),
(3, 5, '2024-12-15 21:00:10'),
(1, 6, null),
(2, 6, null),
(3, 6, '2024-12-15 21:00:10'),
(1, 7, null),
(2, 7, null),
(3, 7, null);



