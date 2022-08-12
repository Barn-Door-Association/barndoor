DROP DATABASE IF EXISTS barndoor_db;

CREATE DATABASE IF NOT EXISTS barndoor_db;

CREATE USER barndoor_user@localhost IDENTIFIED BY 'password';
GRANT ALL ON barndoor_db.* TO barndoor_user@localhost;

USE barndoor_db;
SET foreign_key_checks = 0;
TRUNCATE TABLE herds;
SET foreign_key_checks = 1;

insert into herds (herd_name) VALUES ('Boys'),
                                     ('Older Ladies'),
                                     ('Young Ladies');

insert into goats (tag_id, name, dob, sex, breed, weight_in_pounds) VALUES (221, 'Latte', 2019-03-19, 'F', 'Boer/Kiko/Nubian/LaMancha/Spanish', 92),
                                                                           (218, 'Martinie', 2018-03-17, 'F', 'Boer/Kiko/Nubian/Spanish', 85),
                                                                           (219, 'Paperbag', '2018-04-19', 'F', 'Boer/Kiko/Nubian/Spanish', 80),
                                                                           (220, 'Rubicon', 2018-05-24, 'F', 'Boer/Kiko/Spanish', 95),
                                                                           (222, 'Bobe', 2021-04-16, 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 5),
                                                                           (223, 'Pete', 2021-04-16, 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 50),
                                                                           (224, 'Lilly', 2021-04-16, 'F', 'Boer/Kiko/Nubian/LaMancha/Spanish', 50),
                                                                           (225, 'Oreo', 2022-02-22, 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 25),
                                                                           (226, 'Cookie', 2022-02-22, 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 25),
                                                                           (227, 'Nana', 2021-04-27, 'F', 'Boer/Kiko/Nubian/Spanish/LaMancha', 50),
                                                                           (228, 'PoPo', 2021-04-27, 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 50),
                                                                           (229, 'Shadrach', 2022-05-13, 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15),
                                                                           (230, 'Meshach', 2022-05-13, 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15),
                                                                           (231, 'Abednego', 2022-05-13, 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15),
                                                                           (232, 'Durango', 2021-04-13, 'M', 'Boer/Kiko/Spanish/LaMancha', 50),
                                                                           (233, 'HiLo', 2021-04-13, 'F', 'Boer/Kiko/Spanish/LaMancha', 50),
                                                                           (234, 'Dior', 2022-05-26, 'F', 'Boer/Kiko/Spanish/LaMancha', 15),
                                                                           (235, 'Lauren', 2022-05-22, 'F', 'Boer/Kiko/Spanish/LaMancha', 15),
                                                                           (236, 'Ralph', 2022-05-22, 'M', 'Boer/Kiko/Spanish/LaMancha', 95),
                                                                           (237, 'Morse II', 2022-05-22, 'M', 'Myotonic', 120);

insert into vaccines (description, vaccine_name) VALUES ('pneumonia', 'Presponse HM'),
                                                        ('provides long-term protection against overeating disease (types C&D) and tetanus.', 'CD/T');




