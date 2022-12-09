/*
 * 테스트 쿼리
 * 
 *
 */

INSERT INTO member(
     id, email, password, phone, name, role_id, reg_date
  ) VALUES(
     member_seq.nextval,
     'email@aaa.bbb',
     '1414',
     '000-11111-22222',
     'dlgustn',
     (SELECT 
        id 
       FROM role 
       WHERE role_name= 'member'
     ),
     sysdate
  )
  
	
  SELECT * FROM role
  SELECT * FROM member


  UPDATE MEMBER
  SET role_id = 1
  WHERE email = 'yzhs.go@gmail.com';
 
  UPDATE role
  SET role_name = 'ROLE_NONMEMBER'
  WHERE id =2;
 
 
 SELECT 
         id,
         email,
         name,
         password,
         reg_date,
         (SELECT 
            role_name
         FROM 
            role r
            where r.id = role_id) AS role
      FROM member
      WHERE
        email = 'yzhs.go@gmail.com'


SELECT publish FROM board WHERE id=3
UPDATE board
SET publish = 1 - (
    SELECT publish FROM board WHERE id = 3
    )
WHERE id = 3

        
SELECT r, id, title, user_name, reg_date, edit_date, publish, hit
        FROM 
        	(
        	SELECT rownum as r, id, title, user_name, reg_date, edit_date, publish, hit
			FROM
                (
                SELECT * FROM board
                WHERE
                    title LIKE '%%'
                ORDER by id DESC
                )
            WHERE ROWNUM  < 16
        )
        WHERE
            r >8 
            
            
            
SELECT
	TEMP_ID AS id, 
	TEMP_TITLE AS title
	FROM (
		SELECT
			id,
			LAG(id) OVER(ORDER BY id) AS TEMP_ID,
			LAG(title) OVER(ORDER BY id) AS TEMP_TITLE
		FROM board
		) b
		
		
SELECT * FROM RESERVATION r ;

DELETE FROM RESERVATION r WHERE r.ID =3;

SELECT * FROM time_policy;
DELETE FROM time_policy
WHERE id=1;

ALTER TABLE ORDER_TIME DROP COLUMN room_name;

ALTER TABLE ORDER_TIME DROP COLUMN disabled;
ALTER TABLE ORDER_TIME ADD(enabled_yn number(1) DEFAULT 1);