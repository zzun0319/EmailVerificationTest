CREATE TABLE user_test(
	user_id VARCHAR(20) PRIMARY KEY,
    user_pw VARCHAR(30) NOT NULL,
    user_email VARCHAR(40) NOT NULL UNIQUE,
    user_email_hash VARCHAR(64),
    user_email_checked INT NOT NULL DEFAULT 0
);

TRUNCATE TABLE user_test;

SELECT * FROM user_test;
DESC user_test;
COMMIT;

ALTER TABLE UserTest ADD user_email_hash VARCHAR(64);
ALTER TABLE UserTest DROP user_email_checked;
ALTER TABLE UserTest ADD user_email_checked BOOL NOT NULL DEFAULT 0;

ALTER TABLE user_test MODIFY user_email_checked BOOL NOT NULL DEFAULT FALSE;