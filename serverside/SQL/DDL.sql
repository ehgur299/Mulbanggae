/* 게시글 */
CREATE TABLE Shop_Board (
	bNum NUMBER NOT NULL, /* 게시물번호 */
	sNum NUMBER NOT NULL, /* 유저번호 */
	bTitle NVARCHAR2(30) NOT NULL, /* 게시물제목 */
	bContent NVARCHAR2(800) NOT NULL, /* 게시물내용 */
	bPIC NVARCHAR2(255) NOT NULL, /* 게시물이미지 */
	bRegdate DATE NOT NULL /* 게시날짜 */
);

COMMENT ON TABLE Shop_Board IS '게시글';

COMMENT ON COLUMN Shop_Board.bNum IS '게시물번호';

COMMENT ON COLUMN Shop_Board.sNum IS '유저번호';

COMMENT ON COLUMN Shop_Board.bTitle IS '게시물제목';

COMMENT ON COLUMN Shop_Board.bContent IS '게시물내용';

COMMENT ON COLUMN Shop_Board.bPIC IS '게시물이미지';

COMMENT ON COLUMN Shop_Board.bRegdate IS '게시날짜';

CREATE UNIQUE INDEX PK_Shop_Board
	ON Shop_Board (
		bNum ASC
	);

ALTER TABLE Shop_Board
	ADD
		CONSTRAINT PK_Shop_Board
		PRIMARY KEY (
			bNum
		);

/* 사용자 */
CREATE TABLE Shop_User (
	sNum NUMBER NOT NULL, /* 유저번호 */
	sID NVARCHAR2(20) NOT NULL, /* 유저아이디 */
	sPWD NVARCHAR2(20) NOT NULL, /* 유저비밀번호 */
	sGender NUMBER NOT NULL, /* 유저성별 */
	sBirth NVARCHAR2(8) NOT NULL /* 유저생일 */
);

COMMENT ON TABLE Shop_User IS '사용자';

COMMENT ON COLUMN Shop_User.sNum IS '유저번호';

COMMENT ON COLUMN Shop_User.sID IS '유저아이디';

COMMENT ON COLUMN Shop_User.sPWD IS '유저비밀번호';

COMMENT ON COLUMN Shop_User.sGender IS '유저성별';

COMMENT ON COLUMN Shop_User.sBirth IS '유저생일';

CREATE UNIQUE INDEX PK_Shop_User
	ON Shop_User (
		sNum ASC
	);

ALTER TABLE Shop_User
	ADD
		CONSTRAINT PK_Shop_User
		PRIMARY KEY (
			sNum
		);

/* 카테고리 */
CREATE TABLE SCategory (
	ctgNum NUMBER NOT NULL, /* 카테고리번호 */
	ctgName NVARCHAR2(8) NOT NULL /* 카테고리명 */
);

COMMENT ON TABLE SCategory IS '카테고리';

COMMENT ON COLUMN SCategory.ctgNum IS '카테고리번호';

COMMENT ON COLUMN SCategory.ctgName IS '카테고리명';

CREATE UNIQUE INDEX PK_SCategory
	ON SCategory (
		ctgNum ASC
	);

ALTER TABLE SCategory
	ADD
		CONSTRAINT PK_SCategory
		PRIMARY KEY (
			ctgNum
		);

/* 게시글_카테고리 */
CREATE TABLE B_Category (
	bNum NUMBER NOT NULL, /* 게시물번호 */
	ctgNum NUMBER NOT NULL /* 카테고리번호 */
);

COMMENT ON TABLE B_Category IS '게시글_카테고리';

COMMENT ON COLUMN B_Category.bNum IS '게시물번호';

COMMENT ON COLUMN B_Category.ctgNum IS '카테고리번호';

CREATE UNIQUE INDEX PK_B_Category
	ON B_Category (
		bNum ASC
	);

