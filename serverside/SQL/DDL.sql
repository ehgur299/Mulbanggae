drop TABLE M_CATEGORY;

drop SEQUENCE notice_seq;
drop SEQUENCE user_info_seq;
drop SEQUENCE user_type_seq;
drop SEQUENCE product_seq;
drop SEQUENCE category_seq;
drop SEQUENCE comment_seq;

CREATE SEQUENCE notice_seq
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE user_info_seq
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE user_type_seq
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE product_seq
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE category_seq
START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE comment_seq
START WITH 1 INCREMENT BY 1;