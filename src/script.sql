################################################################################

CREATE DATABASE birthdayfriends;

CREATE USER birthday_user@'%' IDENTIFIED BY 'hola123';

GRANT ALL PRIVILEGES ON birthdayfriends.* TO birthday_user@'%';

FLUSH PRIVILEGES;

################################################################################

## v1.0

CREATE TABLE friends (

id          INT UNSIGNED AUTO_INCREMENT,
email       VARCHAR(64) NOT NULL,
name        VARCHAR(60) NOT NULL,
birthday    DATE        NOT NULL,

PRIMARY KEY(id)

);

################################################################################

## v2.0 (propuesta)

CREATE TABLE users (

email       VARCHAR(64),
name        VARCHAR(60) NOT NULL,
password    VARCHAR(32) NOT NULL,

PRIMARY KEY (email)

);

INSERT INTO user VALUES ('jimezam@autonoma.edu.co', 
                         'Jorge I. Meza', 
                         'Dz/eAQPdRAd8BAIVovq9CaCXrsw=');

CREATE TABLE friends (

id          INT UNSIGNED AUTO_INCREMENT,
owner       VARCHAR(64) NOT NULL,
email       VARCHAR(64) NOT NULL,
name        VARCHAR(60) NOT NULL,
birthday    DATE        NOT NULL,

PRIMARY KEY(id),
FOREIGN KEY(owner)  REFERENCES users(email)
    ON UPDATE CASCADE
    ON DELETE RESTRICT

);

################################################################################
