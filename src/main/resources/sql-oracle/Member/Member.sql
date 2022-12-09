/*
 * member.sql
 * 회원정보 테이블 생성 (oracle xe 11g)
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-24 최종수정 : 2022-11-25
 *
 */


/*회원정보 테이블 생성*/
CREATE TABLE member(
	id number(10) UNIQUE NOT null, 
	email varchar2(100),
	name varchar2(50) NOT null,
    phone varchar(20),
	password varchar2(100) NOT null,
    reg_date Date NOT null,
    role_id number(1) DEFAULT 0
);

/*회원정보 id(num) 생성 시퀀스*/
CREATE SEQUENCE member_seq
INCREMENT BY 1
START WITH 1001
MINVALUE 1
MAXVALUE 999999999
NOCYCLE
NOCACHE
NOORDER;
    
/*회원권한 설정 테이블*/
CREATE TABLE ROLE(
	id number(1),
	role_name varchar2(20)
);

/*회원 권한 컬럼 입*/
INSERT INTO role (id, role_name ) VALUES (0, 'member') ;
INSERT INTO role (id, role_name ) VALUES (1, 'admin' ) ;
INSERT INTO role (id, role_name ) VALUES (2, 'nonmember') ;
