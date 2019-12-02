/* �Խ��� */
CREATE TABLE board (
	idx NUMBER NOT NULL, /* �۹�ȣ */
	id VARCHAR2(16) NOT NULL, /* ���̵� */
	bcode NUMBER NOT NULL, /* �Խ����ڵ� */
	tcode NUMBER NOT NULL, /* �ŷ��ڵ� */
	title VARCHAR2(100) NOT NULL, /* ������ */
	content VARCHAR2(4000) NOT NULL, /* �۳��� */
	readnum NUMBER NOT NULL, /* ��ȸ�� */
	writedate TIMESTAMP NOT NULL, /* �ۼ��� */
	ref NUMBER NOT NULL, /* �׷��ȣ */
	dept NUMBER NOT NULL, /* �鿩���� */
	step NUMBER NOT NULL, /* �亯���� */
	cocode NUMBER NOT NULL /* �ۻ��� */
);

ALTER TABLE board
	ADD
		CONSTRAINT PK_board
		PRIMARY KEY (
			idx
		);

/* �Խ��� ���� */
CREATE TABLE b_list (
	bcode NUMBER NOT NULL, /* �Խ����ڵ� */
	bname VARCHAR2(100) NOT NULL, /* �Խ����̸� */
	typeno NUMBER NOT NULL, /* �Խ������Ĺ�ȣ */
	ccode NUMBER NOT NULL /* ī�װ��ڵ� */
);

ALTER TABLE b_list
	ADD
		CONSTRAINT PK_b_list
		PRIMARY KEY (
			bcode
		);

/* ��� */
CREATE TABLE reply (
	replyidx NUMBER NOT NULL, /* ��۽ĺ���ȣ */
	idx NUMBER NOT NULL, /* �۹�ȣ */
	replycontent VARCHAR2(500) NOT NULL, /* ��۳��� */
	replyid VARCHAR2(16) NOT NULL, /* ��۾��̵� */
	replydate TIMESTAMP NOT NULL, /* ����ۼ��� */
	cocode NUMBER /* �ۻ��� */
);

ALTER TABLE reply
	ADD
		CONSTRAINT PK_reply
		PRIMARY KEY (
			replyidx
		);

/* ���ϰԽ��� */
CREATE TABLE fileupload (
	fidx NUMBER NOT NULL, /* �ڷ�ǽĺ���ȣ */
	idx NUMBER NOT NULL, /* �۹�ȣ */
	oriname VARCHAR2(100), /* ���������̸� */
	savename VARCHAR2(110), /* ���������̸� */
	fsize NUMBER NOT NULL, /* ����ũ�� */
	cocode NUMBER /* �ۻ��� */
);

ALTER TABLE fileupload
	ADD
		CONSTRAINT PK_fileupload
		PRIMARY KEY (
			fidx
		);

/* ȸ�� */
CREATE TABLE member (
	id VARCHAR2(16) NOT NULL, /* ���̵� */
	pwd VARCHAR2(20) NOT NULL, /* ��й�ȣ */
	name VARCHAR2(10) NOT NULL, /* �̸� */
	hp VARCHAR2(13) NOT NULL, /* �ڵ�����ȣ */
	grade NUMBER NOT NULL /* ����ڵ� */
);

ALTER TABLE member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			id
		);

/* �� ��� */
CREATE TABLE zzim_list (
	id VARCHAR2(16) NOT NULL, /* ���̵� */
	campidx NUMBER /* ķ����ĺ���ȣ */
);

ALTER TABLE zzim_list
	ADD
		CONSTRAINT PK_zzim_list
		PRIMARY KEY (
			id
		);

/* ķ���� */
CREATE TABLE camp (
	contentid NUMBER NOT NULL, /* ķ����ĺ���ȣ */
	title VARCHAR2(50), /* ķ����� */
	addr1 VARCHAR2(200), /* ķ�����ּ� */
	tel VARCHAR(20), /* ķ������ȭ��ȣ */
	firstimage VARCHAR2(100) /* ķ�����̹��� */
);

ALTER TABLE camp
	ADD
		CONSTRAINT PK_camp
		PRIMARY KEY (
			contentid
		);

/* �Խ��� Ÿ�� */
CREATE TABLE b_type (
	btype_num NUMBER NOT NULL, /* �Խ������Ĺ�ȣ */
	btype_name VARCHAR2(100) NOT NULL /* �Խ���Ÿ�� */
);

ALTER TABLE b_type
	ADD
		CONSTRAINT PK_b_type
		PRIMARY KEY (
			btype_num
		);

/* �Խ��� ī�װ� */
CREATE TABLE b_cat (
	ccode NUMBER NOT NULL, /* ī�װ��ڵ� */
	cname VARCHAR2(100) NOT NULL /* ī�װ��̸� */
);

