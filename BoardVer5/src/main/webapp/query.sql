CREATE TABLE t_board_cmt (
	icmt INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	iboard INT UNSIGNED,
	iuser INT UNSIGNED,	
	cmt VARCHAR(400) NOT NULL,
	regdate DATE DEFAULT NOW(),
	FOREIGN KEY (iboard) REFERENCES t_board(iboard),
	FOREIGN KEY (iuser) REFERENCES t_user(iuser)
);