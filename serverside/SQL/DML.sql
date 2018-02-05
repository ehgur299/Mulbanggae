SELECT * FROM user_info;
SELECT * FROM notice;
SELECT * FROM USER_TYPE;
SELECT * FROM M_CATEGORY;
SELECT * FROM M_PRODUCT;

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'ADMIN');

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'USER');

INSERT INTO user_info (user_number, user_nickname, user_id, user_pwd, user_gender, user_birth)
VALUES (user_info_seq.NEXTVAL, '관리자', 'admin01' , '$2a$10$H2cNj1Wzao05jMLDLHyQr.kZXoOyGc4pQwEyw79QEDqX6DE26j87u', '남자', '00000000')

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '의류');

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '스포츠/레저');

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '디지털/가전');

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '도서/취미');

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '차량/오토바이');

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '생활/가구');

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '유아동/출산');

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '기타');