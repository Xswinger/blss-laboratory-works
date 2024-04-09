CREATE TYPE ROLE AS ENUM ('R_USER', 'R_ADMIN');

CREATE TABLE IF NOT EXISTS CLASS(
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL,
    DESCRIPTION TEXT
);

CREATE TABLE IF NOT EXISTS COUNTRY(
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS BRAND(
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(15) NOT NULL,
    COUNTRY_ID INTEGER,
    FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (ID)
);

CREATE TABLE IF NOT EXISTS CAR_LINEUP(
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL,
    BRAND_ID INTEGER,
    FOREIGN KEY (BRAND_ID) REFERENCES BRAND (ID)
);

CREATE TABLE IF NOT EXISTS CHARACTERISTIC(
    ID SERIAL PRIMARY KEY,
    CARCASE TEXT,
    WEIGHT INTEGER,
    LIFTING_CAPACITY INTEGER,
    ENGINE_TYPE TEXT,
    CAPACITY INTEGER,
    MAX_POWER INTEGER,
    GEARBOX_TYPE TEXT,
    TRANSMISSION TEXT,
    TIRES TEXT,
    FUEL_TYPE TEXT
);

CREATE TABLE IF NOT EXISTS MODEL(
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(30) NOT NULL,
    DESCRIPTION TEXT,
    CLASS_ID INTEGER,
    COUNTRY_ID INTEGER,
    LINEUP_ID INTEGER,
    FOREIGN KEY (CLASS_ID) REFERENCES CLASS (ID),
    FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (ID),
    FOREIGN KEY (LINEUP_ID) REFERENCES CAR_LINEUP (ID)
);

CREATE TABLE USERS(
    ID SERIAL PRIMARY KEY,
    USERNAME VARCHAR(20) NOT NULL,
    PASSWORD VARCHAR(20) NOT NULL,
    ROLE ROLE
);