ALTER TABLE B_Category
	ADD
		CONSTRAINT PK_B_Category
		PRIMARY KEY (
			bNum
		);

/* 게시글_댓글 */
CREATE TABLE B_Comment (
	bNum NUMBER NOT NULL, /* 게시물번호 */
	sNum NUMBER NOT NULL, /* 유저번호 */
	cContent NVARCHAR2(100) NOT NULL, /* 댓글내용 */
	cDate DATE NOT NULL /* 댓글날짜 */
);

COMMENT ON TABLE B_Comment IS '게시글_댓글';

COMMENT ON COLUMN B_Comment.bNum IS '게시물번호';

COMMENT ON COLUMN B_Comment.sNum IS '유저번호';

COMMENT ON COLUMN B_Comment.cContent IS '댓글내용';

COMMENT ON COLUMN B_Comment.cDate IS '댓글날짜';

CREATE UNIQUE INDEX PK_B_Comment
	ON B_Comment (
		bNum ASC
	);

ALTER TABLE B_Comment
	ADD
		CONSTRAINT PK_B_Comment
		PRIMARY KEY (
			bNum
		);

/* 게시글_별점 */
CREATE TABLE B_Rating (
	bNum NUMBER NOT NULL, /* 게시물번호 */
	sNum NUMBER NOT NULL, /* 유저번호 */
	rRating NUMBER NOT NULL /* 별점 */
);

COMMENT ON TABLE B_Rating IS '게시글_별점';

COMMENT ON COLUMN B_Rating.bNum IS '게시물번호';

COMMENT ON COLUMN B_Rating.sNum IS '유저번호';

COMMENT ON COLUMN B_Rating.rRating IS '별점';

CREATE UNIQUE INDEX PK_B_Rating
	ON B_Rating (
		bNum ASC
	);

ALTER TABLE B_Rating
	ADD
		CONSTRAINT PK_B_Rating
		PRIMARY KEY (
			bNum
		);

/* 사용자_열람횟수집계 */
CREATE TABLE U_Favorites (
	sNum NUMBER NOT NULL, /* 유저번호 */
	ctgNum NUMBER NOT NULL, /* 카테고리번호 */
	ufCount NUMBER /* 본횟수 */
);

COMMENT ON TABLE U_Favorites IS '사용자_열람횟수집계';

COMMENT ON COLUMN U_Favorites.sNum IS '유저번호';

COMMENT ON COLUMN U_Favorites.ctgNum IS '카테고리번호';

COMMENT ON COLUMN U_Favorites.ufCount IS '본횟수';

CREATE UNIQUE INDEX PK_U_Favorites
	ON U_Favorites (
		sNum ASC
	);

ALTER TABLE U_Favorites
	ADD
		CONSTRAINT PK_U_Favorites
		PRIMARY KEY (
			sNum
		);

/* QnA_질문 */
CREATE TABLE Qna_Question (
	qNum NUMBER NOT NULL, /* 질문번호 */
	sNum NUMBER NOT NULL, /* 유저번호 */
	qTitle NVARCHAR2(30) NOT NULL, /* 질문제목 */
	qContent NVARCHAR2(200) NOT NULL, /* 질문내용 */
	qStatus NUMBER /* 답변상태 */
);

COMMENT ON TABLE Qna_Question IS 'QnA_질문';

COMMENT ON COLUMN Qna_Question.qNum IS '질문번호';

COMMENT ON COLUMN Qna_Question.sNum IS '유저번호';

COMMENT ON COLUMN Qna_Question.qTitle IS '질문제목';

COMMENT ON COLUMN Qna_Question.qContent IS '질문내용';

COMMENT ON COLUMN Qna_Question.qStatus IS '답변상태';

CREATE UNIQUE INDEX PK_Qna_Question
	ON Qna_Question (
		qNum ASC
	);

ALTER TABLE Qna_Question
	ADD
		CONSTRAINT PK_Qna_Question
		PRIMARY KEY (
			qNum
		);

