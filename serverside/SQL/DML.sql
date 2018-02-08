SELECT * FROM user_info;
SELECT * FROM notice;
SELECT * FROM USER_TYPE;
SELECT * FROM M_CATEGORY;
SELECT * FROM M_PRODUCT;
SELECT * FROM M_COMMENT;

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'ADMIN');

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'USER');

INSERT INTO user_info (user_number, user_nickname, user_id, user_pwd, user_gender, user_birth)
VALUES (user_info_seq.NEXTVAL, '관리자', 'admin01' , '$2a$10$H2cNj1Wzao05jMLDLHyQr.kZXoOyGc4pQwEyw79QEDqX6DE26j87u', '남자', '00000000')

INSERT INTO user_info_type(user_number, ut_number)
VALUES (1, 1);

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

		SELECT c.cmt_number, c.product_number, c.user_number, c.cmt_content, c.cmt_date, u.user_nickname
  		FROM M_Comment c,USER_INFO u 
  		WHERE product_number = 21 and c.user_number = u.user_number 
  		ORDER BY cmt_number DESC

INSERT INTO M_Comment(cmt_number, product_number, user_number, cmt_content, cmt_date)
  		VALUES( #{cmt_num}, #{product_num}, #{user_num}, #{cmt_content}, SYSDATE)
  		
		UPDATE user_info 
		SET user_nickname = #{nickname}, user_pwd = #{pwd}
		WHERE user_number = #{no}
		
SELECT u.user_number as "UNUMBER", u.user_nickname, u.user_id, u.user_pwd, u.user_gender, u.user_birth, ut.ut_number, ut.ut_type
		FROM user_info u,
			(SELECT user_info_type.user_number, user_type.ut_number, user_type.ut_type
			FROM user_info_type, user_type
			WHERE user_type.ut_number = user_info_type.ut_number) ut
		WHERE u.user_number = ut.user_number AND u.user_number = 2
		
UPDATE m_product
		SET product_title = 'adsf', product_name = 'asdf', product_price =
		300, product_content = 'asdfasdf', product_url = null,
		product_date = SYSDATE
		WHERE product_number = 23