ALTER TABLE b_cat
	ADD
		CONSTRAINT PK_b_cat
		PRIMARY KEY (
			ccode
		);

/* ��۰Խ��� */
CREATE TABLE reboard (
	reboardidx NUMBER NOT NULL, /* ��۽ĺ���ȣ */
	idx NUMBER NOT NULL, /* �۹�ȣ */
	ref NUMBER NOT NULL, /* �׷��ȣ */
	dept NUMBER NOT NULL, /* �鿩���� */
	step NUMBER NOT NULL, /* �亯���� */
	reboardcount NUMBER NOT NULL /* ��۰��� */
);

ALTER TABLE reboard
	ADD
		CONSTRAINT PK_reboard
		PRIMARY KEY (
			reboardidx
		);

/* ������ */
CREATE TABLE adminmember (
	adminid VARCHAR2(16) NOT NULL, /* �����ھ��̵� */
	adminpwd VARCHAR2(20) NOT NULL, /* �����ں�й�ȣ */
	admingrade NUMBER NOT NULL /* �����ڵ�� */
);

ALTER TABLE adminmember
	ADD
		CONSTRAINT PK_adminmember
		PRIMARY KEY (
			adminid
		);

/* ȸ����� */
CREATE TABLE membergrade (
	grade NUMBER NOT NULL, /* ����ڵ� */
	gname VARCHAR2(50) NOT NULL /* ��޸� */
);

ALTER TABLE membergrade
	ADD
		CONSTRAINT PK_membergrade
		PRIMARY KEY (
			grade
		);

/* �ŷ��Խ��� */
CREATE TABLE trade (
	tcode NUMBER NOT NULL, /* �ŷ��ڵ� */
	tstatus VARCHAR2(50) NOT NULL /* �ŷ����� */
);

ALTER TABLE trade
	ADD
		CONSTRAINT PK_trade
		PRIMARY KEY (
			tcode
		);

/* �ۻ��� */
CREATE TABLE c_status (
	cocode NUMBER NOT NULL, /* �ۻ��� */
	coname VARCHAR2(40) NOT NULL /* ���¸� */
);

ALTER TABLE c_status
	ADD
		CONSTRAINT PK_c_status
		PRIMARY KEY (
			cocode
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_b_list_TO_board
		FOREIGN KEY (
			bcode
		)
		REFERENCES b_list (
			bcode
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_member_TO_board
		FOREIGN KEY (
			id
		)
		REFERENCES member (
			id
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_trade_TO_board
		FOREIGN KEY (
			tcode
		)
		REFERENCES trade (
			tcode
		);

ALTER TABLE board
	ADD
		CONSTRAINT FK_c_status_TO_board
		FOREIGN KEY (
			cocode
		)
		REFERENCES c_status (
			cocode
		);

ALTER TABLE b_list
	ADD
		CONSTRAINT FK_b_type_TO_b_list
		FOREIGN KEY (
			typeno
		)
		REFERENCES b_type (
			btype_num
		);

ALTER TABLE b_list
	ADD
		CONSTRAINT FK_b_cat_TO_b_list
		FOREIGN KEY (
			ccode
		)
		REFERENCES b_cat (
			ccode
		);

ALTER TABLE reply
	ADD
		CONSTRAINT FK_board_TO_reply
		FOREIGN KEY (
			idx
		)
		REFERENCES board (
			idx
		);

ALTER TABLE reply
	ADD
		CONSTRAINT FK_c_status_TO_reply
		FOREIGN KEY (
			cocode
		)
		REFERENCES c_status (
			cocode
		);

ALTER TABLE fileupload
	ADD
		CONSTRAINT FK_board_TO_fileupload
		FOREIGN KEY (
			idx
		)
		REFERENCES board (
			idx
		);

ALTER TABLE fileupload
	ADD
		CONSTRAINT FK_c_status_TO_fileupload
		FOREIGN KEY (
			cocode
		)
		REFERENCES c_status (
			cocode
		);

ALTER TABLE member
	ADD
		CONSTRAINT FK_membergrade_TO_member
		FOREIGN KEY (
			grade
		)
		REFERENCES membergrade (
			grade
		);

ALTER TABLE zzim_list
	ADD
		CONSTRAINT FK_member_TO_zzim_list
		FOREIGN KEY (
			id
		)
		REFERENCES member (
			id
		);

ALTER TABLE reboard
	ADD
		CONSTRAINT FK_board_TO_reboard
		FOREIGN KEY (
			idx
		)
		REFERENCES board (
			idx
		);

create sequence test1 ;/* �۹�ȣ ������ */
create sequence test2; /* �ڷ�ǽĺ���ȣ ������ */
create sequence replyseq; /* ��� ������ */