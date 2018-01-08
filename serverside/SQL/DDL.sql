DROP TABLE Md_Category;
DROP TABLE M_Category;
DROP TABLE M_QNA_ANSWER;
DROP TABLE M_QNA;
DROP TABLE M_Rating;
DROP TABLE M_Comment;
DROP TABLE M_User;
DROP TABLE M_Product;
DROP TABLE M_Admin;

/* 상품 */
CREATE TABLE M_Product (
	product_number NUMBER NOT NULL, /* 상품번호 */
	product_title VARCHAR2(100) NOT NULL, /* 제목 */
	product_name VARCHAR2(100) NOT NULL, /* 상품명 */
	product_price NUMBER NOT NULL, /* 상품가격 */
	product_content VARCHAR2(4000) NOT NULL, /* 상품설명 */
	product_url VARCHAR2(255), /* 상품사진 */
	product_date DATE, /* 등록날짜 */
	c_id NUMBER, /* 대분류번호 */
	d_id NUMBER /* 소분류번호 */
);

CREATE UNIQUE INDEX PK_M_Product
	ON M_Product (
		product_number ASC
	);

ALTER TABLE M_Product
	ADD
		CONSTRAINT PK_M_Product
		PRIMARY KEY (
			product_number
		);

/* 유저 */
CREATE TABLE M_User (
	user_number NUMBER NOT NULL, /* 유저번호 */
	user_nickname VARCHAR2(32) NOT NULL, /* 유저별명 */
	user_id VARCHAR2(60) NOT NULL, /* 유저ID */
	user_pwd VARCHAR2(60) NOT NULL, /* 유저PWD */
	user_gender NUMBER NOT NULL, /* 유저성별 */
	user_birth DATE NOT NULL /* 유저생일 */
);

CREATE UNIQUE INDEX PK_M_User
	ON M_User (
		user_number ASC
	);

ALTER TABLE M_User
	ADD
		CONSTRAINT PK_M_User
		PRIMARY KEY (
			user_number
		);

/* 관리자 */
CREATE TABLE M_Admin (
	admin_number NUMBER NOT NULL, /* 관리자번호 */
	admin_id VARCHAR2(60) NOT NULL, /* 관리자ID */
	admin_pwd VARCHAR2(60) NOT NULL /* 관리자PWD */
);

CREATE UNIQUE INDEX PK_M_Admin
	ON M_Admin (
		admin_number ASC
	);

ALTER TABLE M_Admin
	ADD
		CONSTRAINT PK_M_Admin
		PRIMARY KEY (
			admin_number
		);

/* 질문 */
CREATE TABLE M_QNA (
	qna_number NUMBER NOT NULL, /* 질문번호 */
	user_number NUMBER NOT NULL, /* 유저번호 */
	qna_title VARCHAR2(100), /* 질문제목 */
	qna_content VARCHAR2(4000), /* 질문내용 */
	qna_date DATE /* 질문등록일 */
);

CREATE UNIQUE INDEX PK_M_QNA
	ON M_QNA (
		qna_number ASC
	);

ALTER TABLE M_QNA
	ADD
		CONSTRAINT PK_M_QNA
		PRIMARY KEY (
			qna_number
		);

/* 답변 */
CREATE TABLE M_QNA_ANSWER (
	answer_id NUMBER NOT NULL, /* 답변번호 */
	qna_number NUMBER NOT NULL, /* 질문번호 */
	answer_content VARCHAR2(4000) NOT NULL, /* 답변내용 */
	answer_date DATE /* 답변등록일 */
);

CREATE UNIQUE INDEX PK_M_QNA_ANSWER
	ON M_QNA_ANSWER (
		answer_id ASC
	);

ALTER TABLE M_QNA_ANSWER
	ADD
		CONSTRAINT PK_M_QNA_ANSWER
		PRIMARY KEY (
			answer_id
		);

/* 댓글 */
CREATE TABLE M_Comment (
	cmt_number NUMBER NOT NULL, /* 댓글번호 */
	product_number NUMBER NOT NULL, /* 상품번호 */
	user_number NUMBER NOT NULL, /* 유저번호 */
	cmt_content VARCHAR2(400) NOT NULL, /* 댓글내용 */
	cmt_date DATE /* 댓글등록일 */
);

