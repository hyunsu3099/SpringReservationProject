/*
 * crudForReservation.sql
 * 예약정보 입력,조회,수정,삭제를 위한 쿼리작성 (oracle xe 11g)
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-24 최종수정 : 2022-11-24
 *
 */


/* CREATE 예약 */
INSERT INTO reservation(
	id, 
	member_name, 
	reservation_date, 
	reservation_time,
	reservation_room
) values(
	2, 
	'yzhs', 
	TO_DATE('20221117', 'YYYYMMDD'), 
	'1200', 
	'A'
);

/* READ 예약조회 */
SELECT
	id, 
	member_name, 
	TO_CHAR(reservation_date , 'YYYYMMDD') as date_,
	reservation_room AS room,
	reservation_time AS time_,
	reservation_yn
FROM RESERVATION r
WHERE r.reservation_date BETWEEN 
	TO_DATE('20221116', 'YYYYMMDD')
	AND TO_DATE('20221123', 'YYYYMMDD') 
ORDER BY reservation_date asc,
	reservation_room asc,
	reservation_time ASC;


/*insert 예약상세 */
INSERT INTO ORDER_DETAIL 
(id,
member_id,
reservation_id,
reservation_date,
time_start,
time_end,
enabled_yn,
reg_date
)
VALUES
(
order_seq.nextval,
1003,
1,
to_date('20221220','yyyymmdd'),
'1200',
'1400',
1,
sysdate
)


/*insert 예약 time */
INSERT INTO ORDER_time 
(order_id, t_id)
VALUES
()