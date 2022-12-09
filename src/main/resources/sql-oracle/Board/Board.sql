/*
 * Board.sql
 * 게시판 테이블 생성 (oracle xe 11g)
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29 최종수정 : 2022-11-29
 *
 */


/*게시 테이블 생성*/
CREATE TABLE board(
	id number(8) UNIQUE NOT null, 
	user_name varchar2(50) NOT null,
    title varchar2(200),
	content varchar2(3000),
    reg_date Date NOT null,
    edit_date Date NOT null,
    publish number(1) DEFAULT 1 NOT NULL,
    hit number(9) DEFAULT 0 NOT null
);

/*게시 id(num) 생성 시퀀스*/
CREATE SEQUENCE board_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 99999990
NOCYCLE
NOCACHE
NOORDER;

DROP TABLE board;
DROP SEQUENCE board_seq