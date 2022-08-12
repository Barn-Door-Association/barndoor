DROP DATABASE IF EXISTS barndoor_db;

CREATE DATABASE IF NOT EXISTS barndoor_db;

CREATE USER barndoor_user@localhost IDENTIFIED BY 'password';
GRANT ALL ON barndoor_db.* TO barndoor_user@localhost;

USE barndoor_db;
