
DROP SCHEMA spcost CASCADE;
CREATE SCHEMA spcost;
USE spcost;

DROP TABLE config CASCADE IF EXISTS;

CREATE TABLE config (
    name STRING NOT NULL,
    value STRING,
    PRIMARY KEY (name)
);

INSERT INTO config (name, value) VALUES ('db_version', '1');
