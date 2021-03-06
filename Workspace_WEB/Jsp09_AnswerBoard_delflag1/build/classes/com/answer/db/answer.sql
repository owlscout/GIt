DROP SEQUENCE BOARDNOSEQ;
DROP SEQUENCE GROUPNOSEQ;
DROP TABLE ANSWERBOARD;

CREATE SEQUENCE BOARDNOSEQ;
CREATE SEQUENCE GROUPNOSEQ;

-- 긃번호, 그룹번호, 그룹순서, 제목공백, 삭제여부('Y', 'N')
-- 제목, 내용, 작성자, 작성일
CREATE TABLE ANSWERBOARD(
	BOARDNO NUMBER NOT NULL,
	GROUPNO NUMBER NOT NULL,
	GROUPSEQ NUMBER NOT NULL,
	TITLETAB NUMBER NOT NULL,
	DELFLAG VARCHAR2(2) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WRITER VARCHAR2(500) NOT NULL,
	REGDATE DATE NOT NULL,
	CONSTRAINT ANSWER_BOARDNO_PK PRIMARY KEY (BOARDNO),
	CONSTRAINT ANSWER_DELFLAG_CK CHECK(DELFLAG IN('Y','N'))
);

SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, TITLE, CONTENT, WRITER, REGDATE
FROM ANSWERBOARD
ORDER BY GROUPNO DESC, GROUPSEQ;


--1. 글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, 'N', '답변형재밌다.','정말 재밌다.', '반장', SYSDATE);

--1번 글에 답글
--UPDATE
--부모의 그룹번호와 같은 그룹이면서
--부모의 그룹 순서보다 더 큰 글들의
--그룹 순서 + 1
UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ + 1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 1)
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 1);

--INSERT
INSERT INTO ANSWERBOARD
VALUES(
	BOARDNOSEQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 1),
	(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 1) + 1,
	(SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO = 1),
	'N',
	'RE:답변형 재밌다.',
	'진짜 재밌는거 맞아?',
	'강사',
	SYSDATE
);

-- 1번 글 삭제
UPDATE ANSWERBOARD
SET DELFLAG = 'Y'
WHERE BOARDNO = 1;