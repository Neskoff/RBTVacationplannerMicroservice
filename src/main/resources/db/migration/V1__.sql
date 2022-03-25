CREATE TABLE vacation_year
(
    email         VARCHAR(255) NOT NULL,
    year          INTEGER      NOT NULL,
    name          VARCHAR(255),
    surname       VARCHAR(255),
    vacation_days INTEGER,
    CONSTRAINT pk_vacation_year PRIMARY KEY (email, year)
);