/*
 * Reservation.sql
 * 예약정보 테이블 생성 (oracle xe 11g)
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-24 최종수정 : 2022-12-6
 *
 */


/*예약정보 테이블 생성*/
CREATE TABLE reservation(
	id number(2) PRIMARY KEY, 			/*예약정보 방*/
	reservation_name varchar2(40) NOT NULL,  	/*예약정보 이름*/
	capacity number(3),  				/*예약정보 방의 좌석수 default 1*/
	time_open varchar2(4),   			/*시작시간*/
	time_close varchar2(4),   			/*종료시간*/
	time_interval varchar2(4),			/*주문단위(시간)*/
	minimum_order varchar2(4)			/*최소주문(시간)*/
);

CREATE SEQUENCE reservation_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 99;

/*예약정보 시간 테이블 생성*/
/**/

CREATE TABLE time_policy(
	id number(3) PRIMARY KEY,
	reservation_id number(2),
	time_start varchar2(4) NOT NULL,
	price number(8),
	CONSTRAINT fk_tp_reservation_id FOREIGN key(reservation_id)
	REFERENCES reservation(id)
);

CREATE SEQUENCE time_policy_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 999;


/*예약정보 테이블 생성*/

CREATE TABLE order_detail(
	id number(10) PRIMARY KEY,
	member_id number(10),
	reservation_id number(2) NOT null,
    reservation_date Date NOT null,
    time_start varchar2(4) NOT null,
    time_end varchar2(4) NOT null,
    enabled_yn number(1) DEFAULT 1,
    expired_yn number(1) DEFAULT 0,
	reg_date Date DEFAULT SYSDATE,
	CONSTRAINT fk_order_member_id FOREIGN key(member_id)
	REFERENCES member(id),
	CONSTRAINT fk_order_reservation_id FOREIGN key(reservation_id)
	REFERENCES reservation(id)
);

CREATE SEQUENCE order_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 999999999;



/*예약시간 테이블 생성*/
/**/
CREATE TABLE order_time(
	order_id number(10) ,
	t_id number(3),
	CONSTRAINT fk_ot_order_id FOREIGN key(order_id)
	REFERENCES order_detail(id),
	CONSTRAINT fk_ot_t_id FOREIGN key(t_id)
	REFERENCES time_policy(id)
);

/*order view*/
/**/
CREATE VIEW order_view AS (
	SELECT
		od.*,
		m.name AS member_name,
		m.email AS member_email,
		m.phone AS member_phone,
		r.RESERVATION_NAME AS reservation_name
	FROM ORDER_DETAIL od
	INNER JOIN member m ON m.id= od.MEMBER_ID
	INNER JOIN  RESERVATION r ON r.id= od.RESERVATION_ID 
)

