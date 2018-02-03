SELECT * FROM user_info;
SELECT * FROM notice;
SELECT * FROM USER_TYPE;
SELECT * FROM M_CATEGORY;
SELECT * FROM M_PRODUCT;

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'ADMIN');

INSERT INTO user_type(ut_number, ut_type)
VALUES (user_type_seq.NEXTVAL, 'USER');

INSERT INTO M_Category(c_id, c_name)
VALUES (category_seq.NEXTVAL, '의류');

INSERT INTO user_info (user_number, user_nickname, user_id, user_pwd, user_gender, user_birth)
VALUES (user_info_seq.NEXTVAL, '관리자', 'admin01' , '$2a$10$H2cNj1Wzao05jMLDLHyQr.kZXoOyGc4pQwEyw79QEDqX6DE26j87u', '남자', '00000000')

INSERT INTO m_product (product_number, product_title, product_name, product_price, product_content, product_url, product_date, user_number, c_id)
VALUES (product_seq.NEXTVAL, '테스트입니다', '테스트입니다', 10000, '테스트입니다', NULL, SYSDATE, 1, 1);

SELECT * FROM M_Product
  		ORDER BY product_number DESC

SELECT p.product_number, p.product_title, p.product_name, p.product_price, p.product_content, p.product_url, p.product_date, u.user_nickname, c.c_name
FROM m_product p, user_info u, m_category c 
WHERE p.user_number = u.user_number ORDER BY p.product_number DESC