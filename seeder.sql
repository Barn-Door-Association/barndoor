


USE barndoor_db;

insert into users (email, first_name, last_name, password, ranch_name, username)
values ('nia.d.watson@gmail.com', 'Nia', 'Watson', '$2a$10$3HPsxjm.bqA5vv1k5spNu.LmXk6xOuISwfcnatwQgrWdHAZn0YL16',
        'Watson & Son, LLC', 'goat_queen');

insert into herds (herd_name, user_id)
VALUES ('Boys', 1),
       ('Older Ladies', 1),
       ('Young Ladies', 1);

insert into goats (tag_id, name, dob, sex, breed, weight_in_pounds, herd_id)
VALUES (221, 'Latte', '2019-03-19', 'F', 'Boer/Kiko/Nubian/LaMancha/Spanish', 92, 2),
       (218, 'Martinie', '2018-03-17', 'F', 'Boer/Kiko/Nubian/Spanish', 85, 2),
       (219, 'Paperbag', '2018-04-19', 'F', 'Boer/Kiko/Nubian/Spanish', 80, 2),
       (220, 'Rubicon', '2018-05-24', 'F', 'Boer/Kiko/Spanish', 95, 2),
       (222, 'Bobe', '2021-04-16', 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 5, 1),
       (223, 'Pete', '2021-04-16', 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 50, 1),
       (224, 'Lilly', '2021-04-16', 'F', 'Boer/Kiko/Nubian/LaMancha/Spanish', 50, 2),
       (225, 'Oreo', '2022-02-22', 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 25, 1),
       (226, 'Cookie', '2022-02-22', 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 25, 1),
       (227, 'Nana', '2021-04-27', 'F', 'Boer/Kiko/Nubian/Spanish/LaMancha', 50, 2),
       (228, 'PoPo', '2021-04-27', 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 50, 1),
       (229, 'Shadrach', '2022-05-13', 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15, 1),
       (230, 'Meshach', '2022-05-13', 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15, 1),
       (231, 'Abednego', '2022-05-13', 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15, 1),
       (232, 'Durango', '2021-04-13', 'M', 'Boer/Kiko/Spanish/LaMancha', 50, 1),
       (233, 'HiLo', '2021-04-13', 'F', 'Boer/Kiko/Spanish/LaMancha', 50, 2),
       (234, 'Dior', '2022-05-26', 'F', 'Boer/Kiko/Spanish/LaMancha', 15, 3),
       (235, 'Lauren', '2022-05-22', 'F', 'Boer/Kiko/Spanish/LaMancha', 15, 3);


insert into vaccines (description, vaccine_name)
VALUES ('pneumonia', 'Presponse HM'),
       ('provides long-term protection against overeating disease (types C&D) and tetanus.', 'CD/T');

insert into vaccine_records (date_administered, dosage_in_ccs, is_booster, goat_id, vaccines_id)
VALUES
       ('2022-07-02', 2, 1, 8, 2),
       ('2022-07-02', 2, 1, 9, 2),
       ('2022-07-02', 1, 1, 8, 1),
       ('2022-07-02', 1, 1, 9, 1),
       ('2022-07-02', 2, 0, 7, 1),
       ('2022-07-02', 2, 0, 10, 1),
       ('2022-07-02', 2, 0, 7, 2),
       ('2022-07-02', 2, 0, 10, 2),
       ('2022-07-02', 1, 0, 12, 1),
       ('2022-07-02', 1, 0, 13, 1),
       ('2022-07-02', 1, 0, 14, 1),
       ('2022-07-02', 1, 0, 17, 1),
       ('2022-07-02', 1, 0, 18, 1),
       ('2022-07-02', 2, 0, 12, 2),
       ('2022-07-02', 2, 0, 13, 2),
       ('2022-07-02', 2, 0, 14, 2),
       ('2022-07-02', 2, 0, 17, 2),
       ('2022-07-02', 2, 0, 18, 2);