/* QnA_답변 */
CREATE TABLE Qna_answer (
	qNum NUMBER NOT NULL, /* 질문번호 */
	qaContent NVARCHAR2(200) NOT NULL, /* 답변내용 */
	qaDate DATE NOT NULL /* 답변날짜 */
);

COMMENT ON TABLE Qna_answer IS 'QnA_답변';

COMMENT ON COLUMN Qna_answer.qNum IS '질문번호';

COMMENT ON COLUMN Qna_answer.qaContent IS '답변내용';

COMMENT ON COLUMN Qna_answer.qaDate IS '답변날짜';

/* 관리자 */
CREATE TABLE Admin (
	aNum NUMBER NOT NULL, /* 관리자번호 */
	aID NVARCHAR2(20) NOT NULL, /* 관리자아이디 */
	aPWD NVARCHAR2(20) NOT NULL /* 관리자비밀번호 */
);

COMMENT ON TABLE Admin IS '관리자';

COMMENT ON COLUMN Admin.aNum IS '관리자번호';

COMMENT ON COLUMN Admin.aID IS '관리자아이디';

COMMENT ON COLUMN Admin.aPWD IS '관리자비밀번호';

CREATE UNIQUE INDEX PK_Admin
	ON Admin (
		aNum ASC
	);

ALTER TABLE Admin
	ADD
		CONSTRAINT PK_Admin
		PRIMARY KEY (
			aNum
		);

ALTER TABLE Shop_Board
	ADD
		CONSTRAINT FK_Shop_User_TO_Shop_Board
		FOREIGN KEY (
			sNum
		)
		REFERENCES Shop_User (
			sNum
		);

ALTER TABLE B_Category
	ADD
		CONSTRAINT FK_Shop_Board_TO_B_Category
		FOREIGN KEY (
			bNum
		)
		REFERENCES Shop_Board (
			bNum
		);

ALTER TABLE B_Category
	ADD
		CONSTRAINT FK_SCategory_TO_B_Category
		FOREIGN KEY (
			ctgNum
		)
		REFERENCES SCategory (
			ctgNum
		);

ALTER TABLE B_Comment
	ADD
		CONSTRAINT FK_Shop_Board_TO_B_Comment
		FOREIGN KEY (
			bNum
		)
		REFERENCES Shop_Board (
			bNum
		);

ALTER TABLE B_Comment
	ADD
		CONSTRAINT FK_Shop_User_TO_B_Comment
		FOREIGN KEY (
			sNum
		)
		REFERENCES Shop_User (
			sNum
		);

ALTER TABLE B_Rating
	ADD
		CONSTRAINT FK_Shop_Board_TO_B_Rating
		FOREIGN KEY (
			bNum
		)
		REFERENCES Shop_Board (
			bNum
		);

ALTER TABLE B_Rating
	ADD
		CONSTRAINT FK_Shop_User_TO_B_Rating
		FOREIGN KEY (
			sNum
		)
		REFERENCES Shop_User (
			sNum
		);

ALTER TABLE U_Favorites
	ADD
		CONSTRAINT FK_Shop_User_TO_U_Favorites
		FOREIGN KEY (
			sNum
		)
		REFERENCES Shop_User (
			sNum
		);

ALTER TABLE U_Favorites
	ADD
		CONSTRAINT FK_SCategory_TO_U_Favorites
		FOREIGN KEY (
			ctgNum
		)
		REFERENCES SCategory (
			ctgNum
		);

ALTER TABLE Qna_Question
	ADD
		CONSTRAINT FK_Shop_User_TO_Qna_Question
		FOREIGN KEY (
			sNum
		)
		REFERENCES Shop_User (
			sNum
		);

ALTER TABLE Qna_answer
	ADD
		CONSTRAINT FK_Qna_Question_TO_Qna_answer
		FOREIGN KEY (
			qNum
		)
		REFERENCES Qna_Question (
			qNum
		);