USE barndoor_db;

insert into users (email, first_name, last_name, password, ranch_name, username)
values ('nia.d.watson@gmail.com', 'Nia', 'Watson', '$2a$10$4YzF8ynuftAyD5lep/KN4OhTOnmClyTyw/70y6nzrs5F3pSci83PO',
        'Watson & Son, LLC', 'goat_queen');

insert into herds (herd_name, description, user_id)
VALUES ('Boys', 'This herd is home to all bucks. (Sire and Wethers)', 1),
       ('Older Ladies', 'This herd is home to all does that can be bred (Dams 18 months and older)', 1),
       ('Young Ladies', 'This herd is home to all does that can not be bred (Dams under 18 months old)', 1);

insert into goats (tag_id, name, dob, img, sex, breed, weight_in_pounds, herd_id)
VALUES (221, 'Latte', '2019-03-19', 'https://cdn.filestackcontent.com/nZCnRHS7S7enHnV3Fywv', 'F', 'Boer/Kiko/Nubian/LaMancha/Spanish', 92, 2),
       (218, 'Martinie', '2018-03-17', 'https://cdn.filestackcontent.com/TPcTFAdtRf2n2owhvEWQ', 'F', 'Boer/Kiko/Nubian/Spanish', 85, 2),
       (219, 'Paperbag', '2018-04-19', 'https://cdn.filestackcontent.com/UDnPJQTyRlKyqgWR5QWr',  'F', 'Boer/Kiko/Nubian/Spanish', 80, 2),
       (220, 'Rubicon', '2018-05-24', 'https://cdn.filestackcontent.com/6EjX07DERGGalvnz5Nr5', 'F', 'Boer/Kiko/Spanish', 95, 2),
       (222, 'Bobe', '2021-04-16', 'https://cdn.filestackcontent.com/4NXFoSxZSpCIWm8x32Ad', 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 5, 1),
       (223, 'Pete', '2021-04-16', 'https://cdn.filestackcontent.com/i5mDOoIGTDe2c8R3nxWg', 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 50, 1),
       (224, 'Lilly', '2021-04-16', 'https://cdn.filestackcontent.com/o4F7nzA9SYWfi7dMNSEx', 'F', 'Boer/Kiko/Nubian/LaMancha/Spanish', 50, 2),
       (225, 'Oreo', '2022-02-22', 'https://cdn.filestackcontent.com/XPHVUvRMyQlualK6zd2w', 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 25, 1),
       (226, 'Cookie', '2022-02-22', 'https://cdn.filestackcontent.com/Uyf81UDET9xSCo5NuZcz', 'M', 'Boer/Kiko/Nubian/LaMancha/Spanish', 25, 1),
       (227, 'Nana', '2021-04-27', 'https://cdn.filestackcontent.com/R3gAXbdRLetHsV0ABrAo', 'F', 'Boer/Kiko/Nubian/Spanish/LaMancha', 50, 2),
       (228, 'PoPo', '2021-04-27', 'https://cdn.filestackcontent.com/4NXFoSxZSpCIWm8x32Ad', 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 50, 1),
       (229, 'Shadrach', '2022-05-13', 'https://cdn.filestackcontent.com/YQht8yITSrub7bwblNGO', 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15, 1),
       (230, 'Meshach', '2022-05-13', 'https://cdn.filestackcontent.com/nOsoDIZNQX9idZOMyxGQ', 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15, 1),
       (231, 'Abednego', '2022-05-13', 'https://cdn.filestackcontent.com/PHbmOkJkRrKmr3z0diS3', 'M', 'Boer/Kiko/Nubian/Spanish/LaMancha', 15, 1),
       (232, 'Durango', '2021-04-13', 'https://cdn.filestackcontent.com/Q6fSKsuMRVWDTvGyGeID', 'M', 'Boer/Kiko/Spanish/LaMancha', 50, 1),
       (233, 'HiLo', '2021-04-13', 'https://cdn.filestackcontent.com/5MYkaIIQ1SfOwrmKaMPE', 'F', 'Boer/Kiko/Spanish/LaMancha', 50, 2),
       (234, 'Dior', '2022-05-26', 'https://cdn.filestackcontent.com/eyjqM02WToS0zB8Aicm2', 'F', 'Boer/Kiko/Spanish/LaMancha', 15, 3),
       (235, 'Lauren', '2022-05-22', 'https://cdn.filestackcontent.com/8eVi0bHSoe97EGhFpKtx', 'F', 'Boer/Kiko/Spanish/LaMancha', 15, 3),
       (236, 'Ralph', '2022-05-22', 'https://cdn.filestackcontent.com/Q7io2xZT72CswKDVXbG5', 'M', 'Boer/Kiko/Spanish/LaMancha', 95, 1),
       (237, 'Morse II', '2022-05-22', 'https://cdn.filestackcontent.com/iIyloeZIQCvQamHbxA23', 'M', 'Myotonic', 120, 1);


insert into vaccines (description, vaccine_name)
VALUES ('pneumonia', 'Presponse HM'),
       ('provides long-term protection against overeating disease (types C&D) and tetanus.', 'CD/T');

insert into vaccine_records (date_administered, dosage_in_ccs, is_booster, goat_id, vaccine_id)
VALUES ('2022-07-02', 2, 1, 8, 2),
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
       ('2022-07-02', 2, 0, 18, 2),
       ('2022-07-02', 1, 0, 19, 1),
       ('2022-07-02', 2, 0, 19, 2),
       ('2022-07-02', 2, 1, 20, 2);

insert into pedigree (goat_id, parent_id)
VALUES (8, 6),
       (8, 2),
       (9, 6),
       (9, 2);