CREATE UNIQUE INDEX PK_M_Comment
	ON M_Comment (
		cmt_number ASC
	);

ALTER TABLE M_Comment
	ADD
		CONSTRAINT PK_M_Comment
		PRIMARY KEY (
			cmt_number
		);

/* 대분류_카테고리 */
CREATE TABLE M_Category (
	c_id NUMBER NOT NULL, /* 대분류번호 */
	c_name VARCHAR2(20) NOT NULL /* 대분류명 */
);

CREATE UNIQUE INDEX PK_M_Category
	ON M_Category (
		c_id ASC
	);

ALTER TABLE M_Category
	ADD
		CONSTRAINT PK_M_Category
		PRIMARY KEY (
			c_id
		);

/* 별점 */
CREATE TABLE M_Rating (
	r_number NUMBER NOT NULL, /* 별점번호 */
	user_r_get NUMBER NOT NULL, /* 별점받은유저 */
	user_r_give NUMBER NOT NULL, /* 별점준유저 */
	r_score NUMBER NOT NULL, /* 별점 */
	r_content VARCHAR2(400) NOT NULL, /* 별점내용 */
	r_date DATE /* 별점등록일 */
);

CREATE UNIQUE INDEX PK_M_Rating
	ON M_Rating (
		r_number ASC
	);

ALTER TABLE M_Rating
	ADD
		CONSTRAINT PK_M_Rating
		PRIMARY KEY (
			r_number
		);

/* 소분류_카테고리 */
CREATE TABLE Md_Category (
	d_id NUMBER NOT NULL, /* 소분류번호 */
	d_name VARCHAR2(40) NOT NULL, /* 소분류명 */
	c_id NUMBER NOT NULL /* 대분류번호 */
);

CREATE UNIQUE INDEX PK_Md_Category
	ON Md_Category (
		d_id ASC
	);

ALTER TABLE Md_Category
	ADD
		CONSTRAINT PK_Md_Category
		PRIMARY KEY (
			d_id
		);

ALTER TABLE M_Product
	ADD
		CONSTRAINT FK_M_Category_TO_M_Product
		FOREIGN KEY (
			c_id
		)
		REFERENCES M_Category (
			c_id
		);

ALTER TABLE M_Product
	ADD
		CONSTRAINT FK_Md_Category_TO_M_Product
		FOREIGN KEY (
			d_id
		)
		REFERENCES Md_Category (
			d_id
		);

ALTER TABLE M_QNA
	ADD
		CONSTRAINT FK_M_User_TO_M_QNA
		FOREIGN KEY (
			user_number
		)
		REFERENCES M_User (
			user_number
		);

ALTER TABLE M_QNA_ANSWER
	ADD
		CONSTRAINT FK_M_QNA_TO_M_QNA_ANSWER
		FOREIGN KEY (
			qna_number
		)
		REFERENCES M_QNA (
			qna_number
		);

ALTER TABLE M_Comment
	ADD
		CONSTRAINT FK_M_User_TO_M_Comment
		FOREIGN KEY (
			user_number
		)
		REFERENCES M_User (
			user_number
		);

ALTER TABLE M_Comment
	ADD
		CONSTRAINT FK_M_Product_TO_M_Comment
		FOREIGN KEY (
			product_number
		)
		REFERENCES M_Product (
			product_number
		);

ALTER TABLE M_Rating
	ADD
		CONSTRAINT FK_M_User_TO_M_Rating
		FOREIGN KEY (
			user_r_get
		)
		REFERENCES M_User (
			user_number
		);

ALTER TABLE M_Rating
	ADD
		CONSTRAINT FK_M_User_TO_M_Rating2
		FOREIGN KEY (
			user_r_give
		)
		REFERENCES M_User (
			user_number
		);

ALTER TABLE Md_Category
	ADD
		CONSTRAINT FK_M_Category_TO_Md_Category
		FOREIGN KEY (
			c_id
		)
		REFERENCES M_Category (
			c_id
		);