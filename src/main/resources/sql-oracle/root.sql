/*
 * root.sql
 * 초기 데이터베이스 테이블 스페이스 생성
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-24 최종수정 : 2022-11-24
 *
 */

create tablespace ptpt
datafile '~\workspace\database\ptpt.dbf'
size 100m reuse
autoextend on next 100m
maxsize unlimited;

CREATE USER yzhs_ptpt
IDENTIFIED BY 111111
DEFAULT TABLESPACE ptpt
TEMPORARY TABLESPACE TEMP;

GRANT connect, resource, dba TO yzhs_ptpt;