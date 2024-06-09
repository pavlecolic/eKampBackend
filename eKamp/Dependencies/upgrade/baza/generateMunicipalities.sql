-- Municipality names in Serbian
SET NAMES utf8mb4;

-- Insert municipalities for Serbia
INSERT INTO `eKamp`.`municipality` (`name`, `country_id`, `post_code`) VALUES
('Beograd', 1, '11000'),
('Novi Sad', 1, '21000'),
('Niš', 1, '18000'),
('Kragujevac', 1, '34000'),
('Subotica', 1, '24000'),
('Zrenjanin', 1, '23000'),
('Čačak', 1, '32000'),
('Novi Pazar', 1, '36300'),
('Kraljevo', 1, '36000'),
('Leskovac', 1, '16000');

-- Insert municipalities for Croatia
INSERT INTO `eKamp`.`municipality` (`name`, `country_id`, `post_code`) VALUES
('Zagreb', 2, '10000'),
('Split', 2, '21001'),
('Rijeka', 2, '51000'),
('Osijek', 2, '31000'),
('Zadar', 2, '23001'),
('Slavonski Brod', 2, '35000'),
('Pula', 2, '52100'),
('Karlovac', 2, '47000'),
('Sisak', 2, '44000'),
('Varaždin', 2, '42000');

-- Insert municipalities for Bosnia and Herzegovina
INSERT INTO `eKamp`.`municipality` (`name`, `country_id`, `post_code`) VALUES
('Sarajevo', 3, '71000'),
('Banja Luka', 3, '78000'),
('Tuzla', 3, '75000'),
('Zenica', 3, '72000'),
('Mostar', 3, '88000'),
('Bihać', 3, '77000'),
('Brčko', 3, '76100'),
('Trebinje', 3, '89000'),
('Doboj', 3, '74000'),
('Cazin', 3, '77220');

-- Insert municipalities for Montenegro
INSERT INTO `eKamp`.`municipality` (`name`, `country_id`, `post_code`) VALUES
('Podgorica', 4, '81000'),
('Nikšić', 4, '81400'),
('Herceg Novi', 4, '85340'),
('Bar', 4, '85000'),
('Budva', 4, '85310'),
('Kotor', 4, '85330'),
('Pljevlja', 4, '84210'),
('Tivat', 4, '85320'),
('Cetinje', 4, '81250'),
('Berane', 4, '84300');

-- Insert municipalities for North Macedonia
INSERT INTO `eKamp`.`municipality` (`name`, `country_id`, `post_code`) VALUES
('Skopje', 5, '1000'),
('Bitola', 5, '7000'),
('Kumanovo', 5, '1300'),
('Prilep', 5, '7500'),
('Tetovo', 5, '1200'),
('Ohrid', 5, '6000'),
('Gostivar', 5, '1230'),
('Strumica', 5, '6200'),
('Veles', 5, '1400'),
('Štip', 5, '2000');

-- Insert municipalities for Slovenia
INSERT INTO `eKamp`.`municipality` (`name`, `country_id`, `post_code`) VALUES
('Ljubljana', 6, '1001'),
('Maribor', 6, '2001'),
('Celje', 6, '3001'),
('Kranj', 6, '4001'),
('Velenje', 6, '300'),
('Koper', 6, '6001'),
('Novo Mesto', 6, '8000'),
('Ptuj', 6, '2250'),
('Trbovlje', 6, '1420'),
('Nova Gorica', 6, '5000');
