USE userDB;
SHOW TABLES;
DROP TABLE tbl_roles;
DROP TABLE tbl_users;

SELECT * FROM tbl_users;
SELECT * FROM tbl_roles;

DELETE FROM tbl_users WHERE username = 'cla'

SELECT * FROM tbl_users U
JOIN tbl_roles R
ON U.username = R.r_username;