INSERT INTO reservation(
	id,
	room_name,
	capacity,
	time_open,
	time_close ,
	time_interval,
	minimum_order)
VALUES(
	reservation_seq.nextval,
	'장비A',
	1,
	'0900',
	'2200',
	'0030',
	'0100'
);


INSERT INTO reservation(
	id,
	room_name,
	capacity,
	time_open,
	time_close ,
	time_interval,
	minimum_order)
VALUES(
	reservation_seq.nextval,
	'앰프',
	3,
	'0900',
	'1800',
	'0030',
	'0100'
);

INSERT INTO reservation(
	id,
	room_name,
	capacity,
	time_open,
	time_close ,
	time_interval,
	minimum_order)
VALUES(
	reservation_seq.nextval,
	'CAM',
	3,
	'0900',
	'1800',
	'0030',
	'0100'
);


String sql= "INSERT INTO time_policy("+
                "id, "+
                "reservation_id, "+
                "time_start "+
            ")values( "+
                "time_policy_seq.nextval, "+
                "?, "+
                "?)";

