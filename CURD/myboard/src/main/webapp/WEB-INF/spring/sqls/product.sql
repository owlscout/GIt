DROP SEQUENCE PRONOSEQ;
DROP TABLE PRODUCT;

CREATE SEQUENCE PRONOSEQ;

CREATE TABLE PRODUCT(
	PRONO NUMBER PRIMARY KEY,
	PRONAME VARCHAR2(1000),
	PROTITLE VARCHAR2(2000),
	PROCONTENT VARCHAR2(4000),
	PROKATE_1 VARCHAR2(100),
	PROKATE_2 VARCHAR2(100),
	PRODATE DATE,
	THUMB VARCHAR2(1000),
	PROSHOW NUMBER
);


DROP SEQUENCE PRONOSEQ;
DROP TABLE PRODUCT;

CREATE SEQUENCE PRONOSEQ;

CREATE TABLE PRODUCT(
	PRONO NUMBER PRIMARY KEY,
	PRONAME VARCHAR2(1000),
	PROTITLE VARCHAR2(2000),
	PROCONTENT VARCHAR2(4000),
	PROKATE_1 VARCHAR2(100),
	PROKATE_2 VARCHAR2(100),
	PRODATE DATE,
	THUMB VARCHAR2(1000),
	PROSHOW NUMBER
);

SELECT TO_CHAR(PRODATE, 'YYMMDD')
FROM PRODUCT

ALTER TABLE PRODUCT ADD ORDPRICE NUMBER;
ALTER TABLE PRODUCT ADD PRINCIPAL NUMBER;
ALTER TABLE PRODUCT ADD TAX NUMBER;

SELECT * FROM PRODUCT
SELECT * FROM MYUSER
