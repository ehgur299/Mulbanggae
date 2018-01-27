INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'ADMIN');

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'USER');

INSERT INTO user_info (user_number, user_nickname, user_id, user_pwd, user_gender, user_birth)
VALUES (user_info_seq.NEXTVAL, '관리자', 'admin' , '1234', '남자', '19990101')

SELECT u.user_number as "UNUMBER", u.user_nickname, u.user_id, u.user_pwd, u.user_gender, u.user_birth, ut.ut_number, ut.ut_type
FROM user_info u,
(SELECT user_info_type.user_number, user_type.ut_number, user_type.ut_type
FROM user_info_type, user_type
WHERE user_type.ut_number = user_info_type.ut_number) ut
WHERE u.user_number = ut.user_number AND u.user_number = 1;

INSERT INTO user_info_type(user_number, ut_number)
VALUES (1, 1);

SELECT u.user_number as "UNUMBER", u.user_nickname, u.user_id, u.user_pwd, u.user_gender, u.user_birth, ut.ut_number, ut.ut_type
FROM user_info u,
(SELECT user_info_type.user_number, user_type.ut_number, user_type.ut_type
FROM user_info_type, user_type
WHERE user_type.ut_number = user_info_type.ut_number) ut
WHERE u.user_number = ut.user_number AND u.user_id = 'admin';