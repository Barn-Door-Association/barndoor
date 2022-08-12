DROP DATABASE IF EXISTS barndoor_db;

CREATE DATABASE IF NOT EXISTS barndoor_db;

CREATE USER barndoor_user@localhost IDENTIFIED BY 'password';
GRANT ALL ON barndoor_db.* TO barndoor_user@localhost;

USE barndoor_db;
SET foreign_key_checks = 0;
TRUNCATE TABLE herds;
SET foreign_key_checks = 1;

insert into herds (herd name, herd_id) VALUES ('Boys', 1),
                                           ('Older Ladies', 2),
                                           ('Young Ladies', 3);

insert into goats (tag_id, name, dob, sex, breed, weight_in_pounds, herd_id) VALUES (S221, Latte, 2019-03-19, F, Boer/Kiko/Nubian/LaMancha/Spanish, 92lbs, 2),
                                                                                 (S218, Martinie, 2018-03-17, F, Boer/Kiko/Nubian/Spanish, 85lbs, 2),
                                                                                 (S219, Paperbag, 2018-04-19, F, Boer/Kiko/Nubian/Spanish, 80lbs, 2),
                                                                                 (S220, Rubicon, 2018-05-24, F, Boer/Kiko/Spanish, 95lbs, 2),
                                                                                 (S222, Bobe, 2021-04-16, M, Boer/Kiko/Nubian/LaMancha/Spanish, 5lbs, 1),
                                                                                 (S223, Pete, 2021-04-16, M, Boer/Kiko/Nubian/LaMancha/Spanish, 50lbs, 1),
                                                                                 (S224, Lilly, 2021-04-16, F, Boer/Kiko/Nubian/LaMancha/Spanish, 50lbs, 2),
                                                                                 (S225, Oreo, 2022-02-22, M, Boer/Kiko/Nubian/LaMancha/Spanish, 25lbs, 1),
                                                                                 (S226, Cookie, 2022-02-22, M, Boer/Kiko/Nubian/LaMancha/Spanish, 25lbs, 1),
                                                                                 (S227, Nana, 2021-04-27, F, Boer/Kiko/Nubian/Spanish/LaMancha, 50lbs, 2),
                                                                                 (S228, PoPo, 2021-04-27, M, Boer/Kiko/Nubian/Spanish/LaMancha, 50lbs, 1),
                                                                                 (S229, Shadrach, 2022-05-13, M, Boer/Kiko/Nubian/Spanish/LaMancha, 15lbs, 1),
                                                                                 (S230, Meshach, 2022-05-13, M, Boer/Kiko/Nubian/Spanish/LaMancha, 15lbs, 1),
                                                                                 (S231, Abednego, 2022-05-13, M, Boer/Kiko/Nubian/Spanish/LaMancha, 15lbs, 1),
                                                                                 (S232, Durango, 2021-04-13, M, Boer/Kiko/Spanish/LaMancha, 50lbs, 1),
                                                                                 (S233, HiLo, 2021-04-13, F, Boer/Kiko/Spanish/LaMancha, 50lbs, 2),
                                                                                 (S234, Dior, 2022-05-26, F, Boer/Kiko/Spanish/LaMancha, 15lbs, 3),
                                                                                 (S235, Lauren, 2022-05-22, F, Boer/Kiko/Spanish/LaMancha, 15lbs, 3),
                                                                                 (S236, Ralph, 2022-05-22, M, Boer/Kiko/Spanish/LaMancha, 95lbs, 1),
                                                                                 (S237, Morse II, 2022-05-22, M, Myotonic, 120lbs, 1);

insert into vaccination_records (vaccination_id, dosage_in_ccs, date_administered, is_booster) VALUES (Presponse HM, 1, 2022-07-02, Y),
                                                                                                   (CD/T, 2, 2022-07-02, Y),
                                                                                                   (Presponse HM, 2, 2022-07-02, Y);


