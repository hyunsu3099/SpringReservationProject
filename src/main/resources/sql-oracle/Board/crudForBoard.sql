/*
 * crudForBoard.sql
 * 게시판 테이블 관리 (oracle 11g xe)
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-29 최종수정 : 2022-11-29
 */

/*조회 select*/
SELECT id, title, user_name, reg_date, edit_date, publish, hit
        FROM board
        WHERE
            rownum &lt; #{limit} 
		    AND rownum &gt; #{offset}
            AND ${key} LIKE '%${val}%'
            <if test = "!#{isAdmin}">AND publish=1</if>
            ORDER by id DESC
    

/*게시 insert*/
/* create*/
INSERT INTO board(
	id, 
	user_name,
	title,
	content,
	reg_date,
	edit_date,
	publish
)VALUES(
	board_seq.nextval,
	'yzhs' ,
	'안녕하세' ,
	'bs내용입니다 ',
	sysdate ,
	sysdate ,
	1
);



/*이전글 다음*/
SELECT  id, title
FROM board
WHERE 
    rownum = 
        (
            SELECT rownum FROM board 
            WHERE id = #{id}
            <if test = "!#{isAdmin}">AND publish=1</if>
        )+1
<if test = "!#{isAdmin}">AND publish=1</if>



/*publish 전*/
SELECT publish FROM board WHERE id=3
UPDATE board
SET publish = 1 - (
    SELECT publish FROM board WHERE id = 3
    )
WHERE id = 3