DROP SEQUENCE BOARDNOSEQ;
DROP SEQUENCE GROUPNOSEQ;
DROP TABLE ANSWERBOARD;

CREATE SEQUENCE BOARDNOSEQ;
CREATE SEQUENCE GROUPNOSEQ;


-- 글번호 그룹번호 그룹순서 제목공백 제목 내용 작성자 작성일
CREATE TABLE ANSWERBOARD(
	BOARDNO NUMBER PRIMARY KEY,
	GROUPNO NUMBER NOT NULL,
	GROUPSEQ NUMBER NOT NULL,
	TITLETAB NUMBER NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WRITER VARCHAR2(100) NOT NULL,
	REGDATE DATE NOT NULL
);


--1번글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0,
		'1번 글입니다', '1번 글을 썼는데 답변형..어렵다..', '호수', SYSDATE);
		
--1번글 답변 작성
--UPDATE

UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ + 1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?) -- 부모(리플달글)와 같은 그룹인것을 찾고
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) -- 부모의 SEQ보다 높은애들을 찾아서 SEQ에 1을 +한다

--INSERT

INSERT INTO ANSWERBOARD
VALUES(
	   BOARDNOSEQ.NEXTVAL,
	   (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 1),
	   (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 1) + 1,
	   (SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO = 1) + 1,
	 12345  
	   ㄴ'RE:1번글에 답변',
	   '답변',
	   '무플방지위원회',
	   SYSDATE
);
	   
-- 2번글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, '2번글 입니다.', '2번글 원글' , '반장', SYSDATE);

-- 2번글 답변
-- UPDATE
-- INSERT
-- 그룹번호 : 답변을 달려고 하는 부모글의 그룹번호
-- 그룹순서 : 답변을 달려고 하는 부모글의 그룹순서 + 1
-- 제목공백 : 답변을 달려고 하는 부모글의 제목공백 + 1
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSEQ.NEXTVAL,
	   (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 3),
	   (SELECT GROUPSEQ +1 FROM ANSWERBOARD WHERE BOARDNO = 3),
	   (SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO = 3),
	   'RE:2번글 입니다.',
	   '아이고 어렵다',
	   '강사',
	   SYSDATE
);

-- 2번글 답변에 답변
-- UPDATE
-- INSERT -- 뒤에 +1 하나 ()안에 +1하나 아무 차이 없다.
INSERT INTO ANSWERBOARD
VALUES(
		BOARDNOSEQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 4),
		(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 4) + 1,
		(SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO = 4),
		'RE:RE:2번글 입니다.',
		'진짜 어렵다.',
		'학생',
		SYSDATE
);

-- 2번 글에 답변 다시하기
-- UPDATE
-- 부모와 같은 그룹인 글들을 찾아서, 부모의 순서보다 큰 순서의 글들을 순서 + 1 해주자.
UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ +1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 3)
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 3);

-- INSERT
INSERT INTO ANSWERBOARD
VALUES (
		BOARDNOSEQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 3),	/*부모의 그룹번호*/
		(SELECT GROUPSEQ +1 FROM ANSWERBOARD WHERE BOARDNO = 3), /*부모의 그룹순서 + 1*/
		(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO = 3) +1, /*부모의 공백 + 1*/
		'RE:2번글 입니다.',
		'이제 좀 쉽네',
		'학생',
		SYSDATE
);

-- 2번글 다시 답변에 답변하기
-- UPDATE
UPDATE ANSWERBOARD
SET GROUPSEQ = GROUPSEQ + 1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 6) -- 부모(리플달글)와 같은 그룹인것을 찾고
AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = 6) -- 부모의 SEQ보다 높은애들을 찾아서 SEQ에 1을 +한다

-- INSERT
INSERT INTO ANSWERBOARD
VALUES(
		BOARDNOSEQ.NEXTVAL,
		(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = 6),
		(SELECT GROUPSEQ +1 FROM ANSWERBOARD WHERE BOARDNO = 6),
		(SELECT TITLETAB +1 FROM ANSWERBOARD WHERE BOARDNO = 6),
		'RE:RE:이젠 좀 쉽죠?',
		'아 이젠 쉽다',
		'강사',
		SYSDATE
);

--출력 
SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, TITLE, CONTENT, WRITER, REGDATE
FROM ANSWERBOARD
ORDER BY GROUPNO DESC, GROUPSEQ;