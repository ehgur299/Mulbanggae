SELECT * FROM user_info;
SELECT * FROM notice;

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'ADMIN');

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'USER');

INSERT INTO user_info (user_number, user_nickname, user_id, user_pwd, user_gender, user_birth)
VALUES (user_info_seq.NEXTVAL, '관리자', 'admin' , '1234', '남자', '19990101')

INSERT INTO user_info (user_number, user_nickname, user_id, user_pwd, user_gender, user_birth)
VALUES (user_info_seq.NEXTVAL, '관리자', 'admin01' , '$2a$10$H2cNj1Wzao05jMLDLHyQr.kZXoOyGc4pQwEyw79QEDqX6DE26j87u', '남자', '00000000')

SELECT u.user_number as "UNUMBER", u.user_nickname, u.user_id, u.user_pwd, u.user_gender, u.user_birth, ut.ut_number, ut.ut_type
FROM user_info u,
(SELECT user_info_type.user_number, user_type.ut_number, user_type.ut_type
FROM user_info_type, user_type
WHERE user_type.ut_number = user_info_type.ut_number) ut
WHERE u.user_number = ut.user_number AND u.user_number = 25;

INSERT INTO user_info_type(user_number, ut_number)
VALUES (1, 1);

INSERT INTO user_info_type(user_number, ut_number)
VALUES (21, 1);

INSERT INTO user_info_type(user_number, ut_number)
VALUES (1, 1);

SELECT u.user_number as "UNUMBER", u.user_nickname, u.user_id, u.user_pwd, u.user_gender, u.user_birth, ut.ut_number, ut.ut_type
FROM user_info u,
(SELECT user_info_type.user_number, user_type.ut_number, user_type.ut_type
FROM user_info_type, user_type
WHERE user_type.ut_number = user_info_type.ut_number) ut
WHERE u.user_number = ut.user_number AND u.user_id = 'admin01';

INSERT INTO notice (n_number, n_title, n_content, n_url, n_date, user_number)
VALUES (notice_seq.NEXTVAL, '테스트입니다', '테스트입니다', NULL, SYSDATE, 1)

SELECT n.n_number, n_title, n_content, n_url, n_date, u.user_nickname
FROM notice n, user_info u
WHERE n.user_number = u.user_number ORDER BY n.n_number DESC

SELECT u.user_number as "UNUMBER", u.user_nickname, u.user_id, u.user_pwd, u.user_gender, u.user_birth, ut.ut_number, ut.ut_type
FROM user_info u,
(SELECT user_info_type.user_number, user_type.ut_number, user_type.ut_type
FROM user_info_type, user_type
WHERE user_type.ut_number = user_info_type.ut_number) ut
WHERE u.user_number = ut.user_number AND u.user_number = 1;