/*
 * crudForMember.sql
 * 회원정보  입력,조회,수정,삭제를 위한 쿼리작성 (oracle xe 11g)
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-24 최종수정 : 2022-11-24
 *
 */


/* create*/
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
 
 
