DROP SEQUENCE KATENOSEQ;
DROP TABLE KATEGORIE;

CREATE SEQUENCE KATENOSEQ;

CREATE TABLE KATEGORIE(
	DELNO NUMBER PRIMARY KEY,
	PRONO NUMBER,
	KATE_1 VARCHAR2(100),
	KATE_2 VARCHAR2(100)
	
);